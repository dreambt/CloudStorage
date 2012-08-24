package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.entity.file.NodesAdjacencies;
import cn.im47.cloud.storage.data.file.NodesData;
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
public class NodesAdjMapperTest extends SpringTransactionalTestCase {

    private NodesAdjMapper nodesAdjMapper;
    private static final String APP_KEY = "";

    @Test
    public void testCrud() throws Exception {
        //新建并保存带权限组的用户
        NodesAdjacencies nodesAdjacencies = NodesData.getNodesAdjData();

        //新建 查询 测试
        assertEquals(1, nodesAdjMapper.save(APP_KEY, nodesAdjacencies));
        assertEquals(1, nodesAdjMapper.get(APP_KEY, 21L).getPLen().intValue());

        //更新 测试
        nodesAdjacencies.setPId(1L);
        nodesAdjMapper.update(APP_KEY, nodesAdjacencies);
        assertEquals(1, nodesAdjacencies.getPId().intValue());

        //删除 测试
        assertEquals(1, nodesAdjMapper.delete(APP_KEY, 8L));
    }

    @Test
    public void testSearch() throws Exception {
        Map<String, Object> parameters = Maps.newHashMap();
        parameters.put("cId", "3");
        parameters.put("Sort", "id");
        parameters.put("Direction", "ASC");
        parameters.put("offset", 0);
        parameters.put("limit", 10);
        assertEquals(2, nodesAdjMapper.search(APP_KEY, parameters).size());
    }

    @Autowired
    public void setFtpUserMapper(NodesAdjMapper nodesAdjMapper) {
        this.nodesAdjMapper = nodesAdjMapper;
    }
}
