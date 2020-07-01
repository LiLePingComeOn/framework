package com.zksc.framework.Entity;

import java.util.Date;

/**
 * @date 2020-06-14
 */
public class SysUser{


    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更改人
     */
    private String updateBy;

    /**
     * 删除标志 1代表不删除 0代表删除
     */
    private char dalFlag;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public char getDalFlag() {
        return dalFlag;
    }

    public void setDalFlag(char dalFlag) {
        this.dalFlag = dalFlag;
    }

}