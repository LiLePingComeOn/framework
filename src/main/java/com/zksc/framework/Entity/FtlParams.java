package com.zksc.framework.Entity;

import java.util.List;

/*
        每个ktl参数
 */
public class FtlParams {

    //数据表信息
    private TableClass tableClass;

    //数据字段信息
    private List<ColumnClass> columnClassList;

    //包名
    private String packageName = "";

    //主键字段的信息
    private ColumnClass primiaryColumn = null;

    public TableClass getTableClass() {
        return tableClass;
    }

    public void setTableClass(TableClass tableClass) {
        this.tableClass = tableClass;
    }

    public List<ColumnClass> getColumnClassList() {
        return columnClassList;
    }

    public void setColumnClassList(List<ColumnClass> columnClassList) {
        this.columnClassList = columnClassList;

        //查询出每张表的主键
        for (ColumnClass columnClass : columnClassList) {

            if ("PRI".equals(columnClass.getColumnKey())) {
                this.primiaryColumn = columnClass;
                break;
            }

        }

        //如果没有主键，那么取第一个字段作为主键
        if (primiaryColumn == null) {
            primiaryColumn = columnClassList.get(0);
        }
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public ColumnClass getPrimiaryColumn() {
        return primiaryColumn;
    }

    public void setPrimiaryColumn(ColumnClass primiaryColumn) {
        this.primiaryColumn = primiaryColumn;
    }
}

