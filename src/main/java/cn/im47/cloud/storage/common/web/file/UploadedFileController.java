package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    private static final Logger logger = LoggerFactory.getLogger(UploadedFileController.class);

    private UploadedFileManager uploadedFileManager;

    private static final String APP_KEY = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("files", uploadedFileManager.getByNode(APP_KEY, 0L));
        return "file/list";
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
     * 获得分类编号为id 的所有文件， ajax返回
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getByNode/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<UploadedFile> getByNode(@PathVariable("id") Long id) {
        return uploadedFileManager.getByNode(APP_KEY, id);
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
