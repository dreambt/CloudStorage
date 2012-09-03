package cn.im47.cloud.storage.utilities.memcached;

/**
 * 统一定义Memcached中存储的各种对象的Key前缀和超时时间.
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-8-12
 * Time: 下午14:48
 */
public enum MemcachedObjectType {

    NODE("node:", 60 * 1 * 1),
    FILE("file:", 60 * 1 * 1),
    USER("user:", 60 * 1 * 1),
    FTPUSER("ftpuser:", 60 * 1 * 1),
    SHARE("share:", 60 * 1 * 1);

    private String prefix;
    private int expiredTime;

    MemcachedObjectType(String prefix, int expiredTime) {
        this.prefix = prefix;
        this.expiredTime = expiredTime;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

}
