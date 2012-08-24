package cn.im47.cloud.storage.data.file;

import cn.im47.cloud.storage.common.dao.file.NodesMapper;
import cn.im47.cloud.storage.common.entity.file.FileTypeEnum;
import cn.im47.cloud.storage.common.entity.file.Nodes;
import cn.im47.cloud.storage.common.entity.file.NodesAdjacencies;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FtpUser相关实体测试数据生成.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-21
 * Time: 下午7:01
 */
public class NodesData {

    public static Nodes getNodesData() {
        Nodes nodes = new Nodes();
        nodes.setId(8L);
        nodes.setName("node 2.2");
        nodes.setType(FileTypeEnum.TXT);

        Nodes left = new Nodes();
        left.setId(0L);
        nodes.setLeftSibling(left);

        Nodes parent = new Nodes();
        parent.setId(3L);
        nodes.setParent(parent);

        nodes.setNodesList(null);
        return nodes;
    }

    public static NodesAdjacencies getNodesAdjData() {
        NodesAdjacencies nodesAdjacencies = new NodesAdjacencies();
        nodesAdjacencies.setCId(8L);
        nodesAdjacencies.setPId(3L);
        nodesAdjacencies.setPLen(1L);
        return nodesAdjacencies;
    }

}