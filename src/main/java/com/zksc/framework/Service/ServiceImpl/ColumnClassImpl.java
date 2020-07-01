package com.zksc.framework.Service.ServiceImpl;

import com.zksc.framework.Entity.ColumnClass;
import com.zksc.framework.Entity.TableClass;
import com.zksc.framework.Mapper.ColumnClassMapper;
import com.zksc.framework.Service.ColumnClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ColumnClassImpl implements ColumnClassService {

    @Autowired
    private ColumnClassMapper columnClassMapper;


    @Override
    public List<ColumnClass> getAllColumn(String tableName,String dataBaseName) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableName);
        map.put("dataBaseName", dataBaseName);
        return columnClassMapper.getAllColumn(map);
    }

    @Override
    public List<TableClass> selectAllTable(String tableName,String dataBaseName) {
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableName);
        map.put("dataBaseName", dataBaseName);
        return columnClassMapper.selectAllTable(map);
    }


}
