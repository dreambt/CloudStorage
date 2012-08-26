package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.dao.GenericAppDao;
import cn.im47.cloud.storage.common.entity.file.UploadedFile;

import java.util.List;

/**
 * 文件 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:56
 */
public interface UploadedFileMapper extends GenericAppDao<UploadedFile, Long> {

    List<UploadedFile> getByNodes(String appKey, Long id);

}
