package com.zksc.framework.Utils;

import com.zksc.framework.Entity.FtlParams;
import com.zksc.framework.Entity.SysTemplete;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FreemarkConfiguration {


    private static Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    private static Template  template = null;
    private static OutputStreamWriter outputStreamWriter = null;



    /*
        根据板创建文件
        @params:ftlParams       ftl的参数
        @params:sysTemplete     生成文件的信息
     */
    public static void getTemplete(FtlParams ftlParams, SysTemplete sysTemplete) {
        //获取ftl存放的位置
        String rootFile = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String ftlPath = rootFile + "/ftl" + sysTemplete.getFtlPath();

        //获取代码生成文件的位置
        StringBuffer filePath = new StringBuffer();
        filePath.append(rootFile);

        //class文件
        if (sysTemplete.getFileName().endsWith("java")) {
            filePath.append("/generator/main/java");

            String packageName = ftlParams.getPackageName();
            String[] packageFilePaths = packageName.split("\\.");
            for (String indexString : packageFilePaths) {
                filePath.append("/").append(indexString);
            }

            filePath.append(sysTemplete.getFilePath());
            File classFile = new File(filePath.toString());
            if (!classFile.exists()) {
                classFile.mkdir();
            }
        }else{
            filePath.append("/generator/main/resource");
            filePath.append(sysTemplete.getFilePath());
            File xmlFile = new File(filePath.toString());
            if (!xmlFile.exists()) {
                xmlFile.mkdir();
            }
        }

        //文件的最终目录
        filePath.append("/").append(ftlParams.getTableClass().getEntityName()).append(sysTemplete.getFileName());
        try {
            configuration.setDirectoryForTemplateLoading(new File(ftlPath));
            configuration.setDefaultEncoding("UTF-8");
            configuration.setLocale(Locale.CHINA);
            template = configuration.getTemplate(sysTemplete.getFtlName(), "utf-8");
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(filePath.toString())));
            Map map = new HashMap<>();
            map.put("ftlParams", ftlParams);
            template.process(map,outputStreamWriter);
            outputStreamWriter.flush();
        } catch (Exception e) {

            e.printStackTrace();
        }finally {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
