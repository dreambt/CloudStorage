package cn.im47.cloud.storage.common.entity.share;

import cn.im47.commons.entity.PersistableEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.LocalDateTime;

import java.io.Serializable;

/**
 * 分享 entity
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-9-3
 * Time: 下午1:59
 */
public class Share extends PersistableEntity implements Serializable {

    private static final long serialVersionUID = -34331060124340965L;

    private String shareKey;
    private String shareSecret;
    private String fileKey;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expiredDate;

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }

    public String getShareSecret() {
        return shareSecret;
    }

    public void setShareSecret(String shareSecret) {
        this.shareSecret = shareSecret;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
