package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.service.account.FtpUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。
 * 因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/ftpUser")
public class FtpUserDetailController {

    private FtpUserManager ftpUserManager;

    /**
     * 跳转到ftp用户修改界面
     *
     * @param ftpUser
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{id}")
    public String updateForm(@ModelAttribute("user") FtpUser ftpUser, Model model) {
        if (null == ftpUser) {
            model.addAttribute("info", "该ftp用户不存在，请刷新重试");
            return "redirect:/ftpUser/list";
        }
        model.addAttribute("user", ftpUser);
        model.addAttribute("deal", "edit");

        return "account/user";
    }

    /**
     * 修改ftp用户信息
     *
     * @param ftpUser
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save/{id}")
    public String save(@ModelAttribute("ftpUser") FtpUser ftpUser, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (null == ftpUser) {
            redirectAttributes.addFlashAttribute("info", "该ftp用户不存在，请刷新重试");
            return "redirect:/ftpUser/list";
        }
        ftpUserManager.update(ftpUser);
        redirectAttributes.addFlashAttribute("info", "修改ftp用户成功");
        return "redirect:/ftpUser/list";
    }

    @ModelAttribute("user")
    public FtpUser getAccount(@PathVariable("id") Long id) {
        return ftpUserManager.get(id);
    }

    @Autowired
    public void setFtpUserManager(FtpUserManager ftpUserManager) {
        this.ftpUserManager = ftpUserManager;
    }

}