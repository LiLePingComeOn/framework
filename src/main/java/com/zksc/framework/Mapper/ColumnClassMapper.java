package com.zksc.framework.Mapper;


import com.zksc.framework.Entity.ColumnClass;
import com.zksc.framework.Entity.TableClass;

import java.util.List;
import java.util.Map;

public interface ColumnClassMapper {

    //查询数据库表中的字段
    public List<ColumnClass> getAllColumn(Map<String,Object> map);

    //查询数据表信息
    public List<TableClass> selectAllTable(Map<String,Object> map);

}
