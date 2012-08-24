package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.dao.GenericAppDao;
import cn.im47.cloud.storage.common.entity.file.Nodes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件存储节点 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public interface NodesMapper extends GenericAppDao<Nodes, Long> {

    List<Nodes> getChild(@Param("appKey") String appKey, @Param("id") Long id);

    Nodes getRightSibling(@Param("appKey") String appKey, @Param("id") Long id);

}
