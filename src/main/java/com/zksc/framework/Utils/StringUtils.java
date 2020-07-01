package com.zksc.framework.Utils;

public class StringUtils {


    //将数据表名转化为驼峰命名
    public static String getTableName(String tableName) {

        //将tableName全部转换陈小写
        tableName = tableName.toLowerCase();
        System.out.println("Stringis：" + tableName);
        StringBuffer stringBuffer = new StringBuffer();
        //用-切割数据表名
        String[] wordArray = tableName.split("_");
        for (int index = 0; index < wordArray.length; index++) {

            String word = wordArray[index];
            char[] char_array = word.toCharArray();

            //将首字母设置为大写
            if (char_array[0] >= 'a' && char_array[0] <= 'z') {
                int charASCII = char_array[0] - 32;
                char_array[0] = (char) charASCII;
            }

            String new_word = String.valueOf(char_array);
            stringBuffer.append(new_word);
        }

        return stringBuffer.toString();
    }

    //将字段名转为驼峰命名
    public static String getColumnName(String columnName) {
        StringBuffer stringBuffer = new StringBuffer();
        //用-切割数据表名
        String[] wordArray = columnName.split("_");
        for (int index = 0; index < wordArray.length; index++) {
            String word = wordArray[index];
            char[] char_array = word.toCharArray();

            if (index > 0) {
                //将首字母设置为大写
                if (char_array[0] >= 'a' && char_array[0] <= 'z') {
                    int charASCII = char_array[0] - 32;
                    char_array[0] = (char) charASCII;
                }
            }

            String new_word = String.valueOf(char_array);
            stringBuffer.append(new_word);
        }
        return stringBuffer.toString();
    }
}
