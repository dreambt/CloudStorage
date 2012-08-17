package cn.im47.cloud.storage.common.service;

import cn.im47.cloud.storage.common.entity.Nodes;

import java.util.List;

/**
 * 文件存储节点 Manager
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-15
 * Time: 下午8:12
 */
public interface NodesManager extends GenericManager<Nodes, Long> {

    /**
     * 获取整个树
     *
     * @param appKey
     * @return
     */
    List<Nodes> getTree(String appKey);

    /**
     * 获取父节点
     *
     * @param appKey
     * @param id
     * @return
     */
    Nodes getParent(String appKey, Long id);

    /**
     * 获取子节点
     *
     * @param appKey
     * @param id
     * @return
     */
    List<Nodes> getChild(String appKey, Long id);

}
