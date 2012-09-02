package cn.im47.cloud.storage.common.dao.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.data.account.UserData;
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
public class UserMapperTest extends SpringTransactionalTestCase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserCrud() throws Exception {
        //新建并保存带权限组的用户
        User user = UserData.getRandomUserWithGroup();

        //新建 查询 测试
        assertEquals(1, userMapper.save(user));
        assertEquals("default.jpg", userMapper.get(3L).getPhotoURL());

        //更新 测试
        user.setEmail("a@a.com");
        userMapper.update(user);
        assertEquals("a@a.com", user.getEmail());

        //删除 测试
        assertEquals(1, userMapper.delete(3L));
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(3, userMapper.count().intValue());
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("username", "董鹏飞");
        parameters.put("email", "826323891@qq.com");
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(1, userMapper.search(parameters).size());
    }

    @Test
    public void testIsUsedEmail() throws Exception {
        assertEquals(1, userMapper.isUsedEmail("826323891@qq.com"));
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        assertEquals("董鹏飞", userMapper.getUserByEmail("826323891@qq.com").getUsername());
    }

    @Test
    public void testGetDeletedUserId() throws Exception {
        assertEquals(1, userMapper.getDeletedUserId().size());
    }

    @Test
    public void testDeleteByTask() throws Exception {
        assertEquals(1, userMapper.deleteByTask());
    }

}
