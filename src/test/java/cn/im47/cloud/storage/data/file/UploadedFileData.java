package cn.im47.cloud.storage.data.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import org.joda.time.LocalDateTime;

/**
 * FtpUser相关实体测试数据生成.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
public class UploadedFileData {

    public static UploadedFile getFileData() {
        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setNode(NodeData.getNodeData());
        uploadedFile.setCustomName("eee.jpg");
        uploadedFile.setFileKey("asdfasdfasfewavx");
        uploadedFile.setRealName("ea.jpg");
        uploadedFile.setSize(100);
        uploadedFile.setMd5("asdfawevasdfwe");
        uploadedFile.setCRC("evaeads");
        uploadedFile.setShared(true);
        uploadedFile.setStatus(true);
        uploadedFile.setDeleted(false);
        uploadedFile.setLastModifiedDate(new LocalDateTime());
        uploadedFile.setCreatedDate(new LocalDateTime());
        return uploadedFile;
    }

}