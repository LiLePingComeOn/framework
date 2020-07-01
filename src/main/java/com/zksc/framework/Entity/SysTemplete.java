package com.zksc.framework.Entity;

public class SysTemplete extends BaseEntity {

    /*
        主键
     */
    private String templeteId;

    /*
        数据库类型
     */
    private String dataBaseType;

    /*
        框架类型  mybatis  jpa
     */
    private String frameworkType;

    /*
        ftl模板的路径
     */
    private String ftlPath;

    /*
        ftl模板的名字
     */
    private String ftlName;
    /*
        生成文件的名称
     */
    private String fileName;

    /*
        生成文件的路径
     */
    private String filePath;


    public String getTempleteId() {
        return templeteId;
    }

    public void setTempleteId(String templeteId) {
        this.templeteId = templeteId;
    }

    public String getDataBaseType() {
        return dataBaseType;
    }

    public void setDataBaseType(String dataBaseType) {
        this.dataBaseType = dataBaseType;
    }

    public String getFrameworkType() {
        return frameworkType;
    }

    public void setFrameworkType(String frameworkType) {
        this.frameworkType = frameworkType;
    }

    public String getFtlPath() {
        return ftlPath;
    }

    public void setFtlPath(String ftlPath) {
        this.ftlPath = ftlPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFtlName() {
        return ftlName;
    }

    public void setFtlName(String ftlName) {
        this.ftlName = ftlName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
