package cn.im47.cloud.storage.common.dao.account;

import cn.im47.cloud.storage.common.entity.account.FtpUser;
import cn.im47.cloud.storage.data.account.FtpUserData;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * UserDao的测试用例, 测试ORM映射及特殊的DAO操作. 默认在每个测试函数后进行回滚.
 * User: baitao.jibt@gmail.com, pengfei.dongpf(pengfei.dongpf@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
@ContextConfiguration(locations = {"/applicationContext.xml", "/applicationContext-other.xml"})
public class FtpUserMapperTest extends SpringTransactionalTestCase {

    private FtpUserMapper ftpUserMapper;

    @Test
    public void testCrud() throws Exception {
        //新建并保存带权限组的用户
        FtpUser ftpUser = FtpUserData.getFtpUser();

        //新建 查询 测试
        assertEquals(1, ftpUserMapper.save(ftpUser));
        assertEquals(12345, ftpUserMapper.get(3L).getIdleTime());

        //更新 测试
        ftpUser.setDownloadRate(0);
        ftpUserMapper.update(ftpUser);
        assertEquals(0, ftpUser.getDownloadRate());

        //删除物理测试
        assertEquals(1, ftpUserMapper.deleteByTask());
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(2, ftpUserMapper.count().intValue());
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("user_name", "admin");
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(2, ftpUserMapper.search(parameters).size());
    }

    @Autowired
    public void setFtpUserMapper(FtpUserMapper ftpUserMapper) {
        this.ftpUserMapper = ftpUserMapper;
    }
}
