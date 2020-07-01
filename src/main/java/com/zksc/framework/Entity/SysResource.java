package com.zksc.framework.Entity;
import java.util.Date;
import java.util.List;

/**
 * @date 2020-06-13
 */
public class SysResource{


    /**
     * 资源id
     */
    private String resoureId;

    /**
     * 资源url
     */
    private String resourceUrl;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源权限
     */
    private String resourcePermission;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 资源的父菜单
     */
    private String resourceParent;

    /**
     * 资源的图标
     */
    private String resourceIco;

    /**
     * 同级别资源的顺序
     */
    private String resourceOrder;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 跟新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;



    public String getResoureId() {
        return resoureId;
    }

    public void setResoureId(String resoureId) {
        this.resoureId = resoureId;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourcePermission() {
        return resourcePermission;
    }

    public void setResourcePermission(String resourcePermission) {
        this.resourcePermission = resourcePermission;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceParent() {
        return resourceParent;
    }

    public void setResourceParent(String resourceParent) {
        this.resourceParent = resourceParent;
    }

    public String getResourceIco() {
        return resourceIco;
    }

    public void setResourceIco(String resourceIco) {
        this.resourceIco = resourceIco;
    }

    public String getResourceOrder() {
        return resourceOrder;
    }

    public void setResourceOrder(String resourceOrder) {
        this.resourceOrder = resourceOrder;
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

}