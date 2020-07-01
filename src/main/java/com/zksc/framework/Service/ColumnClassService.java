package com.zksc.framework.Service;

import com.zksc.framework.Entity.ColumnClass;
import com.zksc.framework.Entity.TableClass;

import java.util.List;

public interface ColumnClassService {
    //查询数据库表中的字段
    public List<ColumnClass> getAllColumn(String tableName,String dataBaseName);

    //查询数据表信息
    public List<TableClass> selectAllTable(String tableName,String dataBaseName);
}
