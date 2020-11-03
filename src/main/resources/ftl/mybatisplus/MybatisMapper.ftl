package ${ftlParams.packageName}.dao;

import ${ftlParams.packageName}.dao.po.${ftlParams.tableClass.entityName};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Description ${ftlParams.tableClass.tableComment}Mapper接口
 * @Date        ${.now?string('yyyy-MM-dd')}
 * @Author
 */

@Repository
@Mapper
public interface ${ftlParams.tableClass.entityName}Mapper extend BaseMapper<${ftlParams.tableClass.entityName} > {
}
