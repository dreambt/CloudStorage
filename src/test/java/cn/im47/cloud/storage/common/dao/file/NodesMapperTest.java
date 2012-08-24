package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.entity.file.FileTypeEnum;
import cn.im47.cloud.storage.common.entity.file.Nodes;
import cn.im47.cloud.storage.data.file.NodesData;
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
public class NodesMapperTest extends SpringTransactionalTestCase {

    private NodesMapper nodesMapper;
    private static final String APP_KEY = "";

    @Test
    public void testCrud() throws Exception {
        //新建并保存带权限组的用户
        Nodes nodes = NodesData.getNodesData();

        //新建 查询 测试
        assertEquals(1, nodesMapper.save(APP_KEY, nodes));
        assertEquals("node 2.2", nodesMapper.get(APP_KEY, 8L).getName());

        //更新 测试
        nodes.setType(FileTypeEnum.PIC);
        nodesMapper.update(APP_KEY, nodes);
        assertEquals(FileTypeEnum.PIC, nodes.getType());

        //删除 测试
        assertEquals(1, nodesMapper.delete(APP_KEY, 8L));
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("name", "node 1");
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(1, nodesMapper.search(APP_KEY, parameters).size());
    }

    @Test
    public void testGetChild() throws Exception {
        List<Nodes> children = nodesMapper.getChild(APP_KEY, 1L);
        assertEquals(3, children.size());
    }

    @Test
    public void testGetRightSibling() throws Exception {
        Nodes right = nodesMapper.getRightSibling(APP_KEY, 2L);
        assertEquals(6, right.getId().intValue());
    }

    @Autowired
    public void setFtpUserMapper(NodesMapper nodesMapper) {
        this.nodesMapper = nodesMapper;
    }
}
