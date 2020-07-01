package com.zksc.framework.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
       文件操作工具类
 */
public class FileUtils {

    /*
        根据包名创建文件目录
        @param packageName 包名
     */
    public static String createPackageFile(String packageName) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String filePath = rootPath + "/generator/main/java";
        //以'.'切割包名
        String[] fileStrings = packageName.split("\\.");
        //拼接生成的文件目录的位置
        for (int index = 0; index < fileStrings.length; index++) {
            filePath = filePath + "/" + fileStrings[index];
            File file = new File(filePath);
            //目录不存在则创建目录
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return filePath;
    }

    /*
        文件压缩
        @param sourceFile 需要压缩的文件
        @param fileName   压缩后的文件名称
        @param zos        zip输出流
     */
    public static void compressFile(File sourceFile, ZipOutputStream zipOutputStream, String fileName) throws IOException {
        //如果是文件，直接压缩,如果是目录 递归调用压缩
        if (sourceFile.isFile()) {
            zipOutputStream.putNextEntry(new ZipEntry(fileName));
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes))!= -1) {
                zipOutputStream.write(bytes, 0, len);
            }
            zipOutputStream.closeEntry();
            fileInputStream.close();

        }else{
            File[] sonFiles = sourceFile.listFiles();
            if (sonFiles.length == 0 || sonFiles == null ) {
                zipOutputStream.putNextEntry(new ZipEntry(fileName + "/"));
                zipOutputStream.closeEntry();

            }else{
                for (File indexFile : sonFiles) {
                    compressFile(indexFile,zipOutputStream,fileName + "/"+indexFile.getName());
                }
            }

        }

    }


    /*
        递归删除文件夹里面的文件，不删除文件夹
        @param resourceFile 根目录文件
     */
    public static void cleanFile(File resourceFile) {
        if (!resourceFile.exists())
            return;
        if (resourceFile.isFile()) {
            resourceFile.delete();
            System.out.println("File Delete Success");
            return;
        } else {
            File[] sonFiles = resourceFile.listFiles();
            for (File indexFile : sonFiles) {
                cleanFile(indexFile);
            }
        }
    }

    /*
        在classess中创建generator  java resource的文件目录

     */
    public static void createFile() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String[] filePath = {"/generator","/generator/main","/generator/main/java","/generator/main/resource"};

        for (String fileP : filePath) {
            File file = new File(rootPath + fileP);
            if (!file.isFile()) {
                file.mkdir();
            }
        }
    }


}
