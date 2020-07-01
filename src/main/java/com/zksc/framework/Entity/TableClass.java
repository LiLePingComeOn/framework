package com.zksc.framework.Entity;

import com.zksc.framework.Utils.StringUtils;

/*
    数据表实体类
 */
public class TableClass {

    //数据库中表名
    private String tableName;

    //数据库表注释
    private String tableComment = "";

    //实体类的名称
    private String entityName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName.toLowerCase();
        //设置实体类的名称
        this.entityName = StringUtils.getTableName(tableName);
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
