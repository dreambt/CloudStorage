package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.account.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 用户注册控制器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-9-14
 * Time: 下午14:55
 */
@Controller
public class RegController {

    @Autowired
    private UserManager userManager;

    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String createFrom(Model model) {
        model.addAttribute("user", new User());
        return "security/register";
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String create(User user, RedirectAttributes redirectAttributes) {
        if (userManager.save(user) > 0) {
            redirectAttributes.addAttribute("info", "注册成功，请登陆..");
            return "security/login";
        } else {
            return "security/register";
        }
    }

}
