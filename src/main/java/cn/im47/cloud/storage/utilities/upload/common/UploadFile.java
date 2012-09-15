package cn.im47.cloud.storage.utilities.upload.common;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 文件上传类
 * User: FlyFive(pengfei.dongpf@gmail.com)
 * Date: 12-5-5
 * Time: 下午8:58
 */
public class UploadFile {

    /**
     * 上传文件
     *
     * @param file
     * @param fileOnServer
     * @return
     */
    public static File uploadFile(MultipartFile file, File fileOnServer) {
        //原文件名
        String imageName = file.getOriginalFilename();
        String ext = imageName.substring(imageName.lastIndexOf("."), imageName.length());

        //服务器上的文件名
        if (!fileOnServer.exists()) {
            fileOnServer.mkdirs();
        }

        //保存
        try {
            file.transferTo(fileOnServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileOnServer;
    }
}
