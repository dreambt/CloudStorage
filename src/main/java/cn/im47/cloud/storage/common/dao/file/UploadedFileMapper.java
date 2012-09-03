package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.dao.GenericAppDao;
import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:56
 */
public interface UploadedFileMapper extends GenericAppDao<UploadedFile, Long> {

    List<UploadedFile> getByNode(@Param("appKey") String appKey, @Param("id") Long id, @Param("offset") int offset, @Param("limit") int limit);

    UploadedFile getByFileKey(@Param("appKey") String appKey, @Param("fileKey") String fileKey);

}
