package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.service.account.FtpUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-9-13
 * Time: 下午10:26
 */
@Controller
@RequestMapping(value = "/api/ftpUser")
public class FtpUserResourceService {

    private FtpUserManager ftpUserManager;

    @RequestMapping(value = "get/{id}")
    @ResponseBody
    public FtpUser getAjax(@PathVariable("id") Long id) {
        return ftpUserManager.get(id);
    }

    @Autowired
    public void setFtpUserManager(FtpUserManager ftpUserManager) {
        this.ftpUserManager = ftpUserManager;
    }

}
