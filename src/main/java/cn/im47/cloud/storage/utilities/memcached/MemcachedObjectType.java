package cn.im47.album.utilities.memcached;

/**
 * 类功能
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-15
 * Time: 下午10:47
 */
public enum MemcachedObjectType {

    // 大数据请把过期时间调小一些，谢谢~
    NODE("flight:", 60 * 60 * 1);              // 文件存储结点

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
