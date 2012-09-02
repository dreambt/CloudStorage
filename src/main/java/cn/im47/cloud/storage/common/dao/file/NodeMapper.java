package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.dao.GenericAppDao;
import cn.im47.cloud.storage.common.entity.file.Node;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件存储节点 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public interface NodeMapper extends GenericAppDao<Node, Long> {

    List<Node> getChildren(@Param("appKey") String appKey, @Param("id") Long id);

    Node getRightSibling(@Param("appKey") String appKey, @Param("id") Long id);

    Node getByName(@Param("appKey") String appKey, @Param("nodeName") String nodeName);
}
