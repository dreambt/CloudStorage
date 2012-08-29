package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.account.UserManager;
import cn.im47.cloud.storage.common.service.account.impl.UserManagerImpl;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。
 * 因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/user")
public class UserDetailController {

    private UserManager userManager;

    private GroupListEditor groupListEditor;

    @InitBinder
    public void initBinder(WebDataBinder b) {
        b.registerCustomEditor(List.class, "groupList", groupListEditor);
    }

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
    public User getAccount(@PathVariable("id") Long id) {
        return userManager.get(id);
    }

    @Autowired
    public void setUserManager(@Qualifier("userManagerImpl") UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    @Autowired
    public void setGroupListEditor(@Qualifier("groupListEditor") GroupListEditor groupListEditor) {
        this.groupListEditor = groupListEditor;
    }

}