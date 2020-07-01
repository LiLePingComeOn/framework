<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${ftlParams.packageName}.Mapper.${ftlParams.tableClass.entityName}Mapper">

    <resultMap id="BaseResultMap" type="${ftlParams.packageName}.Entity.${ftlParams.tableClass.entityName}">
        <#if ftlParams.columnClassList?exists && ftlParams.columnClassList?size gt 0>
            <#list ftlParams.columnClassList as columnClass >
        <result column="${columnClass.columnName}" property="${columnClass.humpName}" />
            </#list>
        </#if>
    </resultMap>

    <sql id="select${ftlParams.tableClass.entityName}">
        select
        <#if ftlParams.columnClassList?exists && ftlParams.columnClassList?size gt 0>
            <#list ftlParams.columnClassList as columnClass >
        ${columnClass.columnName}<#if columnClass_has_next>,</#if>
            </#list>
        </#if>
        FROM ${ftlParams.tableClass.tableName}
    </sql>

    <!-- 数据新增 -->
    <insert id="insert${ftlParams.tableClass.entityName}" parameterType="${ftlParams.tableClass.entityName}">
        <#if ftlParams.primiaryColumn.humpName = "String">
        <selectKey keyProperty="${ftlParams.primiaryColumn.humpName}" resultType="String" order="BEFORE">
            select replace(uuid(), '-', '') as ${ftlParams.primiaryColumn.humpName} from dual
        </selectKey>
        </#if>
        insert into ${ftlParams.tableClass.tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list ftlParams.columnClassList as columnClass >
                <#if columnClass.javaType = "Date">
            <if test="${columnClass.humpName} != null">${columnClass.humpName},</if>
                    <#else>
            <if test="${columnClass.humpName} != null  and ${columnClass.humpName} != ''">${columnClass.columnName},</if>
                </#if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list ftlParams.columnClassList as columnClass >
                <#if columnClass.javaType = "Date">
            <if test="${columnClass.humpName} != null">#${'{'}${columnClass.humpName}${'}'},</if>
                <#else>
            <if test="${columnClass.humpName} != null  and ${columnClass.humpName} != ''">#${'{'}${columnClass.humpName}${'}'},</if>
                </#if>
            </#list>
        </trim>
    </insert>

    <!-- 数据删除 -->
    <delete id="delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}" parameterType="${ftlParams.primiaryColumn.javaType}">
        delete from ${ftlParams.tableClass.tableName} where ${ftlParams.primiaryColumn.columnName} = #${'{'}${ftlParams.primiaryColumn.humpName}${'}'}
    </delete>

    <!-- 根据多个id删除 -->
    <delete id="delete${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}s" parameterType="${ftlParams.primiaryColumn.javaType}">
        delete from ${ftlParams.tableClass.tableName} where ${ftlParams.primiaryColumn.columnName} in
        <foreach item="id" collection="array" open="(" separator="," close=")">
        #${'{'}id${'}'}
        </foreach>
    </delete>

    <!-- 数据更新 -->
    <update id="update${ftlParams.tableClass.entityName}" parameterType="${ftlParams.tableClass.entityName}">
        update ${ftlParams.tableClass.tableName}
        <trim prefix="SET" suffixOverrides=",">
            <#list ftlParams.columnClassList as columnClass >
                <#if columnClass.javaType = "Date">
            <if test="${columnClass.humpName} != null">${columnClass.columnName} = #${'{'}${columnClass.humpName}${'}'},</if>
                <#else>
            <if test="${columnClass.humpName} != null  and ${columnClass.humpName} != ''">${columnClass.columnName} = #${'{'}${columnClass.humpName}${'}'},</if>
                </#if>
            </#list>
        </trim>
        <where>
        ${ftlParams.primiaryColumn.columnName} = #${'{'}${ftlParams.primiaryColumn.humpName}${'}'}
        </where>
    </update>

    <!-- 数据查询 -->
    <select id="select${ftlParams.tableClass.entityName}List" resultMap="BaseResultMap" parameterType="${ftlParams.tableClass.entityName}">
        <include refid="select${ftlParams.tableClass.entityName}"></include>
        <where>
            1=1
            <#if ftlParams.columnClassList?exists && ftlParams.columnClassList?size gt 0>
                <#list ftlParams.columnClassList as columnClass >
                <#if columnClass.javaType = "Date">
            <if test="${columnClass.humpName} != null"> and ${columnClass.columnName} = #${'{'}${columnClass.humpName}${'}'}</if>
                <#else>
            <if test="${columnClass.humpName} != null  and ${columnClass.humpName} != ''"> and ${columnClass.columnName} = #${'{'}${columnClass.humpName}${'}'}</if>
                </#if>
                </#list>
            </#if>
        </where>
    </select>

    <!-- 根据id查询数据 -->
    <select id="select${ftlParams.tableClass.entityName}By${ftlParams.primiaryColumn.paramName}" parameterType="${ftlParams.primiaryColumn.javaType}">
        <include refid="select${ftlParams.tableClass.entityName}"></include>
        where ${ftlParams.primiaryColumn.columnName} = #${'{'}${ftlParams.primiaryColumn.humpName}${'}'}
        limit 0,1
    </select>

</mapper>