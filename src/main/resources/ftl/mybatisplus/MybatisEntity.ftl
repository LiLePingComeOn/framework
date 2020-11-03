package ${ftlParams.packageName}.Entity;

import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.springboot.cloud.common.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Description ${ftlParams.tableClass.tableComment}实体类
 * @Date        ${.now?string('yyyy-MM-dd')}
 * @Author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("${ftlParams.tableClass.tableName}")
public class ${ftlParams.tableClass.entityName} extends BasePo {


<#if ftlParams.filterColumnList?exists && ftlParams.filterColumnList?size gt 0>
    <#list ftlParams.filterColumnList as colunnClass >
    /**
    * ${colunnClass.columnComment}
    */
    private ${colunnClass.javaType} ${colunnClass.humpName};

    </#list>
</#if>
}