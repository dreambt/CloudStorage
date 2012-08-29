package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.entity.file.NodeAdjacencies;
import cn.im47.cloud.storage.data.file.NodeData;
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
public class NodeAdjMapperTest extends SpringTransactionalTestCase {

    private NodeAdjMapper nodeAdjMapper;
    private static final String APP_KEY = "";

    @Test
    public void testCrud() throws Exception {
        //新建并保存带权限组的用户
        NodeAdjacencies nodeAdjacencies = NodeData.getNodeAdjData();

        //新建 查询 测试
        assertEquals(1, nodeAdjMapper.save(APP_KEY, nodeAdjacencies));
        assertEquals(1, nodeAdjMapper.get(APP_KEY, 21L).getPLen().intValue());

        //更新 测试
        nodeAdjacencies.setPId(1L);
        nodeAdjMapper.update(APP_KEY, nodeAdjacencies);
        assertEquals(1, nodeAdjacencies.getPId().intValue());

        //删除 测试
        assertEquals(1, nodeAdjMapper.delete(APP_KEY, 8L));
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("cId", "3");
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(2, nodeAdjMapper.search(APP_KEY, parameters).size());
    }

    @Autowired
    public void setFtpUserMapper(NodeAdjMapper nodeAdjMapper) {
        this.nodeAdjMapper = nodeAdjMapper;
    }
}
