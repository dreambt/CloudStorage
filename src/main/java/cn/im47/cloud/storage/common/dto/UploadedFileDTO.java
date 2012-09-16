package cn.im47.cloud.storage.common.dto;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * 文件
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 上午7:56
 */
public class UploadedFileDTO implements Serializable {

    private static final long serialVersionUID = -38331060124340964L;

    private String name;
    private long size;
    private String type;
    private String url;
    private String thumbnail_url;
    private String delete_url;
    private String delete_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getDelete_url() {
        return delete_url;
    }

    public void setDelete_url(String delete_url) {
        this.delete_url = delete_url;
    }

    public String getDelete_type() {
        return delete_type;
    }

    public void setDelete_type(String delete_type) {
        this.delete_type = delete_type;
    }

    public static UploadedFileDTO convert(MultipartFile file, UploadedFile uploadedFile, String contextPath) {
        UploadedFileDTO dto = new UploadedFileDTO();
        dto.setName(uploadedFile.getFileKey());
        dto.setSize(file.getSize());
        dto.setType(file.getContentType());
        dto.setUrl(contextPath + "/file/get/" + uploadedFile.getFileKey());
        dto.setThumbnail_url(contextPath + "/file/get/thumbnail/" + uploadedFile.getFileKey());
        dto.setDelete_url(contextPath + "/file/delete/" + uploadedFile.getFileKey());
        dto.setDelete_type("DELETE");
        return dto;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
