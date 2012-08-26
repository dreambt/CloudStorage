package cn.im47.cloud.storage.common.web;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.FileManager;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private FileManager fileManager;

    @RequestMapping(value = {"","/list"}, method = RequestMethod.GET)
    public String list() {

        return "file/file";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {

        return "";
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

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del() {

        return "";
    }

    @Autowired
    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

}
