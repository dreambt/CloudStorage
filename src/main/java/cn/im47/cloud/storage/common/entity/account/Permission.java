package cn.im47.cloud.storage.common.entity.account;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 权限枚举.Resource Base Access Control中的资源定义.
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-3-20
 * Time: 下午20:14
 */
public enum Permission {

    USER_LIST("user:list", "查看用户"), USER_CREATE("user:create", "新建用户"),
    USER_UPDATE("user:update", "更新用户"), USER_SAVE("user:save", "修改用户"),

    GROUP_LIST("group:list", "查看用户组"), GROUP_CREATE("group:create", "新建用户组"),
    GROUP_UPDATE("group:update", "更新用户组"), GROUP_SAVE("group:save", "修改用户组"),

    FILE_LIST("file:list", "查看文件"), FILE_CREATE("file:create", "新建文件"),
    FILE_UPDATE("file:update", "更新文件"), FILE_SAVE("file:save", "修改文件"),

    NODE_LIST("node:list", "查看结点"), NODE_CREATE("node:create", "新建结点"),
    NODE_UPDATE("node:update", "更新结点"), NODE_SAVE("node:save", "修改结点");

    private static Map<String, Permission> valueMap = Maps.newHashMap();

    private String value;
    private String displayName;

    static {
        for (Permission permission : Permission.values()) {
            valueMap.put(permission.value, permission);
        }
    }

    Permission(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static Permission parse(String value) {
        return valueMap.get(value);
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}