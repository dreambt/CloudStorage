package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.account.UserManager;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * User: baitao.jibt@gmail.com
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/user")
public class UserDetailController {

    @Autowired
    private UserManager userManager;

    /**
     * 跳转到用户修改界面
     *
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{id}")
    public String updateForm(@ModelAttribute("user") User user, Model model) {
        if (null == user) {
            model.addAttribute("info", "该用户不存在，请刷新重试");
            return "redirect:/account/list";
        }
        model.addAttribute("user", user);
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);

        // TODO
        //model.addAttribute("allGroups", groupManager.search(parameters));
        return "account/userForm";
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save/{id}")
    public String save(@ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (null == user) {
            redirectAttributes.addFlashAttribute("info", "该用户不存在，请刷新重试");
            return "redirect:/account/userinfo" + user.getId();
        }
        if (bindingResult.hasErrors()) {
            return updateForm(user, redirectAttributes);
        }

        userManager.update(user);
        redirectAttributes.addFlashAttribute("info", "修改用户成功");
        return "redirect:/account/userinfo" + user.getId();
    }

    @ModelAttribute("user")
    public User getAccount(@RequestParam("id") Long id) {
        return userManager.get(id);
    }

}
