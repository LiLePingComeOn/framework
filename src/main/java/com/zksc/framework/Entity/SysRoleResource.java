package com.zksc.framework.Entity;
import java.util.Date;
import java.util.List;

/**
 * @date 2020-06-13
 */
public class SysRoleResource{


    /**
    * id
    */
    private String roleResourceId;

    /**
    * ��ɫid
    */
    private String roleId;

    /**
    * ��Դid
    */
    private String resourceId;

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
    * ɾ����־ 1����ɾ�� 0����δɾ��
    */
    private char delFlag;



    public String getRoleResourceId() {
        return roleResourceId;
    }

    public void setRoleResourceId(String roleResourceId) {
        this.roleResourceId = roleResourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
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

}