package cn.im47.cloud.storage.common.service.file.impl;

import cn.im47.cloud.storage.common.dao.file.NodesAdjMapper;
import cn.im47.cloud.storage.common.dao.file.NodesMapper;
import cn.im47.cloud.storage.common.entity.file.Nodes;
import cn.im47.cloud.storage.common.service.file.NodesManager;
import cn.im47.cloud.storage.memcached.MemcachedObjectType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.memcached.SpyMemcachedClient;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.util.List;
import java.util.Map;

/**
 * 文件存储节点 Manager 实现类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-15
 * Time: 下午7:22
 */
@Component
@Transactional(readOnly = true)
public class NodesManagerImpl implements NodesManager {

    private static final Logger logger = LoggerFactory.getLogger(NodesManagerImpl.class);

    private JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();

    private NodesMapper nodesMapper;

    private NodesAdjMapper nodesAdjMapper;

    private SpyMemcachedClient spyMemcachedClient;

    @Override
    public Nodes get(String appKey, Long id) {
        return nodesMapper.get(appKey, id);
    }

    @Override
    public List<Nodes> getTree(String appKey) {
        List<Nodes> nodesList = Lists.newArrayList();

        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        key = Encodes.encodeHex(Digests.sha1(key.getBytes()));
        String jsonString = spyMemcachedClient.get(key);

        if (StringUtils.isBlank(jsonString)) {
            nodesList = nodesMapper.getChild(appKey, 0L);
            int size = nodesList.size();
            for (Nodes node : nodesList) {
                List<Nodes> temp = nodesMapper.getChild(appKey, node.getId());
                if (null != temp) {
                    node.setNodesList(temp);
                }
            }
            jsonString = jsonMapper.toJson(nodesList);
            spyMemcachedClient.set(key, MemcachedObjectType.NODE.getExpiredTime(), jsonString);
        } else {
            nodesList = jsonMapper.fromJson(jsonString, jsonMapper.createCollectionType(List.class, Nodes.class));
        }
        return nodesList;
    }

    @Override
    @Transactional(readOnly = false)
    public int save(String appKey, Nodes object) {
        long parentId = object.getParent().getId();
        long parentLen = 0;
        List<Nodes> nodesList = nodesMapper.getChild(appKey, parentId);
        // TODO
        /*if (nodesList.size() > 0) {
            object.setLeftSibling(nodesList.get(nodesList.size() - 1).getId());
        } else {
            object.setLeftSibling(0L);
        }*/

        // 添加node
        int num = nodesMapper.save(appKey, object);
        long id = object.getId();

        // 建立node关系 TODO
        /*nodesAdjMapper.save(appKey, id, id, parentLen);
        try {
            for (; parentId > 0; ) {
                nodesMapper.saveADJ(appKey, parentId, id, ++parentLen);
                parentId = nodesMapper.get(appKey, parentId).getParent().getId();
            }
        } catch (NullPointerException npe) {
            nodesMapper.saveADJ(appKey, 0L, id, ++parentLen);
        }*/

        // 清理缓存
        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        spyMemcachedClient.delete(key);
        return num;
    }

    @Override
    @Transactional(readOnly = false)
    public int update(String appKey, Nodes object) {
        // 清理缓存
        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        spyMemcachedClient.delete(key);

        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @Transactional(readOnly = false)
    public int delete(String appKey, Long id) {
        // 修正右兄弟的左兄弟
        Nodes left_sibling = nodesMapper.get(appKey, id);
        nodesMapper.update(appKey, left_sibling);

        // 删除结点信息
        nodesMapper.delete(appKey, id);

        // 删除结点关系 TODO
        //nodesMapper.deleteADJ(appKey, id);

        // 清理缓存
        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        spyMemcachedClient.delete(key);

        return 1;
    }

    @Override
    public List<Nodes> search(String appKey, Map<String, Object> parameters) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Nodes> search(String appKey, Map<String, Object> parameters, int offset, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**/
    @Override
    public Nodes getParent(String appKey, Long id) {
        return nodesMapper.get(appKey, id).getParent();
    }

    @Override
    public List<Nodes> getChild(String appKey, Long id) {
        List<Nodes> nodesList = Lists.newArrayList();

        nodesList = nodesMapper.getChild(appKey, id);
        int size = nodesList.size();
        for (Nodes node : nodesList) {
            List<Nodes> temp = nodesMapper.getChild(appKey, node.getId());
            if (null != temp) {
                node.setNodesList(temp);
            }
        }
        return nodesList;
    }

    @Autowired
    public void setNodesMapper(NodesMapper nodesMapper) {
        this.nodesMapper = nodesMapper;
    }

    @Autowired
    public void setNodesAdjMapper(NodesAdjMapper nodesAdjMapper) {
        this.nodesAdjMapper = nodesAdjMapper;
    }

    @Autowired
    public void setSpyMemcachedClient(SpyMemcachedClient spyMemcachedClient) {
        this.spyMemcachedClient = spyMemcachedClient;
    }

}
