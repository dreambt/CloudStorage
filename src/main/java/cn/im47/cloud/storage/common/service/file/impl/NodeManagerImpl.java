package cn.im47.cloud.storage.common.service.file.impl;

import cn.im47.cloud.storage.common.dao.file.NodeMapper;
import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.common.service.file.NodeManager;
import cn.im47.cloud.storage.utilities.memcached.MemcachedObjectType;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.cache.memcached.SpyMemcachedClient;
import org.springside.modules.mapper.JsonMapper;

import java.util.List;

/**
 * 文件存储节点 Manager 实现类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-15
 * Time: 下午7:22
 */
@Component
@Transactional(readOnly = true)
public class NodeManagerImpl implements NodeManager {

    private static final Logger logger = LoggerFactory.getLogger(NodeManagerImpl.class);

    private JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();

    private NodeMapper nodeMapper;

    private SpyMemcachedClient spyMemcachedClient;

    @Override
    public Node get(String appKey, Long id) {
        return nodeMapper.get(appKey, id);
    }

    @Override
    public List<Node> getTree(String appKey) {
        List<Node> nodeList = nodeMapper.getChildren(appKey, 0L);
        for (Node node : nodeList) {
            this.toTree(appKey, node);
        }
        return nodeList;
    }

    /**
     * 如果为叶子节点，就加入节点树
     *
     * @param appKey
     * @param node
     * @return
     */
    private void toTree(String appKey, Node node) {
        List<Node> nodeList1 = nodeMapper.getChildren(appKey, node.getId());
        for (Node node1 : nodeList1) {
            node.getNodeList().add(node1);
            if (0 == nodeMapper.getChildren(appKey, node1.getId()).size() || null == nodeMapper.getChildren(appKey, node1.getId())) {
                continue;
            } else {
                this.toTree(appKey, node1);
            }
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int save(String appKey, Node object) {
        long parentId = object.getParentId();
        long parentLen = 0;
        List<Node> nodeList = nodeMapper.getChildren(appKey, parentId);
        // TODO
        /*if (nodeList.size() > 0) {
            object.setLeftSibling(nodeList.get(nodeList.size() - 1).getId());
        } else {
            object.setLeftSibling(0L);
        }*/

        // 添加node
        int num = nodeMapper.save(appKey, object);
        long id = object.getId();

        // 建立node关系 TODO
        /*nodeAdjMapper.save(appKey, id, id, parentLen);
        try {
            for (; parentId > 0; ) {
                nodeMapper.saveADJ(appKey, parentId, id, ++parentLen);
                parentId = nodeMapper.get(appKey, parentId).getParent().getId();
            }
        } catch (NullPointerException npe) {
            nodeMapper.saveADJ(appKey, 0L, id, ++parentLen);
        }*/

        // 清理缓存
        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        spyMemcachedClient.delete(key);
        return num;
    }

    @Override
    @Transactional(readOnly = false)
    public int update(String appKey, Node object) {
        // 清理缓存
        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        spyMemcachedClient.delete(key);

        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @Transactional(readOnly = false)
    public int delete(String appKey, Long id) {
        // 修正右兄弟的左兄弟
        Node left_sibling = nodeMapper.get(appKey, id);
        nodeMapper.update(appKey, left_sibling);

        // 删除结点信息
        nodeMapper.delete(appKey, id);

        // 删除结点关系 TODO
        //nodeMapper.deleteADJ(appKey, id);

        // 清理缓存
        String key = MemcachedObjectType.NODE.getPrefix() + "user:" + appKey;
        spyMemcachedClient.delete(key);

        return 1;
    }

    @Override
    public Node getParent(String appKey, Long id) {
        return nodeMapper.get(appKey, nodeMapper.get(appKey, id).getParentId());
    }

    @Override
    public List<Node> getChildren(String appKey, Long id) {
        List<Node> nodeList = Lists.newArrayList();

        nodeList = nodeMapper.getChildren(appKey, id);
        int size = nodeList.size();
        for (Node node : nodeList) {
            List<Node> temp = nodeMapper.getChildren(appKey, node.getId());
            if (null != temp) {
                node.setNodeList(temp);
            }
        }
        return nodeList;
    }

    @Override
    public Node getByPath(String path) {
        String[] paths = path.split("/");
        return null;
    }

    @Override
    public Node getBuName(String nodeName) {
        return null;
    }

    @Autowired
    public void setNodeMapper(NodeMapper nodeMapper) {
        this.nodeMapper = nodeMapper;
    }

    @Autowired
    public void setSpyMemcachedClient(SpyMemcachedClient spyMemcachedClient) {
        this.spyMemcachedClient = spyMemcachedClient;
    }

}
