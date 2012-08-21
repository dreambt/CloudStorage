package cn.im47.cloud.storage.common.service.file.impl;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.FileManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 文件 Manager 实现类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:59
 */
@Component
public class FileManagerImpl implements FileManager {

    @Override
    public UploadedFile get(String appKey, Long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int save(String appKey, UploadedFile object) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int update(String appKey, UploadedFile object) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int delete(String appKey, Long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<UploadedFile> search(String appKey, Map<String, Object> parameters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<UploadedFile> search(String appKey, Map<String, Object> parameters, int offset, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
