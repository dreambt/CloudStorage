package cn.im47.cloud.storage.common.service.file.impl;

import cn.im47.cloud.storage.common.dao.file.UploadedFileMapper;
import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UploadedFileManagerImpl implements UploadedFileManager {

    private UploadedFileMapper uploadedFileMapper;

    @Override
    public UploadedFile get(String appKey, Long id) {
        return uploadedFileMapper.get(appKey, id);
    }

    @Override
    public List<UploadedFile> getByNodes(String appKey, Long id) {
        return uploadedFileMapper.getByNodes(appKey, id);
    }

    @Override
    public int save(String appKey, UploadedFile object) {
        return uploadedFileMapper.save(appKey, object);
    }

    @Override
    public int update(String appKey, UploadedFile object) {
        return uploadedFileMapper.update(appKey, object);
    }

    @Override
    public int updateBool(String appKey, Long id, String column) {
        return uploadedFileMapper.updateBool(appKey, id, column);
    }

    @Override
    public int delete(String appKey, Long id) {
        return uploadedFileMapper.updateBool(appKey, id, "deleted");
    }

    @Override
    public List<UploadedFile> search(String appKey, Map<String, Object> parameters) {
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        return uploadedFileMapper.search(appKey, parameters);
    }

    @Override
    public List<UploadedFile> search(String appKey, Map<String, Object> parameters, int offset, int limit) {
        parameters.put("offset", offset);
        parameters.put("limit", limit);
        return uploadedFileMapper.search(appKey, parameters);
    }

    @Autowired
    public void setUploadedFileMapper(UploadedFileMapper uploadedFileMapper) {
        this.uploadedFileMapper = uploadedFileMapper;
    }
}
