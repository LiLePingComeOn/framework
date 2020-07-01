package com.zksc.framework.Entity;
import java.util.Date;
import java.util.List;

/**
 * @date 2020-06-13
 */
public class SysUserRole{


    /**
    * �û�id
    */
    private String userRoleId;

    /**
    * ��ɫid
    */
    private String roleId;

    /**
    * ����ʱ��
    */
    private Date createTime;

    /**
    * ����ʱ��
    */
    private Date updateTime;

    /**
    * ������
    */
    private String createBy;

    /**
    * ������
    */
    private String updateBy;

    /**
    * ɾ����־ 1δɾ�� 0��ɾ��
    */
    private char delFlag;

    /**
    * id
    */
    private String roleUserId;



    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public char getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(char delFlag) {
        this.delFlag = delFlag;
    }

    public String getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(String roleUserId) {
        this.roleUserId = roleUserId;
    }

}