package cn.im47.cloud.storage.common.entity.file;

import cn.im47.commons.entity.IdEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 文件存储节点
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-11
 * Time: 上午10:56
 */
public class NodeAdjacencies extends IdEntity implements Serializable {

    private static final long serialVersionUID = -38331060124340967L;

    private Long pId;
    private Long cId;
    private Long pLen;

    public Long getPId() {
        return pId;
    }

    public void setPId(Long pId) {
        this.pId = pId;
    }

    public Long getCId() {
        return cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public Long getPLen() {
        return pLen;
    }

    public void setPLen(Long pLen) {
        this.pLen = pLen;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
