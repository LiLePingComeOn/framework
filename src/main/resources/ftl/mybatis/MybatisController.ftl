package package ${ftlParams.packageName}.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import ${ftlParams.packageName}.Service.${ftlParams.tableClass.entityName}Service;
import ${ftlParams.packageName}.Entity.${ftlParams.tableClass.entityName};
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/${ftlParams.tableClass.entityName}")
public class ${ftlParams.tableClass.entityName}Controller {

    @Autowired
    private ${ftlParams.tableClass.entityName}Service ${ftlParams.tableClass.entityName?uncap_first}Service;

    /*
    *   数据新增
    *
    */
    @RequestMapping("/insert.do")
    public int insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return ${ftlParams.tableClass.entityName?uncap_first}Service.insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
    }

    /*
    *   根据id删除数据
    *
    */
    @RequestMapping("/delete.do")
    public int delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        return ${ftlParams.tableClass.entityName?uncap_first}Service.delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.humpName});
    }

    /*
    *   根据id更新数据
    *
    */
    @RequestMapping("/update.do")
    public int update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return ${ftlParams.tableClass.entityName?uncap_first}Service.update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
    }

    /*
    *   查询数据
    *
    */
    @RequestMapping("/selectList.do")
    public int select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return ${ftlParams.tableClass.entityName?uncap_first}Service.select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName?uncap_first});
    }

    /*
    *   查询id查询数据
    *
    */
    public ${ftlParams.tableClass.entityName} select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        return ${ftlParams.tableClass.entityName?uncap_first}Service.select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.humpName});
    }

}