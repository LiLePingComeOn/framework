package com.zksc.framework.Entity;

import com.zksc.framework.Utils.DataTypeUtils;
import com.zksc.framework.Utils.StringUtils;

public class ColumnClass {

    //表中字段的名称
    private String columnName = "";

    //表中字段的类型
    private String dataType = "";

    //表中字段的注释
    private String columnComment = "";

    //驼峰命名的名称,首单词为小写
    private String humpName = "";

    //数据库类型对应的java数据类型
    private String javaType = "";

    //索引名称，PRI则为主键
    private String columnKey ="";

    //字段做参数的驼峰命名，首单词为大写
    private String paramName = "";


    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        //设置驼峰命名的名称
        this.humpName = StringUtils.getColumnName(columnName);
        //设置作参数时的名字，驼峰命名 首单词大写
        this.paramName = StringUtils.getTableName(columnName);
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {

        this.dataType = dataType.toUpperCase();
        //设置对应的Java的数据类型
        this.javaType = DataTypeUtils.getMysqlType(this.dataType);
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getHumpName() {
        return humpName;
    }

    public void setHumpName(String humpName) {
        this.humpName = humpName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }
}
