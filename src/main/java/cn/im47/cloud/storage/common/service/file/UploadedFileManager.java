package cn.im47.cloud.storage.common.service.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.GenericAppManager;

import java.util.List;

/**
 * 文件 Manager
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午22:12
 */
public interface UploadedFileManager extends GenericAppManager<UploadedFile, Long> {

    public List<UploadedFile> getByNode(String appKey, Long id, int offset, int limit);

    public int updateBool(String appKey, Long id, String column);

}
