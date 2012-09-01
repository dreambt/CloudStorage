package cn.im47.cloud.storage.common.service.account;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.GenericManager;

/**
 * ftp用户 业务逻辑 接口
 * User: pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-9-1
 * Time: 下午8:58
 */
public interface FtpUserManager extends GenericManager<FtpUser, Long> {

    /**
     * 更新用户bool字段
     *
     * @param id
     * @param column
     * @return
     */
    int updateBool(Long id, String column);

    /**
     * 起任务删除标记用户
     *
     * @return
     */
    int deleteByTask();

    /**
     * 批量改变用户的删除标志
     *
     * @param ids
     */
    void deleteInBatch(String[] ids);

    /**
     * 重置密码
     *
     * @param ftpUser
     */
    void repass(FtpUser ftpUser);

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

}
