package ${ftlParams.packageName}.Service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ${ftlParams.packageName}.Entity.${ftlParams.tableClass.entityName};
import ${ftlParams.packageName}.Service.${ftlParams.tableClass.entityName}Service;
import ${ftlParams.packageName}.Mapper.${ftlParams.tableClass.entityName}Mapper;

/**
 * @description ${ftlParams.tableClass.tableComment}业务层处理
 * @date ${.now?string('yyyy-MM-dd')}
 */
@Service
public class ${ftlParams.tableClass.entityName}Impl implements ${ftlParams.tableClass.entityName}Service {

    @Autowired
	private ${ftlParams.tableClass.entityName}Mapper ${ftlParams.tableClass.entityName?uncap_first}Mapper;

    /**
    * 新增${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.entityName?uncap_first} ${ftlParams.tableClass.tableComment}
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    public int insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
    }

    /**
    * 根据主键删除${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.primiaryColumn.humpName} 需要删除的主键
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    public int delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.humpName});
    }

    /**
    * 根据主键批量删除${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.primiaryColumn.humpName}s 需要删除的主键数组
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public int delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(${ftlParams.primiaryColumn.javaType}[] ${ftlParams.primiaryColumn.humpName}s){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(${ftlParams.primiaryColumn.humpName}s);
    }
    /**
    * 更新${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment} ${ftlParams.tableClass.entityName?uncap_first}
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    public int update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
    }

    /**
    * 查询${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment} ${ftlParams.tableClass.entityName?uncap_first}
    * @return ${ftlParams.tableClass.tableComment}集合
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    public List<${ftlParams.tableClass.entityName}> select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName?uncap_first});
    }

    /*
    * 根据id查询${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment}主键
    * @return ${ftlParams.tableClass.tableComment}
    * @date ${.now?string('yyyy/MM/dd')}
    */
    public ${ftlParams.tableClass.entityName} select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.humpName});
    }
}