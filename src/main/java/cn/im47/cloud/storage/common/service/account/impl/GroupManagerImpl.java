package cn.im47.cloud.storage.common.service.account.impl;

import cn.im47.cloud.storage.common.dao.account.GroupMapper;
import cn.im47.cloud.storage.common.entity.account.Group;
import cn.im47.cloud.storage.common.service.account.GroupManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户组管理类
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-22
 * Time: 下午5:25
 */
@Component
@Transactional(readOnly = true)
public class GroupManagerImpl implements GroupManager {

    private static final Logger logger = LoggerFactory.getLogger(GroupManagerImpl.class);

    private GroupMapper groupMapper;

    /**
     * 获取用户组
     *
     * @param id
     * @return
     */
    public Group get(Long id) {
        logger.info("Info: {}", "get where id=" + id);
        return groupMapper.get(id);
    }

    @Override
    public int save(Group object) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int update(Group object) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int delete(Long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Group> search(Map<String, Object> parameters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Group> search(Map<String, Object> parameters, int offset, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 获取用户组数量
     *
     * @return
     */
    public Long count() {
        logger.info("Info: {}", "count");
        return groupMapper.count();
    }

    @Autowired
    public void setGroupMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

}
