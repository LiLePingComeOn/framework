package ${ftlParams.packageName}.service;

import java.util.List;
import ${ftlParams.packageName}.entity.po.${ftlParams.tableClass.entityName};
/**
 * @Description ${ftlParams.tableClass.tableComment}Service接口
 * @Date        ${.now?string('yyyy-MM-dd')}
 * @Author
 */
public interface ${ftlParams.tableClass.entityName}Service {

     /**
    * 新增${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.entityName?uncap_first} ${ftlParams.tableClass.tableComment}
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public boolean insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first});

    /**
    * 根据主键删除${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.primiaryColumn.humpName} 需要删除的主键
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public boolean delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName});

    /**
    * 根据主键批量删除${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.primiaryColumn.humpName}s 需要删除的主键数组
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public int delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(${ftlParams.primiaryColumn.javaType}[] ${ftlParams.primiaryColumn.humpName}s);

    /**
    * 更新${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment} ${ftlParams.tableClass.entityName?uncap_first}
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public boolean update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first});

    /**
    * 查询${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment} ${ftlParams.tableClass.entityName?uncap_first}
    * @return ${ftlParams.tableClass.tableComment}集合
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public List<${ftlParams.tableClass.entityName}> select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first});

    /*
    * 根据id查询${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment}主键
    * @return ${ftlParams.tableClass.tableComment}
    * @date ${.now?string('yyyy/MM/dd')}
    */
    public ${ftlParams.tableClass.entityName} select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName});

}
