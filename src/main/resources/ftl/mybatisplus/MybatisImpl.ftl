package ${ftlParams.packageName}.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import ${ftlParams.packageName}.entity.po.${ftlParams.tableClass.entityName};
import ${ftlParams.packageName}.service.${ftlParams.tableClass.entityName}Service;
import ${ftlParams.packageName}.dao.${ftlParams.tableClass.entityName}Mapper;

/**
 * @Description ${ftlParams.tableClass.tableComment}业务层处理
 * @Date        ${.now?string('yyyy-MM-dd')}
 * DAuthor
 */
@Service
@Slf4j
public class ${ftlParams.tableClass.entityName}Impl extends ServiceImpl<${ftlParams.tableClass.entityName}Mapper,${ftlParams.tableClass.entityName}> implements ${ftlParams.tableClass.entityName}Service {


    /**
    * 新增${ftlParams.tableClass.tableComment}
    * @param  ${ftlParams.tableClass.entityName?uncap_first} ${ftlParams.tableClass.tableComment}
    * @return 结果
    * @date   ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    public boolean insert${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return this.save(${ftlParams.tableClass.entityName?uncap_first});
    }

    /**
    * 根据主键删除${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.primiaryColumn.humpName} 需要删除的主键
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    @CacheInvalidate(name = "${ftlParams.tableClass.entityName?uncap_first}::", key = "#${ftlParams.primiaryColumn.humpName}")
    public boolean delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        return this.delete(${ftlParams.primiaryColumn.humpName});
    }

    /**
    * 根据主键批量删除${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.primiaryColumn.humpName}s 需要删除的主键数组
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    public boolean delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(${ftlParams.primiaryColumn.javaType}[] ${ftlParams.primiaryColumn.humpName}s){
        return ${ftlParams.tableClass.entityName?uncap_first}Mapper.delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s(${ftlParams.primiaryColumn.humpName}s);
    }
    /**
    * 更新${ftlParams.tableClass.tableComment}
    * @param ${ftlParams.tableClass.tableComment} ${ftlParams.tableClass.entityName?uncap_first}
    * @return 结果
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @Override
    @CacheInvalidate(name = "${ftlParams.tableClass.entityName?uncap_first}::", key = "${ftlParams.tableClass.entityName?uncap_first}.#${ftlParams.primiaryColumn.humpName}")
    public boolean update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName} ${ftlParams.tableClass.entityName?uncap_first}){
        return this.update${ftlParams.tableClass.entityName}(${ftlParams.tableClass.entityName?uncap_first});
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
    @Override
    @Cached(name = "${ftlParams.tableClass.entityName?uncap_first}::", key = "#${ftlParams.primiaryColumn.humpName}", cacheType = CacheType.BOTH)
    public ${ftlParams.tableClass.entityName} select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}(${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.humpName}){
        return this.getById(${ftlParams.primiaryColumn.humpName});
    }
}