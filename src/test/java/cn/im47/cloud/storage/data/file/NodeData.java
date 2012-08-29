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

        Node left = new Node();
        left.setId(0L);
        node.setLeftSibling(left);

        Node parent = new Node();
        parent.setId(3L);
        node.setParent(parent);

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