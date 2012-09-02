package cn.im47.cloud.storage.common.service.account;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.data.account.UserData;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import java.util.Map;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * 用户 业务逻辑 测试类
 * User: pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-5-12
 * Time: 下午9:59
 */
@ContextConfiguration(locations = {"/applicationContext.xml", "/applicationContext-other.xml"})
public class UserManagerTest extends SpringTransactionalTestCase {

    @Autowired
    private UserManager userManager;

    @Test
    public void testGet() throws Exception {
        assertEquals("董鹏飞", userManager.get(2L).getUsername());
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(3, userManager.count());
    }

    @Test
    public void testUserCrud() throws Exception {
        //新建并保存带权限组的用户
        User user = UserData.getRandomUserWithGroup();

        //新建 查询 测试
        userManager.save(user);
        assertEquals("default.jpg", userManager.get(3L).getPhotoURL());
        //更新 测试
        user.setEmail("a@a.com");
        userManager.update(user);
        assertEquals("a@a.com", user.getEmail());

        //删除 测试
        assertEquals(1, userManager.delete(3L));
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
        assertEquals(1, userManager.search(parameters).size());
    }

    @Test
    public void testBatchAudit() throws Exception {
        String[] ids = {"1", "2"};
        userManager.batchAudit(ids);
        User user = userManager.get(1L);
        assertFalse(user.isStatus());
    }

    @Test
    public void testBatchDelete() throws Exception {
        String[] ids = {"1", "2"};
        userManager.batchDelete(ids);
        User user = userManager.get(1L);
        assertTrue(user.isDeleted());
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        assertEquals("董鹏飞", userManager.getUserByEmail("826323891@qq.com").getUsername());
    }

    @Test
    public void testIsSupervisor() throws Exception {
        User user = userManager.get(1L);
        assertTrue(userManager.isSupervisor(user));
    }

    @Test
    public void testIsUsedEmail() throws Exception {
        assertTrue(userManager.isUsedEmail("826323891@qq.com"));
    }

    @Test
    public void testRepass() throws Exception {
        userManager.repass(userManager.get(2L));
        // TODO
        assertNotSame("691b14d79bf0fa2215f155235df5e670b64394cc7efbd59d9741d34f", userManager.get(1L).getPassword());
    }

}
