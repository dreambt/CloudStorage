package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.NodeManager;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

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

    @Autowired
    private UploadedFileManager uploadedFileManager;

    @Autowired
    private NodeManager nodeManager;

    private static final int PAGE_SIZE = 5;
    private static final String APP_KEY = "";
    private static final String FILE_PATH = "D:/";

    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String listDefault() {
        return "redirect:/file/list/0";
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String listByNode(Model model, @PathVariable("id") Long id) {
        model.addAttribute("nodeId", id);
        model.addAttribute("nodes", nodeManager.getTree(APP_KEY));
        model.addAttribute("files", uploadedFileManager.getByNode(APP_KEY, id, 0, PAGE_SIZE));
        return "file/list";
    }

    /**
     * 获得分类编号为id 的所有文件
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable("id") Long id) {
        model.addAttribute("file", uploadedFileManager.get(APP_KEY, id));
        return "file/video";
    }

    @RequestMapping("download/{fileName}")
    public void download(@PathVariable("fileName") String fileName, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
        try {
            File file=new File(fileName);
            System.out.println(file.getAbsolutePath());
            InputStream inputStream=new FileInputStream(FILE_PATH + file);
            OutputStream os=response.getOutputStream();
            byte[] b=new byte[1024];
            int length;
            while((length=inputStream.read(b))>0){
                os.write(b,0,length);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转到上传页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("file", new UploadedFile());
        return "file/test";
    }

    /**
     * 保存上传文件
     *
     * @param model
     * @param file
     * @param uploadedFile
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, @RequestParam(value = "file", required = false) MultipartFile file,
                         UploadedFile uploadedFile, HttpServletRequest request) {
        if (uploadedFileManager.save(APP_KEY, uploadedFile,file) > 0) {
            model.addAttribute("info", "上传文件成功");
        } else {
            model.addAttribute("error", "上传文件失败");
        }
        return "redirect:/file/list";
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
        return "redirect:/file/list/" + uploadedFileManager.get(APP_KEY, id).getNode().getId();
    }

}
