package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.service.account.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户资源的REST服务
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-9-14
 * Time: 下午7:16
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserResouceService {

    @Autowired
    private UserManager userManager;

    private static final String APP_KEY = "";

    /**
     * 检测邮箱是否已经被注册
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "isUsedEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean ajaxIsUsedEmail(@RequestParam("email") String email) {
        return userManager.isUsedEmail(email);
    }

}
