package package ${ftlParams.packageName}.rest;

import com.springboot.cloud.common.core.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import ${ftlParams.packageName}.service.${ftlParams.tableClass.entityName}Service;
import ${ftlParams.packageName}.dao.po.${ftlParams.tableClass.entityName};
import ${ftlParams.packageName}.dao.form.${ftlParams.tableClass.entityName}Form;
import ${ftlParams.packageName}.dao.form.${ftlParams.tableClass.entityName}QueryForm;
import ${ftlParams.packageName}.dao.param.${ftlParams.tableClass.entityName}QueryParam;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

/*
 *  @Author
 *  @Date     ${.now?string('yyyy-MM-dd')}
 *  @Describe ${ftlParams.tableClass.tableComment}接口
 */
@RestController
@RequestMapping(value = "/${ftlParams.urlPerfix}/${ftlParams.tableClass.entityName}")
@Api("${ftlParams.tableClass.tableComment}")
@Slf4j
public class ${ftlParams.tableClass.entityName}Controller {

    @Autowired
    private ${ftlParams.tableClass.entityName}Service ${ftlParams.tableClass.entityName?uncap_first}Service;

   /*
    *   新增${ftlParams.tableClass.tableComment}
    *   @param   ${ftlParams.tableClass.entityName?uncap_first} 参数实体类
    *   @return  查询结果
    */
    @ApiOperation(value = "新增${ftlParams.tableClass.tableComment}", notes = "新增一个${ftlParams.tableClass.tableComment}")
    @ApiImplicitParam(name = "${ftlParams.tableClass.entityName?uncap_first}Form", value = "新增${ftlParams.tableClass.tableComment}的from表单", required = true, dataType = "${ftlParams.tableClass.entityName}Form")
    @PostMapping
    public Result insert${ftlParams.tableClass.entityName}(@Valid @RequestBody ${ftlParams.tableClass.entityName}Form ${ftlParams.tableClass.entityName?uncap_first}Form){
        ${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first} = new ${ftlParams.tableClass.entityName}();
        boolean result =  ${ftlParams.tableClass.entityName?uncap_first}Service.insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
        if(result){
            return Result.success(result);
        }else{
            return Result.fail();
        }
    }

   /*
    *   根据id删除${ftlParams.tableClass.tableComment}
    *   @param          ${ftlParams.tableClass.entityName?uncap_first} 参数实体类
    *   @return         查询结果
    *   @date           ${.now?string('yyyy/MM/dd')}
    */
    @ApiOperation(value = "删除${ftlParams.tableClass.tableComment}", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "${ftlParams.primiaryColumn.humpName}", value = "${ftlParams.tableClass.tableComment}${ftlParams.primiaryColumn.humpName}", required = true, dataType = "${ftlParams.primiaryColumn.javaType}")
    @DeleteMapping(value = "/{${ftlParams.primiaryColumn.humpName}}")
    public Result delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(@PathVariable ${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        boolean result = ${ftlParams.tableClass.entityName?uncap_first}Service.delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.humpName});
        if(result){
            return Result.success(result);
        }else{
            return Result.fail();
        }
    }

   /*
    * 根据主键批量删除${ftlParams.tableClass.tableComment}
    * @param  ${ftlParams.primiaryColumn.humpName}s 需要删除的主键,用",隔开"
    * @return 操作结果
    * @date   ${.now?string('yyyy/MM/dd')}
    */
    public int delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}s){
        try{
            String[] idArray = ${ftlParams.primiaryColumn.humpName}s.split(",");
            ${ftlParams.tableClass.entityName?uncap_first}Mapper.delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(idArray);
            return Result.success();
        }catch(Exception e){
            returnResult.fail();
        }
    }

   /*
    *   根据主键更新${ftlParams.tableClass.tableComment}
    *   @param   ${ftlParams.tableClass.entityName?uncap_first} 参数实体类
    *   @return  查询结果
    */
    @ApiOperation(value = "修改${ftlParams.tableClass.tableComment}", notes = "修改指定${ftlParams.tableClass.tableComment}信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "${ftlParams.primiaryColumn.humpName}", value = "修改${ftlParams.tableClass.tableComment}${ftlParams.primiaryColumn.humpName}", required = true, dataType = "${ftlParams.primiaryColumn.javaType}"),
            @ApiImplicitParam(name = "${ftlParams.tableClass.entityName?uncap_first}", value = "${ftlParams.tableClass.tableComment}实体", required = true, dataType = "${ftlParams.tableClass.entityName}")
    })
    @PutMapping("{/{${ftlParams.primiaryColumn.humpName}}")
    public Result update${ftlParams.tableClass.entityName}(@Valid @RequestBody ${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        boolean result = ${ftlParams.tableClass.entityName?uncap_first}Service.update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
        if(boolean){
            return Result.success(result);
        }else{
            return Result.fail();
        }
    }

   /*
    *   查询${ftlParams.tableClass.tableComment}
    *   @param   ${ftlParams.tableClass.entityName?uncap_first} 参数实体类
    *   @return  查询结果
    */
    @RequestMapping("/selectList.do")
    public int select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        List<${ftlParams.tableClass.entityName}> list${ftlParams.tableClass.entityName} = ${ftlParams.tableClass.entityName?uncap_first}Service.select${ftlParams.tableClass.entityName}List(${ftlParams.tableClass.entityName?uncap_first});
        return Result.success(list${ftlParams.tableClass.entityName});
    }
}