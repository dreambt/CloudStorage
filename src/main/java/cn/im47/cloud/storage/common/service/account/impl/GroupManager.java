package cn.im47.cloud.storage.common.service.account.impl;

import cn.im47.cloud.storage.common.dao.account.GroupMapper;
import cn.im47.cloud.storage.common.entity.account.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户组管理类
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-22
 * Time: 下午5:25
 */
@Component
@Transactional(readOnly = true)
public class GroupManager {

    private static final Logger logger = LoggerFactory.getLogger(GroupManager.class);

    private GroupMapper groupMapper;

    /**
     * 获取用户组
     *
     * @param id
     * @return
     */
    public Group getGroup(Long id) {
        logger.info("Info: {}", "getGroup where id=" + id);
        return groupMapper.get(id);
    }

    /**
     * 获取用户组数量
     *
     * @return
     */
    public Long getCount() {
        logger.info("Info: {}", "getCount");
        return groupMapper.count();
    }

    @Autowired
    public void setGroupMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

}
