package cn.im47.cloud.storage.common.entity.file;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 文件类型Enum
 * User: baitao.jibt@gmail.com
 * Date: 12-4-25
 * Time: 上午10:47
 */
public enum NodeTypeEnum {

    PIC("图片"), MOVIE("电影"), TXT("文本"), OTHER("其他"), NONE("无");

    private String value;
    private static final Map<String, NodeTypeEnum> lookup = Maps.newHashMap();

    static {
        for (NodeTypeEnum c : NodeTypeEnum.values())
            lookup.put(c.toString(), c);
    }

    NodeTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
