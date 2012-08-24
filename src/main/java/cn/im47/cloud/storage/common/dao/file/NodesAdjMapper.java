package cn.im47.cloud.storage.common.dao.file;

import cn.im47.cloud.storage.common.dao.GenericAppDao;
import cn.im47.cloud.storage.common.entity.file.Nodes;
import cn.im47.cloud.storage.common.entity.file.NodesAdjacencies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件存储节点 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public interface NodesAdjMapper extends GenericAppDao<NodesAdjacencies, Long> {
}
