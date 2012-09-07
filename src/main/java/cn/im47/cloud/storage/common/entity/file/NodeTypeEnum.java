package cn.im47.cloud.storage.common.entity.file;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 节点类型Enum
 * User: baitao.jibt@gmail.com
 * Date: 12-4-25
 * Time: 上午10:47
 */
public enum NodeTypeEnum {

    PIC("PIC", "图片"), MOVIE("MOVIE", "视频"), TXT("TXT", "文本"), OTHER("OTHER", "其他"), NONE("NONE", "无");

    private String value;
    private String displayName;
    private static Map<String, NodeTypeEnum> valueMap = Maps.newHashMap();

    static {
        for (NodeTypeEnum c : NodeTypeEnum.values())
            valueMap.put(c.value, c);
    }

    NodeTypeEnum(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static NodeTypeEnum parse(String value) {
        return valueMap.get(value);
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}
