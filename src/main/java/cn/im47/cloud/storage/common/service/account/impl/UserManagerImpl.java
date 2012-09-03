package cn.im47.cloud.storage.common.service.account.impl;

import cn.im47.cloud.storage.common.dao.account.GroupMapper;
import cn.im47.cloud.storage.common.dao.account.UserMapper;
import cn.im47.cloud.storage.common.entity.account.Group;
import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.ServiceException;
import cn.im47.cloud.storage.common.service.account.UserManager;
import cn.im47.cloud.storage.jms.NotifyMessageProducer;
import cn.im47.cloud.storage.security.ShiroDbRealm;
import cn.im47.commons.utilities.RandomString;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 安全相关实体的管理类,包括用户和权限组.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com), pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-3-22
 * Time: 下午5:25
 */
@Component
@Transactional(readOnly = true)
public class UserManagerImpl implements UserManager {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    private static final Long DEFAULT_GROUP_ID = 3L;

    private UserMapper userMapper;

    private GroupMapper groupMapper;

    private NotifyMessageProducer notifyProducer; //JMS消息发送

    private ShiroDbRealm shiroRealm;

    public User get(Long id) {
        logger.debug("== Find user by id={}.", id);
        return userMapper.get(id);
    }

    @Transactional(readOnly = false)
    public int save(User user) {
        //如果邮箱被注册，将直接返回
        if (userMapper.isUsedEmail(user.getEmail()) > 0) {
            return 0;
        }
        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
        if (StringUtils.isNotBlank(user.getPlainPassword()) && shiroRealm != null) {
            ShiroDbRealm.HashPassword hashPassword = shiroRealm.encrypt(user.getPlainPassword());
            user.setSalt(hashPassword.getSalt());
            user.setPassword(hashPassword.getPassword());
        }

        //加入默认权限组 TODO
        List<Group> groupList = Lists.newArrayList();
        groupList.add(groupMapper.get(DEFAULT_GROUP_ID));
        user.setGroupList(groupList);

        user.setStatus(true);
        user.setPhotoURL("default.jpg");
        user.setLastIP(134744072L);
        user.setTimeOffset("0800");
        user.setLastTime(new Date());
        user.setLastActTime(new Date());

        // 发送通知邮件
        sendNotifyMessage(user);

        logger.debug("== Save user={}.", user.toString());
        return userMapper.save(user);
    }

    @Transactional(readOnly = false)
    public int update(User user) {
        if (isSupervisor(user)) {
            logger.warn("操作员{}尝试修改超级管理员用户", SecurityUtils.getSubject().getPrincipal());
            throw new ServiceException("不能修改超级管理员用户");
        }

        logger.debug("== Update user={}.", user);
        return userMapper.update(user);
    }

    @Transactional(readOnly = false)
    public int update(Long id, String column) {
        logger.debug("== Update user's #{} by id={}.", column, id);
        return userMapper.updateBool(id, column);
    }

    @Transactional(readOnly = false)
    public int delete() {
        logger.debug("== Delete user.");
        return userMapper.deleteByTask();
    }

    @Transactional(readOnly = false)
    public int delete(Long id) {
        // 判断用户是否为超级管理员
        if (id == 1) {
            logger.warn("操作员{}尝试删除超级管理员用户", SecurityUtils.getSubject().getPrincipal());
            throw new ServiceException("不能删除超级管理员用户");
        }
        return this.update(id, "deleted");
    }

    @Override
    public List<User> search(Map<String, Object> parameters) {
        logger.debug("== Find users by parameters={}.", parameters.toString());
        return userMapper.search(parameters);
    }

    @Override
    public List<User> search(Map<String, Object> parameters, int offset, int limit) {
        logger.debug("== Find limited users by parameters={}.", parameters.toString());
        parameters.put("offset", offset);
        parameters.put("limit", limit);
        return userMapper.search(parameters);
    }

    @Transactional(readOnly = false)
    public void batchAudit(String[] ids) {
        for (String id : ids) {
            if (id.length() == 0) {
                continue;
            }
            userMapper.updateBool(Long.parseLong(id), "status");
        }
        logger.debug("== Audit users in batch, id in {}.", ids.toString());
    }

    @Transactional(readOnly = false)
    public void batchDelete(String[] ids) {
        for (String id : ids) {
            if (id.length() == 0) {
                continue;
            }
            userMapper.updateBool(Long.parseLong(id), "deleted");
        }
        logger.debug("== Delete users in batch by set change deleted, id in {}.", ids.toString());
    }

    public User getUserByEmail(String email) {
        logger.debug("== Find user by email={}.", email);
        return userMapper.getUserByEmail(email);
    }

    public boolean isSupervisor(User user) {
        logger.debug("== Judge user is supervisor or not.");
        return (user.getId() != null && user.getId() == 1L);
    }

    public boolean isUsedEmail(String email) {
        if (userMapper.isUsedEmail(email) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional(readOnly = false)
    public void repass(User user) {
        user.setPlainPassword(RandomString.get(8));

        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
        if (StringUtils.isNotBlank(user.getPlainPassword()) && shiroRealm != null) {
            ShiroDbRealm.HashPassword hashPassword = shiroRealm.encrypt(user.getPlainPassword());
            user.setSalt(hashPassword.getSalt());
            user.setPassword(hashPassword.getPassword());
        }

        logger.debug("== Reset user's password by id={}, email={}.", user.getId(), user.getEmail());
        this.update(user);
        sendNotifyMessage(user);
    }

    @Transactional(readOnly = false)
    public int changePassword(Long id, String plainPassword) {
        User user = userMapper.get(id);
        user.setPlainPassword(plainPassword);

        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
        if (StringUtils.isNotBlank(plainPassword) && shiroRealm != null) {
            ShiroDbRealm.HashPassword hashPassword = shiroRealm.encrypt(plainPassword);
            user.setSalt(hashPassword.getSalt());
            user.setPassword(hashPassword.getPassword());
        }

        logger.debug("== Change user's password by id={}, email={}.", id, user.getEmail());
        int userId = this.update(user);
        return userId;
    }

    public void clearCachedAuthorizationInfo() {
        shiroRealm.clearCachedAuthorizationInfo((String) SecurityUtils.getSubject().getPrincipal());
    }

    public boolean checkPassword(User user, String plainPassword) {
        String userPassword = user.getPassword();

        String inputPassword = null;
        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
        if (StringUtils.isNotBlank(plainPassword) && shiroRealm != null) {
            String salt = user.getSalt();
            inputPassword = Encodes.encodeHex(Digests.sha1(plainPassword.getBytes(), Encodes.decodeHex(salt), 1024));
        }

        return userPassword.equals(inputPassword);
    }

    private void sendNotifyMessage(User user) {
        if (notifyProducer != null) {
            try {
                logger.info("== Notify message to user={}.", user.toString());
                notifyProducer.sendQueue(user);
            } catch (Exception e) {
                logger.error("消息发送失败", e);
            }
        }
    }

    public long count() {
        logger.debug("== Find the quantity of user.");
        return userMapper.count();
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setGroupMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Autowired(required = false)
    public void setNotifyProducer(NotifyMessageProducer notifyProducer) {
        this.notifyProducer = notifyProducer;
    }

    @Autowired(required = false)
    public void setShiroRealm(ShiroDbRealm shiroRealm) {
        this.shiroRealm = shiroRealm;
    }

}
