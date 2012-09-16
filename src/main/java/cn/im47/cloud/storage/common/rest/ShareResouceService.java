package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.entity.share.Share;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import cn.im47.cloud.storage.common.service.share.ShareManager;
import cn.im47.commons.utilities.encoder.SnappyEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件资源的REST服务
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-4-9
 * Time: 下午7:16
 */
@Controller
@RequestMapping(value = "/share")
public class ShareResouceService {

    private static final Logger logger = LoggerFactory.getLogger(ShareResouceService.class);

    @Autowired
    private ShareManager shareManager;

    @Autowired
    private UploadedFileManager uploadedFileManager;

    /**
     * 根据 key 提取文件
     *
     * @param key shareKey|shareSecret|appKey
     * @return
     */
    @RequestMapping(value = "/{key}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void getByNode(@PathVariable("key") String key, HttpServletResponse response) {
        String source;
        String shareKey = null;
        String shareSecret = null;
        String appKey = null;
        try {
            source = SnappyEncoder.decode(key);
            shareKey = source.split("\\|")[0];
            shareSecret = source.split("\\|")[1];
            appKey = source.split("\\|")[2];
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        Share shareFile = shareManager.get(appKey, shareKey, shareSecret);

        // 没有该文件时直接返回
        if (null == shareFile) {
            return;
        }

        UploadedFile uploadedFile = uploadedFileManager.get(appKey, shareFile.getFileKey());
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + uploadedFile.getCustomName());
        try {
            File file = new File(uploadedFile.getRealName());
            System.out.println(file.getAbsolutePath());
            InputStream inputStream = new FileInputStream(uploadedFile.getRealName().substring(0, 2) + "/" + uploadedFile.getRealName().substring(2, 4) + "/" + file);
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

}
