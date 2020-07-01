package ${ftlParams.packageName}.Entity;

import java.util.Date;
import java.util.List;

/**
 * @date ${.now?string('yyyy-MM-dd')}
 */
public class ${ftlParams.tableClass.entityName}{


<#if ftlParams.columnClassList?exists && ftlParams.columnClassList?size gt 0>
    <#list ftlParams.columnClassList as colunnClass >
    /**
    * ${colunnClass.columnComment}
    */
    private ${colunnClass.javaType} ${colunnClass.humpName};

    </#list>
</#if>

<#if ftlParams.columnClassList?exists && ftlParams.columnClassList?size gt 0>

    <#list ftlParams.columnClassList as colunnClass>
    public ${colunnClass.javaType} get${colunnClass.humpName?cap_first}() {
        return ${colunnClass.humpName};
    }

    public void set${colunnClass.humpName?cap_first}(${colunnClass.javaType} ${colunnClass.humpName}) {
        this.${colunnClass.humpName} = ${colunnClass.humpName};
    }

    </#list>
</#if>
}