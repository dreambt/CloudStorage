package cn.im47.cloud.storage.common.web.account;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.common.service.account.FtpUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * User: baitao.jibt@gmail.com
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/ftpUser")
public class FtpUserDetailController {

    @Autowired
    private FtpUserManager ftpUserManager;

    /**
     * 修改ftp用户信息
     *
     * @param ftpUser
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute("ftpUser") FtpUser ftpUser, RedirectAttributes redirectAttributes) {
        if (null == ftpUser) {
            redirectAttributes.addFlashAttribute("info", "该ftp用户不存在，请刷新重试");
            return "redirect:/ftpUser/list";
        }
        ftpUserManager.update(ftpUser);
        redirectAttributes.addFlashAttribute("info", "修改ftp用户成功");
        return "redirect:/ftpUser/list";
    }

    @ModelAttribute("ftpUser")
    public FtpUser getAccount(@RequestParam("id") Long id) {
        return ftpUserManager.get(id);
    }

}
