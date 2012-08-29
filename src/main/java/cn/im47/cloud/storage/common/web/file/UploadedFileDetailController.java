package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@RequestMapping(value = "/file")
public class UploadedFileDetailController {

    private UploadedFileManager uploadedFileManager;

    private static final String APP_KEY = "";

    /**
     * 跳转到上传文件修改界面
     *
     * @param file
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{id}")
    public String updateForm(@ModelAttribute("file") UploadedFile file, Model model) {
        if (null == file) {
            model.addAttribute("info", "该文件不存在，请刷新重试");
            return "redirect:/file/list";
        }
        model.addAttribute("file", file);
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);

        // TODO
        return "file/edit";
    }

    /**
     * 修改上传文件信息
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save/{id}")
    public String save(@ModelAttribute("file") UploadedFile file, RedirectAttributes redirectAttributes) {
        if (null == file) {
            redirectAttributes.addFlashAttribute("info", "该文件不存在，请刷新重试");
            return "redirect:/file/edit";
        }

        uploadedFileManager.update(APP_KEY, file);
        redirectAttributes.addFlashAttribute("info", "修改上传文件成功");
        return "redirect:/file/getByNode";
    }

    @ModelAttribute("file")
    public UploadedFile getUploadedFile(@PathVariable("id") Long id) {
        return uploadedFileManager.get(APP_KEY, id);
    }

    @Autowired
    public void setUploadedFileManager(UploadedFileManager uploadedFileManager) {
        this.uploadedFileManager = uploadedFileManager;
    }
}