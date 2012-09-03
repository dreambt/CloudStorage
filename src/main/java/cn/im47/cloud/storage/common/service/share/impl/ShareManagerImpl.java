package cn.im47.cloud.storage.common.service.share.impl;

import cn.im47.cloud.storage.common.dao.share.ShareMapper;
import cn.im47.cloud.storage.common.entity.share.Share;
import cn.im47.cloud.storage.common.service.share.ShareManager;
import cn.im47.cloud.storage.utilities.memcached.MemcachedObjectType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.cache.memcached.SpyMemcachedClient;
import org.springside.modules.mapper.JsonMapper;

/**
 * 文件分享 Manager 实现类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-9-3
 * Time: 下午2:19
 */
@Component
@Transactional(readOnly = true)
public class ShareManagerImpl implements ShareManager {

    private static final Logger logger = LoggerFactory.getLogger(ShareManager.class);

    private JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();

    private ShareMapper shareMapper;

    private SpyMemcachedClient spyMemcachedClient;

    @Override
    public Share get(String appKey, String shareKey, String shareSecret) {
        Share share = null;
        String key = MemcachedObjectType.SHARE.getPrefix() + "appKey:" + appKey + "shareKey:" + shareKey + "shareSecret:" + shareSecret;
        String jsonString = spyMemcachedClient.get(key);

        if (StringUtils.isBlank(jsonString)) {
            share = shareMapper.get(appKey, shareKey, shareSecret);
            jsonString = jsonMapper.toJson(share);
            spyMemcachedClient.set(key, MemcachedObjectType.SHARE.getExpiredTime(), jsonString);
        } else {
            share = jsonMapper.fromJson(jsonString, Share.class);
        }
        logger.info("获取共享文件 AppKey: {}, ShareKey: {}", appKey, shareKey);
        return share;
    }

    @Transactional(readOnly = false)
    @Override
    public int save(String appKey, Share object) {
        return shareMapper.save(appKey, object);
    }

    @Transactional(readOnly = false)
    @Override
    public int update(String appKey, Share object) {
        return shareMapper.update(appKey, object);
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(String appKey, Long id) {
        return shareMapper.delete(appKey, id);
    }

    @Autowired
    public void setShareMapper(ShareMapper shareMapper) {
        this.shareMapper = shareMapper;
    }

    @Autowired
    public void setSpyMemcachedClient(SpyMemcachedClient spyMemcachedClient) {
        this.spyMemcachedClient = spyMemcachedClient;
    }

}
