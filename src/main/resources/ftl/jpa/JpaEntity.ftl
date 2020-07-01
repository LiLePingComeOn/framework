package ${ftlParams.packageName}.Entity;

import javax.persistence.*;

/*
 * @description ${ftlParams.tableClass.tableComment}实体类
 * @date ${.now?string('yyyy-MM-dd')}
 */
@Entity
@Table(name = "${ftlParams.tableClass.tableName}")
public class ${ftlParams.tableClass.entityName} {

    @Id
    @GeneratedValue
    private ${ftlParams.primiaryColumn.javaType} ${ftlParams.primiaryColumn.columnName};

<#if ftlParams.columnClassList?exists && ftlParams.columnClassList?size gt 0>
    <#list ftlParams.columnClassList as colunnClass >
    <#if colunnClass.columnKey != "PRI">
    /**
    * ${colunnClass.columnComment}
    */
    @Column(name = "${colunnClass.columnName}")
    private ${colunnClass.javaType} ${colunnClass.humpName};
    </#if>
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
