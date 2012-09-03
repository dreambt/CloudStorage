package cn.im47.cloud.storage.common.service.share;

import cn.im47.cloud.storage.common.entity.share.Share;

/**
 * 分享文件 Manager
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-15
 * Time: 下午8:12
 */
public interface ShareManager {

    Share get(String appKey, String shareKey, String shareSecret);

    int save(String appKey, Share object);

    int update(String appKey, Share object);

    int delete(String appKey, Long id);

}
