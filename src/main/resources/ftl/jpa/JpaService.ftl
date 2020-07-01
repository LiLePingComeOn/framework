package ${ftlParams.packageName}.Service;

import ${ftlParams.packageName}.Entity.${ftlParams.tableClass.entityName};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.management.relation.RoleResult;
import java.util.List;
import java.util.Map;

/*
 * @description ${ftlParams.tableClass.tableComment}Service层
 * @date ${.now?string('yyyy-MM-dd')}
 */
public interface ${ftlParams.tableClass.entityName}Service extends JpaRepository<${ftlParams.tableClass.entityName}, ${ftlParams.primiaryColumn.javaType}>, JpaSpecificationExecutor<${ftlParams.tableClass.entityName}> {
}
