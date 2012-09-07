package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.entity.file.NodeTypeEnum;
import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.data.file.NodeData;
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
public class NodeMapperTest extends SpringTransactionalTestCase {

    private NodeMapper nodeMapper;
    private static final String APP_KEY = "";

    @Test
    public void testCrud() throws Exception {
        //新建并保存带权限组的用户
        Node node = NodeData.getNodeData();

        //新建 查询 测试
        assertEquals(1, nodeMapper.save(APP_KEY, node));
        assertEquals("node 2.2", nodeMapper.get(APP_KEY, 8L).getName());

        //更新 测试
        node.setType(NodeTypeEnum.PIC);
        nodeMapper.update(APP_KEY, node);
        assertEquals(NodeTypeEnum.PIC, node.getType());

        //删除 测试
        assertEquals(1, nodeMapper.delete(APP_KEY, 8L));
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("name", "node 1");
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(1, nodeMapper.search(APP_KEY, parameters).size());
    }

    @Test
    public void testGetChild() throws Exception {
        List<Node> children = nodeMapper.getChildren(APP_KEY, 1L);
        assertEquals(3, children.size());
    }

    @Test
    public void testGetRightSibling() throws Exception {
        Node right = nodeMapper.getRightSibling(APP_KEY, 2L);
        assertEquals(6, right.getId().intValue());
    }

    @Test
    public void testGetByName() throws Exception {
        Node node = nodeMapper.getByName(APP_KEY, "node 1");
        assertEquals(1, node.getId().intValue());
    }

    @Test
    public void testIsUsedNodeName() throws Exception {
        assertEquals(1, nodeMapper.isUsedNodeName(APP_KEY, 1L, "node 1.1"));
    }

    @Autowired
    public void setFtpUserMapper(NodeMapper nodeMapper) {
        this.nodeMapper = nodeMapper;
    }
}
