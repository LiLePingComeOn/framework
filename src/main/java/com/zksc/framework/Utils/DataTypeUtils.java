package com.zksc.framework.Utils;

import java.util.HashMap;
import java.util.Map;

//数据库的字段类型和Java中的类型对应关系
public class DataTypeUtils {

    public static Map mysqlTypeMap = new HashMap<>();
    private static Map oracleTypeMap = new HashMap<>();

    static {
        mysqlTypeMap.put("VARCHAR", "String");
        mysqlTypeMap.put("CHAR", "char");
        mysqlTypeMap.put("TEXT", "String");
        mysqlTypeMap.put("VARCHAR", "String");
        mysqlTypeMap.put("INT", "int");
        mysqlTypeMap.put("DATE", "Date");
        mysqlTypeMap.put("DATETIME", "Date");
    }


    public static String getMysqlType(String mysqlType) {

        return mysqlTypeMap.get(mysqlType).toString();
    }

    public static String getOracleType(String oracleType) {
        return oracleTypeMap.get(oracleType).toString();
    }
}
