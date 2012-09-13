package cn.im47.cloud.storage.common.service.account.impl;

import cn.im47.cloud.storage.common.dao.account.FtpUserMapper;
import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.service.account.FtpUserManager;
import cn.im47.cloud.storage.utilities.security.MessageDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
public class FtpUserManagerImpl implements FtpUserManager {

    private static final String APP_KEY = "";

    private static final Logger logger = LoggerFactory.getLogger(FtpUserManagerImpl.class);

    private FtpUserMapper ftpUserMapper;

    public FtpUser get(Long id) {
        logger.debug("== Find ftp user by id={}.", id);
        return ftpUserMapper.get(id);
    }

    @Transactional(readOnly = false)
    public int save(FtpUser ftpUser) {
        logger.debug("== Save ftp user={}.", ftpUser.toString());
        return ftpUserMapper.save(ftpUser);
    }

    @Transactional(readOnly = false)
    public int update(FtpUser ftpUser) {

        logger.debug("== Update ftp user={}.", ftpUser);
        return ftpUserMapper.update(ftpUser);
    }

    @Transactional(readOnly = false)
    public int updateBool(Long id, String column) {
        logger.debug("== Update ftp user's #{} by id={}.", column, id);
        return ftpUserMapper.updateBool(id, column);
    }

    @Transactional(readOnly = false)
    public int deleteByTask() {
        logger.debug("== Delete ftp user by task.");
        return ftpUserMapper.deleteByTask();
    }

    @Transactional(readOnly = false)
    public int delete(Long id) {
        logger.debug("== Delete ftp user by id={}", id);
        return ftpUserMapper.delete(id);
    }

    public List<FtpUser> search(Map<String, Object> parameters) {
        logger.debug("== Find ftp users by parameters={}.", parameters.toString());
        return ftpUserMapper.search(parameters);
    }

    public List<FtpUser> search(Map<String, Object> parameters, int offset, int limit) {
        logger.debug("== Find limited ftp users by parameters={}.", parameters.toString());
        parameters.put("offset", offset);
        parameters.put("limit", limit);
        return ftpUserMapper.search(parameters);
    }

    @Transactional(readOnly = false)
    public void deleteInBatch(String[] ids) {
        logger.debug("== Delete users in batch by set change deleted, id in {}.", ids.toString());
        for (String id : ids) {
            if (id.length() == 0) {
                continue;
            }
            ftpUserMapper.updateBool(Long.parseLong(id), "deleted");
        }
    }

    public boolean isUsedName(String email) {
        if (ftpUserMapper.isUsedName(email) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional(readOnly = false)
    public int start(Long id) {
        logger.debug("== start ftp user by id={}", id);
        return this.updateBool(id, "enable_flag");
    }

    @Transactional(readOnly = false)
    public void repass(FtpUser ftpUser) {
        logger.debug("== Reset user's password by id={}, name={}.", ftpUser.getId(), ftpUser.getUserName());
        this.update(ftpUser);
    }

    @Transactional(readOnly = false)
    public int changePassword(Long id, String password) {
        FtpUser ftpUser = ftpUserMapper.get(id);
        //TODO  加密
        ftpUser.setUserPassword(MessageDigest.md5(password.getBytes()));

        logger.debug("== Change ftp user's password by id={}, name={}.", id, ftpUser.getUserName());
        int userId = this.update(ftpUser);
        return userId;
    }

    public Long count() {
        logger.debug("== Find the quantity of ftp user.");
        return ftpUserMapper.count();
    }

    @Autowired
    public void setFtpUserMapper(FtpUserMapper ftpUserMapper) {
        this.ftpUserMapper = ftpUserMapper;
    }

}
