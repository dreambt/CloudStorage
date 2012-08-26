package cn.im47.cloud.storage.common.service.account;

import cn.im47.cloud.storage.common.dao.account.GroupMapper;
import cn.im47.cloud.storage.common.entity.account.Group;
import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.GenericManager;
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
public interface GroupManager  extends GenericManager<Group, Long> {

    public Group getGroup(Long id);

    public Long getCount();

}
