package cn.im47.cloud.storage.common.service.file;

import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.common.service.GenericAppManager;

import java.util.List;

/**
 * 文件存储节点 Manager
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-15
 * Time: 下午8:12
 */
public interface NodeManager extends GenericAppManager<Node, Long> {

    /**
     * 获得所有节点
     *
     * @param appKey
     * @return
     */
    List<Node> getAll(String appKey);

    /**
     * 获取整个树
     *
     * @param appKey
     * @return
     */
    List<Node> getTree(String appKey);

    /**
     * 获取父节点
     *
     * @param appKey
     * @param id
     * @return
     */
    Node getParent(String appKey, Long id);

    /**
     * 获取子节点
     *
     * @param appKey
     * @param id
     * @return
     */
    List<Node> getChildren(String appKey, Long id);

    /**
     * 通过路径获得节点
     *
     * @param appKey
     * @param path
     * @return
     */
    Node getByPath(String appKey, String path);

    /**
     * 通过节点名称获得节点
     *
     * @param appKey
     * @param nodeName
     * @param id
     * @return
     */
    Node getByName(String appKey, String nodeName, Long id);

    /**
     * 检测新节点名称是否已使用
     *
     * @param appKey
     * @param parentId
     * @param nodeName
     * @return
     */
    boolean isUsedNodeName(String appKey, Long parentId, String nodeName);

}
