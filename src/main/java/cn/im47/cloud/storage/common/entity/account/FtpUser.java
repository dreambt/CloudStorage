package cn.im47.cloud.storage.common.entity.account;

import cn.im47.cloud.storage.common.entity.PersistableEntity;

/**
 * ftp 账号信息
 * User: pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-8-21
 * Time: 下午2:01
 */
public class FtpUser extends PersistableEntity {

    private String userName;
    private String userPassword;
    private String homeDirectory;
    private boolean enableFlag;
    private boolean writePermission;
    private int idleTime;
    private int uploadRate;
    private int downloadRate;
    private int maxLoginNumber;
    private int maxLoginPerIp;
    private boolean deleted;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }

    public void setHomeDirectory(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public boolean isEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    public boolean isWritePermission() {
        return writePermission;
    }

    public void setWritePermission(boolean writePermission) {
        this.writePermission = writePermission;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public int getUploadRate() {
        return uploadRate;
    }

    public void setUploadRate(int uploadRate) {
        this.uploadRate = uploadRate;
    }

    public int getDownloadRate() {
        return downloadRate;
    }

    public void setDownloadRate(int downloadRate) {
        this.downloadRate = downloadRate;
    }

    public int getMaxLoginNumber() {
        return maxLoginNumber;
    }

    public void setMaxLoginNumber(int maxLoginNumber) {
        this.maxLoginNumber = maxLoginNumber;
    }

    public int getMaxLoginPerIp() {
        return maxLoginPerIp;
    }

    public void setMaxLoginPerIp(int maxLoginPerIp) {
        this.maxLoginPerIp = maxLoginPerIp;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
