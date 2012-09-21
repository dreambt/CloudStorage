package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.dto.ResponseMessage;
import cn.im47.cloud.storage.common.dto.UploadedFileDTO;
import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.node.NodeManager;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
     * 获得 fileKey 的文件
     *
     * @param fileKey
     * @return
     */
    @RequestMapping(value = "/get/{fileKey}", method = RequestMethod.GET)
    public void get(@PathVariable("fileKey") String fileKey, HttpServletResponse response) {
        UploadedFile uploadedFile = uploadedFileManager.get(APP_KEY, fileKey);
        response.setContentType("video/mp4");
        response.setHeader("Content-Disposition", "attachment;fileName=" + uploadedFile.getCustomName());
        response.setHeader("Accept-Ranges", "bytes");
        try {
            InputStream inputStream = new FileInputStream("/" + fileKey.substring(0, 2) + "/" + fileKey.substring(2, 4) + "/" + fileKey + "." + uploadedFile.getSuffix());
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            inputStream.close();
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得 fileKey 的文件
     *
     * @param fileKey
     * @return
     */
    @RequestMapping(value = "/show/{fileKey}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable("fileKey") String fileKey) {
        UploadedFile uploadedFile = uploadedFileManager.get(APP_KEY, fileKey);
        model.addAttribute("file", uploadedFile);

        // 根据文件类型选择不同的展示方式
        String fileType = uploadedFile.getSuffix();
        if ("avi".equals(fileType) || "mpg".equals(fileType) || "mp4".equals(fileType)) {
            return "file/video";
        } else if ("jpg".equals(fileType) || "png".equals(fileType)) {
            return "file/photo";
        } else {
            return "file/list";
        }
    }

    @RequestMapping("/download/{fileName}.{suffix}")
    public void download(@PathVariable("fileName") String fileName, @PathVariable("suffix") String suffix, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        String realName = uploadedFileManager.get(APP_KEY, fileName + "." + suffix).getRealName();
        response.setHeader("Content-Disposition", "attachment;fileName=" + realName);

        try {
            File file = new File(fileName + "." + suffix);
            //System.out.println(file.getAbsolutePath());
            InputStream inputStream = new FileInputStream(FILE_PATH + file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
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
        return "redirect:/file/list";
    }

    /**
     * 保存上传文件
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> create(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
        UploadedFile uploadedFile = uploadedFileManager.save(APP_KEY, file);
        if (null == uploadedFile) {
            return new ResponseEntity(new ResponseMessage("上传文件失败"), HttpStatus.OK);
        } else {
            List<UploadedFileDTO> dtoList = Lists.newArrayList();
            dtoList.add(UploadedFileDTO.convert(file, uploadedFile, request.getContextPath()));
            return new ResponseEntity(dtoList, HttpStatus.OK);
        }
    }

    /**
     * 标记删除上传文件
     *
     * @param model
     * @param fileKey
     * @return
     */
    @RequestMapping(value = "/delete/{fileKey}.{suffix}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("fileKey") String fileKey, @PathVariable("suffix") String suffix) {
        if (uploadedFileManager.updateBool(APP_KEY, fileKey + "." + suffix, "deleted") > 0) {
            model.addAttribute("info", "删除文件成功");
        } else {
            model.addAttribute("error", "删除文件失败");
        }
        return "redirect:/file/list/" + uploadedFileManager.get(APP_KEY, fileKey + "." + suffix).getNode().getId();
    }

}
