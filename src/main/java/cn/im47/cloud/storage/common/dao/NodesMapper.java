package cn.im47.cloud.storage.common.dao;

import cn.im47.cloud.storage.common.entity.Nodes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件存储节点 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public interface NodesMapper extends GenericDao<Nodes, Long> {

    Nodes getParent(@Param("appKey") String appKey, @Param("id") Long id);

    List<Nodes> getChild(@Param("appKey") String appKey, @Param("id") Long id);

    Nodes getLeftSibling(@Param("appKey") String appKey, @Param("leftSibling") Long leftSibling);

    Nodes getRightSibling(@Param("appKey") String appKey, @Param("id") Long id);

    int saveADJ(@Param("appKey") String appKey, @Param("pId") Long pId, @Param("cId") Long cId, @Param("pLen") Long pLen);

    int deleteADJ(@Param("appKey") String appKey, @Param("id") Long id);

    int updateLeftSiblingForDelete(@Param("appKey") String appKey, @Param("id") Long id);

}
