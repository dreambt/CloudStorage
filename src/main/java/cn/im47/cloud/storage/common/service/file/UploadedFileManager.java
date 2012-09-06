package cn.im47.cloud.storage.common.service.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.GenericAppManager;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 文件 Manager
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午22:12
 */
public interface UploadedFileManager extends GenericAppManager<UploadedFile, Long> {

    UploadedFile get(String appKey, String fileKey);

    List<UploadedFile> getByNode(String appKey, Long id, int offset, int limit);

    int save(String appKey, UploadedFile uploadedFile, MultipartFile file);

    int updateBool(String appKey, Long id, String column);

    int updateDownload(String appKey, Long id);

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     *
     * @return List of populated objects
     */
    List<UploadedFile> search(String appKey, Map<String, Object> parameters);

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     *
     * @return List of populated objects
     */
    List<UploadedFile> search(String appKey, Map<String, Object> parameters, int offset, int limit);

}
