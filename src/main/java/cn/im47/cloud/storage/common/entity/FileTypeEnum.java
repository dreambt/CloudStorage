package cn.im47.cloud.storage.common.entity;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 文件类型Enum
 * User: baitao.jibt@gmail.com
 * Date: 12-4-25
 * Time: 上午10:47
 */
public enum FileTypeEnum {

    PIC("图片"), MOVIE("电影"), TXT("文本"), OTHER("其他");

    private String value;
    private static final Map<String, FileTypeEnum> lookup = Maps.newHashMap();

    static {
        for (FileTypeEnum c : FileTypeEnum.values())
            lookup.put(c.toString(), c);
    }

    FileTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
