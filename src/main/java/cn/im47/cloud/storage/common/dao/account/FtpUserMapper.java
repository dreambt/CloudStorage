package cn.im47.cloud.storage.common.dao.account;

import cn.im47.cloud.storage.common.dao.GenericDao;
import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.entity.account.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Ftp用户 Dao 接口
 * User: pengfei.dongpf(pengfei.dongpf@gmail.com)
 * Date: 12-5-12
 * Time: 下午1:26
 */
public interface FtpUserMapper extends GenericDao<FtpUser, Long> {

}
