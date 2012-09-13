package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.service.account.FtpUserManager;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户管理控制器
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com), pengfei.dong@gmail.com
 * Date: 12-3-29
 * Time: 下午17:26
 */
@Controller
@RequestMapping(value = "/ftpUser")
public class FtpUserController {

    private FtpUserManager ftpUserManager;

    /**
     * 根据id获得ftp用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}")
    public String get(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", ftpUserManager.get(id));
        model.addAttribute("deal", "show");
        return "account/user";
    }

    /**
     * 显示所有ftp用户
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
        parameters.put("Direction", "desc");
        model.addAttribute("users", ftpUserManager.search(parameters));
        return "account/list";
    }

    /**
     * 添加ftp用户
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create")
    public String createForm(Model model) {
        model.addAttribute("user", new FtpUser());
        model.addAttribute("deal", "add");
        return "account/user";
    }

    /**
     * 保存新建ftp用户
     *
     * @param ftpUser
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save")
    public String save(FtpUser ftpUser, RedirectAttributes redirectAttributes) {
        if (ftpUserManager.save(ftpUser) > 0) {
            redirectAttributes.addFlashAttribute("info", "添加ftp用户成功.");
        } else {
            redirectAttributes.addFlashAttribute("error", "添加ftp用户失败");
        }
        return "redirect:/ftpUser/list";
    }

    /**
     * 删除编号为id的文章
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (ftpUserManager.updateBool(id, "deleted") > 0) {
            redirectAttributes.addFlashAttribute("info", "操作ftp用户 " + id + " 成功.");
        } else {
            redirectAttributes.addFlashAttribute("error", "操作ftp用户 " + id + " 失败.");
        }
        return "redirect:/ftpUser/list";
    }

    @RequestMapping(value = "deleteInBatch")
    public String deleteInBatch(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String[] isSelected = request.getParameterValues("isSelected");
        if (isSelected == null) {
            redirectAttributes.addFlashAttribute("error", "请选择要删除的ftp用户.");
            return "redirect:/ftpUser/list";
        } else {
            ftpUserManager.deleteInBatch(isSelected);
            redirectAttributes.addFlashAttribute("info", "批量删除ftp用户成功.");
            return "redirect:/ftpUser/list";
        }
    }

    /**
     * 根据id 启用/停用 ftp用户
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "start/{id}")
    public String start(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (null == ftpUserManager.get(id)) {
            redirectAttributes.addFlashAttribute("error", "该FTP账户不存在");
        } else {
            if (ftpUserManager.start(id) > 0) {
                redirectAttributes.addFlashAttribute("info", "操作成功");
            } else {
                redirectAttributes.addFlashAttribute("error", "操作失败");
            }
        }
        return "redirect:/ftpUser/list";
    }

    /**
     * 根据id 操作 ftp用户 写权限
     *
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "allowWrite/{id}")
    public String allowWrite(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (null == ftpUserManager.get(id)) {
            redirectAttributes.addFlashAttribute("error", "该FTP账户不存在");
        } else {
            if (ftpUserManager.updateBool(id, "write_permission") > 0) {
                redirectAttributes.addFlashAttribute("info", "操作成功");
            } else {
                redirectAttributes.addFlashAttribute("error", "操作失败");
            }
        }
        return "redirect:/ftpUser/list";
    }

    @Autowired
    public void setFtpUserManager(FtpUserManager ftpUserManager) {
        this.ftpUserManager = ftpUserManager;
    }

}
