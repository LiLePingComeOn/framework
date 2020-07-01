package com.zksc.framework.Entity;

import java.io.Serializable;
import java.util.Date;

/*
    基础类，所有mybatis实体类都要继承
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private String delFlag;

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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
