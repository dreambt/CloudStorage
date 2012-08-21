package cn.im47.cloud.storage.common.entity.file;

import cn.im47.cloud.storage.common.entity.IdEntity;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * 文件存储节点
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public class Nodes extends IdEntity implements Serializable {

    private static final long serialVersionUID = -38331060124340966L;

    private String name;                 // 结点名称
    private FileTypeEnum type;           // 结点类型
    private long leftSibling;          // 左兄弟编号

    private long parentId;              // 父节点编号
    private List<Nodes> nodesList = Lists.newArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileTypeEnum getType() {
        return type;
    }

    public void setType(FileTypeEnum type) {
        this.type = type;
    }

    public long getLeftSibling() {
        return leftSibling;
    }

    public void setLeftSibling(long leftSibling) {
        this.leftSibling = leftSibling;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public List<Nodes> getNodesList() {
        return nodesList;
    }

    public void setNodesList(List<Nodes> nodesList) {
        this.nodesList = nodesList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
