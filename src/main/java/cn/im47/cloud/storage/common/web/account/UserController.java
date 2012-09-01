package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.service.account.GroupManager;
import cn.im47.cloud.storage.common.service.account.UserManager;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户管理控制器
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com), pengfei.dong@gmail.com
 * Date: 12-3-29
 * Time: 下午17:26
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserManager userManager;
    private GroupManager groupManager;

    private GroupListEditor groupListEditor;

    @InitBinder
    public void initBinder(WebDataBinder b) {
        b.registerCustomEditor(List.class, "groupList", groupListEditor);
    }

    /**
     * 显示所有用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "list")
    public String list(Model model) {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        parameters.put("Sort", "id");
        parameters.put("Direction", "DESC");
        model.addAttribute("users", userManager.search(parameters));
        return "account/list";
    }

    /**
     * 添加用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        // TODO
        // model.addAttribute("allGroups", groupManager.getAllGroup());
        return "account/userForm";
    }

    /**
     * 保存新建用户
     *
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save")
    public String save(User user, RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return createForm(model);
        }
        try {
            user.setLastLoginIP(request.getRemoteAddr());   //TODO 获得ip
            userManager.save(user);
            redirectAttributes.addFlashAttribute("info", "创建用户" + user.getEmail() + "成功, 密码以邮件的方式发送到" + user.getEmail() + ".");
            return "redirect:/account/userList";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "创建用户" + user.getEmail() + "失败");
            return createForm(model);
        }
    }

    /**
     * 审核编号为id的用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "audit/{id}")
    public String audit(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (userManager.update(id, "status") > 0) {
            redirectAttributes.addFlashAttribute("info", "操作用户 " + id + " 成功.");
        } else {
            redirectAttributes.addFlashAttribute("error", "操作用户 " + id + " 失败.");
        }
        return "redirect:/account/userList";
    }

    /**
     * 删除编号为id的文章
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (userManager.update(id, "deleted") > 0) {
            redirectAttributes.addFlashAttribute("info", "操作用户 " + id + " 成功.");
        } else {
            redirectAttributes.addFlashAttribute("error", "操作用户 " + id + " 失败.");
        }
        return "redirect:/account/userList";
    }

    @RequestMapping(value = "batchAudit")
    public String batchAuditUser(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String[] isSelected = request.getParameterValues("isSelected");
        if (isSelected == null) {
            redirectAttributes.addFlashAttribute("error", "请选择要审核的用户.");
            return "redirect:/account/userList";
        } else {
            userManager.batchAudit(isSelected);
            redirectAttributes.addFlashAttribute("info", "批量审核用户成功.");
            return "redirect:/account/userList";
        }
    }

    @RequestMapping(value = "batchDelete")
    public String batchDeleteUser(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String[] isSelected = request.getParameterValues("isSelected");
        if (isSelected == null) {
            redirectAttributes.addFlashAttribute("error", "请选择要删除的用户.");
            return "redirect:/account/userList";
        } else {
            userManager.batchDelete(isSelected);
            redirectAttributes.addFlashAttribute("info", "批量删除用户成功.");
            return "redirect:/account/userList";
        }
    }


    @Autowired
    public void setUserManager(@Qualifier("userManagerImpl") UserManager userManager) {
        this.userManager = userManager;
    }

    @Autowired
    public void setGroupManager(@Qualifier("groupManagerImpl") GroupManager groupManager) {
        this.groupManager = groupManager;
    }

    @Autowired
    public void setGroupListEditor(@Qualifier("groupListEditor") GroupListEditor groupListEditor) {
        this.groupListEditor = groupListEditor;
    }

}