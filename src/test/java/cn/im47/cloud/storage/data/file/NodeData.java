package cn.im47.cloud.storage.data.file;

import cn.im47.cloud.storage.common.entity.file.FileTypeEnum;
import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.common.entity.file.NodeAdjacencies;

/**
 * FtpUser相关实体测试数据生成.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
public class NodeData {

    public static Node getNodeData() {
        Node node = new Node();
        node.setId(8L);
        node.setName("node 2.2");
        node.setType(FileTypeEnum.TXT);
        node.setLeftSibling(0L);
        node.setParentId(3L);
        node.setNodeList(null);
        return node;
    }

    public static NodeAdjacencies getNodeAdjData() {
        NodeAdjacencies nodeAdjacencies = new NodeAdjacencies();
        nodeAdjacencies.setCId(8L);
        nodeAdjacencies.setPId(3L);
        nodeAdjacencies.setPLen(1L);
        return nodeAdjacencies;
    }

}