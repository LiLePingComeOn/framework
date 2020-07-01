package com.zksc.framework.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zksc.framework.Entity.*;
import com.zksc.framework.Service.ColumnClassService;
import com.zksc.framework.Service.SysResourceService;
import com.zksc.framework.Service.SysTempleteService;
import com.zksc.framework.Utils.FileUtils;
import com.zksc.framework.Utils.FreemarkConfiguration;
import com.zksc.framework.Utils.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/generate")
public class CodeGenerateController {

    @Autowired
    private ColumnClassService columnClassService;

    @Autowired
    private SysTempleteService sysTempleteService;

    @Autowired
    private SysResourceService sysResourceService;

    private ZipOutputStream zipOutputStream = null;

    //数据库连接信息
    @Value("${spring.datasource.url}")
    private String connectMessage;

    /*
        获取数据库中的表名
     */


    /*
         获取表中的字段列表
     */
    @RequestMapping("/getColumn.do")
    public String  getTableColumn(String tableName) {

        //正则表达式获取
        String mysqlC = "jdbc:mysql://localhost:3306/fjgjshgjf?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String patternString = "([a-zA-Z]{5,})[/?$]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(mysqlC);

        if (matcher.find()) {

            System.out.println("dataBase is" + matcher.group(1));
        }
        return connectMessage;
    }

    /*
        代码生成
        @param tableName   表名
        @parsm frameworkType 框架类型 1表示mybatis  2表示jpa
     */
    @RequestMapping("/getCode.do")
    public String test(String packageName, String tableName,String frameworkType,HttpServletResponse response) throws TemplateException {

        //滤空
        if (frameworkType == null || frameworkType == "")
            frameworkType = "1";
        //获取数据库连接的数据库名
        String patternString = "([a-zA-Z]{5,})[/?$]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(connectMessage);
        String dataBaseName = "";
        if (matcher.find()) {

            dataBaseName =  matcher.group(1);

        }

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String deleteFilePath = rootPath + "/generator";
        File deleteFile = new File(deleteFilePath);

        //创建代码生成文件存放目录
        FileUtils.createFile();

        //清除上次代码生成产生的文件
        FileUtils.cleanFile(deleteFile);

        //根据包名生成文件夹
        FileUtils.createPackageFile(packageName);

        //根据表名查询表信息 字段信息
        List<ColumnClass> columnClassList = columnClassService.getAllColumn(tableName,dataBaseName);
        List<TableClass> tableClassList = columnClassService.selectAllTable(tableName,dataBaseName);

        //表的长度为零，代表没有这张表
        if (tableClassList.size() == 0) {
            return "fail";
        }

        //设置代码生成的数据
        FtlParams ftlParams = new FtlParams();
        ftlParams.setPackageName(packageName);
        ftlParams.setTableClass(tableClassList.get(0));
        ftlParams.setColumnClassList(columnClassList);

        //查询数据库，获取代码生成文件的信息
        List<SysTemplete> sysTempleteList = sysTempleteService.getTempleteList(frameworkType);
        for (SysTemplete sysTemplete : sysTempleteList) {
            //执行代码生成文件
            FreemarkConfiguration.getTemplete(ftlParams, sysTemplete);
        }
        //压缩文件
        String zipPath = rootPath +"/generator/main";
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(rootPath+"/generator/generator.zip")));
            FileUtils.compressFile(new File(zipPath),zipOutputStream,"main");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                zipOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //下载文件
        String dowloadFilePth = rootPath + "/generator/generator.zip";
        File dowloadFile = new File(dowloadFilePth);
        if (dowloadFile.exists()) {

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + dowloadFile.getName());
            byte[] buff = new byte[1024];
            //创建缓冲输入流
            BufferedInputStream bufferedInputStream = null;
            OutputStream outputStream = null;

            try {
                outputStream = response.getOutputStream();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(dowloadFile));
                int len = 0;
                while ((len = bufferedInputStream.read(buff))!= -1) {
                    outputStream.write(buff, 0, len);
                }
            } catch (Exception e) {
            }finally {
                try {
                    outputStream.close();
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return deleteFilePath;
    }


}

