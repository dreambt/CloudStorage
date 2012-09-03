package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件控制器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:54
 */
@Controller
@RequestMapping(value = "/file")
public class UploadedFileController {

    private UploadedFileManager uploadedFileManager;

    private static final String APP_KEY = "";

    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String list() {
        return "redirect:/file/list/0";
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String list(Model model, @PathVariable("id") Long id) {
        model.addAttribute("files", uploadedFileManager.getByNode(APP_KEY, id));
        return "file/list";
    }

    /**
     * 获得编号为id 的文件, ajax返回
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") Long id) {
        model.addAttribute("file", uploadedFileManager.get(APP_KEY, id));
        return "file/video";
    }

    /**
     * 跳转到上传页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("file", new UploadedFile());
        return "file/edit";
    }

    /**
     * 保存上传文件
     *
     * @param model
     * @param file
     * @param uploadedFile
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(Model model, @RequestParam(value = "file", required = false) MultipartFile file, UploadedFile uploadedFile) {
        if (uploadedFileManager.save(APP_KEY, uploadedFile) > 0) {
            model.addAttribute("info", "上传文件成功");
        } else {
            model.addAttribute("error", "上传文件失败");
        }
        return "redirect:/file/getByNode";
    }

    /**
     * 标记删除上传文件
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") Long id) {
        if (uploadedFileManager.updateBool(APP_KEY, id, "deleted") > 0) {
            model.addAttribute("info", "删除文件成功");
        } else {
            model.addAttribute("error", "删除文件失败");
        }
        return "";
    }

    @Autowired
    public void setUploadedFileManager(UploadedFileManager uploadedFileManager) {
        this.uploadedFileManager = uploadedFileManager;
    }

}
