package cn.im47.cloud.storage.common.service.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.GenericManager;

/**
 * 用户 业务逻辑 接口
 * User: pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-5-12
 * Time: 下午8:58
 */
public interface UserManager extends GenericManager<User, Long> {

    /**
     * 更新用户bool字段
     *
     * @param id
     * @param column
     * @return
     */
    int update(Long id, String column);

    /**
     * 批量删除用户
     *
     * @return
     */
    int delete();

    /**
     * 批量审核用户
     *
     * @param ids
     */
    void batchAudit(String[] ids);

    /**
     * 批量改变用户的删除标志
     *
     * @param ids
     */
    void batchDelete(String[] ids);

    /**
     * 通过邮箱获取用户
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 判断是否超级管理员
     *
     * @param user
     * @return
     */
    boolean isSupervisor(User user);

    /**
     * 判断邮箱是否已经注册
     *
     * @param email
     * @return
     */
    boolean isUsedEmail(String email);

    /**
     * 重置密码
     *
     * @param user
     */
    void repass(User user);

    /**
     * 获取用户数量
     *
     * @return
     */
    Long count();

    /**
     * 修改密码
     */
    int changePassword(Long id, String plainPassword);

    /**
     * 清楚当前用户登录缓存
     */
    void clearCachedAuthorizationInfo();

    /**
     * 检验密码是否正确
     *
     * @param user
     * @param password
     * @return
     */
    boolean checkPassword(User user, String password);

}
