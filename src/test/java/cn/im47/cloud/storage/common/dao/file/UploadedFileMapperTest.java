package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.data.file.NodesData;
import cn.im47.cloud.storage.data.file.UploadedFileData;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * UserDao的测试用例, 测试ORM映射及特殊的DAO操作. 默认在每个测试函数后进行回滚.
 * User: baitao.jibt@gmail.com, pengfei.dongpf(pengfei.dongpf@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
@ContextConfiguration(locations = {"/applicationContext.xml", "/applicationContext-other.xml"})
public class UploadedFileMapperTest extends SpringTransactionalTestCase {

    private UploadedFileMapper uploadedFileMapper;
    private static final String APP_KEY = "";

    @Test
    public void testCrud() throws Exception {
        //新建并保存文件
        UploadedFile uploadedFile = UploadedFileData.getFileData();

        //新建 查询 测试
        assertEquals(1, uploadedFileMapper.save(APP_KEY, uploadedFile));
        assertEquals("eee.jpg", uploadedFileMapper.get(APP_KEY, 3L).getCustomName());

        //更新 测试
        uploadedFile.setCustomName("1.jpg");
        uploadedFileMapper.update(APP_KEY, uploadedFile);
        assertEquals("1.jpg", uploadedFile.getCustomName());

        //删除 测试
        assertEquals(1, uploadedFileMapper.delete(APP_KEY, 3L));
    }

    @Test
    public void testGetByNodes() throws Exception {
        List<UploadedFile> uploadedFiles = uploadedFileMapper.getByNodes(APP_KEY, 2L);
        assertEquals(2, uploadedFiles.size());
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        //TODO 使用customName = AAA.jpg无法查出结果
        parameters.put("size", 11);
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(2, uploadedFileMapper.search(APP_KEY, parameters).size());
    }

    @Autowired
    public void setFtpUserMapper(UploadedFileMapper uploadedFileMapper) {
        this.uploadedFileMapper = uploadedFileMapper;
    }
}