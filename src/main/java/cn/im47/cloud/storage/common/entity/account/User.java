package cn.im47.cloud.storage.common.entity.account;

import cn.im47.commons.entity.PersistableEntity;
import cn.im47.commons.utilities.encoder.IPEncodes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springside.modules.utils.Collections3;

import java.util.Date;
import java.util.List;

/**
 * 用户Entity
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-20
 * Time: 下午19:55
 */
public class User extends PersistableEntity {

    //用户基本信息
    private String email;
    private String username;
    private String plainPassword;
    private String password;
    private String salt;
    private boolean status;
    private boolean emailStatus;
    private boolean avatarStatus;
    private boolean deleted;
    private String photoURL;
    private String timeOffset;
    private List<Group> groupList = Lists.newArrayList();
    private Long lastIP;
    private String lastLoginIP;


    private Date lastTime;
    private Date lastActTime;

    //用户详细信息
    private String realName;
    private String englishName;
    private boolean sex;
    private Date birthday;
    private String bloodGroup;
    private String home;
    private String livingAddress;
    private String zipCode;
    private int mobile;
    private int telphone;
    private int qq;
    private String msn;
    private String profession;
    private String education;

    public User() {
    }

    public User(Long id) {
        super.setId(id);
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(boolean emailStatus) {
        this.emailStatus = emailStatus;
    }

    public boolean isAvatarStatus() {
        return avatarStatus;
    }

    public void setAvatarStatus(boolean avatarStatus) {
        this.avatarStatus = avatarStatus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(String timeOffset) {
        this.timeOffset = timeOffset;
    }

    public Long getLastIP() {
        return lastIP;
    }

    public void setLastIP(Long lastIP) {
        this.lastIP = lastIP;
    }

    public String getLastLoginIP() {
        return IPEncodes.longToIp(lastIP);
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastIP = IPEncodes.ipToLong(lastLoginIP);
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getLastActTime() {
        return lastActTime;
    }

    public void setLastActTime(Date lastActTime) {
        this.lastActTime = lastActTime;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getTelphone() {
        return telphone;
    }

    public void setTelphone(int telphone) {
        this.telphone = telphone;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 用户拥有的权限组名称字符串, 多个权限组名称用','分隔.
     */
    public String getGroupNames() {
        return Collections3.extractToString(groupList, "groupName", ", ");
    }

    @JsonIgnore
    public Long getGroupId() {
        // TODO 如果不判断，攻略列表分页出现group NullPointException
        if (this.groupList.size() == 0) {
            return 1L;
        } else {
            return groupList.get(0).getId();
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}