package cn.im47.cloud.storage.data.account;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.entity.account.Group;
import cn.im47.cloud.storage.common.entity.account.Permission;
import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.security.ShiroDbRealm;
import com.google.common.collect.Lists;
import org.springside.modules.test.data.RandomData;

import java.util.List;

/**
 * FtpUser相关实体测试数据生成.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
public class FtpUserData {

    public static FtpUser getFtpUser() {
        FtpUser ftpUser = new FtpUser();
        ftpUser.setId(3L);
        ftpUser.setUserName("111");
        ftpUser.setUserPassword("123456");
        ftpUser.setHomeDirectory(".");
        ftpUser.setEnableFlag(true);
        ftpUser.setWritePermission(true);
        ftpUser.setIdleTime(12345);
        ftpUser.setUploadRate(5);
        ftpUser.setDownloadRate(5);
        ftpUser.setMaxLoginNumber(10);
        ftpUser.setMaxLoginPerIp(12);
        return ftpUser;
    }

}