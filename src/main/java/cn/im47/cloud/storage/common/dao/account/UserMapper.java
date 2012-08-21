package cn.im47.cloud.storage.common.dao.account;

import cn.im47.cloud.storage.common.dao.GenericDao;
import cn.im47.cloud.storage.common.entity.account.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 Dao 接口
 * User: pengfei.dongpf(pengfei.dongpf@gmail.com)
 * Date: 12-5-12
 * Time: 下午1:26
 */
public interface UserMapper extends GenericDao<User, Long> {

    /**
     * 根据email获得用户信息
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 获取标记为删除的用户id
     *
     * @return
     */
    List<Long> getDeletedUserId();

    /**
     * 任务批量删除用户
     *
     * @return
     */
    int deleteByTask();

    /**
     * 检查邮箱是否已经注册
     *
     * @return
     */
    int isUsedEmail(@Param("email") String email);

}
