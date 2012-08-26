package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import com.google.common.collect.Lists;
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

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UploadedFile get(@PathVariable("id") Long id) {
        return uploadedFileManager.get(APP_KEY, id);
    }

    @RequestMapping(value = "/getByNodes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<UploadedFile> getByNodes(@PathVariable("id") Long id) {
        return uploadedFileManager.getByNodes(APP_KEY, id);
    }

    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("file", new UploadedFile());
        return "file/edit";
    }

    @RequestMapping(value = "/save")
    public String save(Model model, UploadedFile file) {
        if(uploadedFileManager.save(APP_KEY, file) > 0) {
            model.addAttribute("info", "上传文件成功");
        } else {
            model.addAttribute("error", "上传文件失败");
        }
        return "redirect:/file/getByNodes";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public List<UploadedFile> put(@RequestParam("file") MultipartFile file) {
        // Do custom steps here
        // i.e. Save the file to a temporary location or database
        logger.debug("Writing file to disk...done");

        List<UploadedFile> uploadedFiles = Lists.newArrayList();
        UploadedFile u = new UploadedFile(file.getOriginalFilename(),
                Long.valueOf(file.getSize()).intValue(),
                "http://localhost:8080/spring-fileupload-tutorial/resources/" + file.getOriginalFilename());

        uploadedFiles.add(u);
        return uploadedFiles;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") Long id) {
        if(uploadedFileManager.updateBool(APP_KEY, id, "deleted") > 0) {
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
