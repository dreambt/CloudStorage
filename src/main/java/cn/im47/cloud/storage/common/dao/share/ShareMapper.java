package cn.im47.cloud.storage.common.dao.share;

import cn.im47.cloud.storage.common.entity.share.Share;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 分享文件 Mapper
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public interface ShareMapper {

    Share get(@Param("appKey") String appKey, @Param("shareKey") String shareKey, @Param("shareSecret") String shareSecret);

    Long count(@Param("appKey") String appKey);

    int save(@Param("appKey") String appKey, @Param("object") Share object);

    int update(@Param("appKey") String appKey, @Param("object") Share object);

    int delete(@Param("appKey") String appKey, @Param("id") Long id);

    List<Share> search(@Param("appKey") String appKey, @Param("parameters") Map<String, Object> parameters);

}
