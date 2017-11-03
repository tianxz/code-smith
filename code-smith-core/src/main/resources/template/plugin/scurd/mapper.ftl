<?xml version="1.0" encoding="UTF-8" ?>
<#include 'banner-mapper.ftl'>

<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${ext.daoPackage}.${classInfo.name}Dao">

    <sql id="columnNames">
        <#list 0..classInfo.fields?size-1 as i>`${classInfo.fields[i].sqlName}`<#if i < classInfo.fields?size-1>, </#if></#list>
    </sql>

    <sql id="limit">
        <if test="limit != null">
            LIMIT ${'#'}${'{'}${'limit.size'}${'}'} OFFSET ${'#'}${'{'}${'limit.offset'}${'}'}
        </if>
    </sql>

    <sql id="total">
        COUNT(*)
    </sql>

    <sql id="where">
        <where>
            <foreach collection="queryDepicts" item="sqlQuery">
                <if test="sqlQuery.isInclude">
                    <if test="sqlQuery.operator.toString() == 'EQ'">
                        AND ${'$'}${'{'}${'sqlQuery.columnName'}${'}'} = ${'#'}${'{'}${'sqlQuery.value'}${'}'}
                    </if>
                    <if test="sqlQuery.operator.toString() == 'NEQ'">
                        AND ${'$'}${'{'}${'sqlQuery.columnName'}${'}'} &lt;&gt; ${'#'}${'{'}${'sqlQuery.value'}${'}'}
                    </if>
                    <if test="sqlQuery.operator.toString() == 'IN'">
                        AND ${'$'}${'{'}${'sqlQuery.columnName'}${'}'} IN
                        <foreach collection="sqlQuery.multiValue" item="value" open="(" close=")" separator=",">
                        ${'#'}${'{'}${'value'}${'}'}
                        </foreach>
                    </if>
                    <if test="sqlQuery.operator.toString() == 'LIKE'">
                        <bind name="_param1" value="'%' + sqlQuery.value + '%'"/>
                        AND ${'$'}${'{'}${'sqlQuery.columnName'}${'}'} LIKE ${'#'}${'{'}${'_param1'}${'}'}
                    </if>
                    <if test="sqlQuery.operator.toString() == 'AND'">
                        AND (${'$'}${'{'}${'sqlQuery.columnName'}${'}'} &amp; ${'#'}${'{'}${'sqlQuery.value'}${'}'} = ${'#'}${'{'}${'sqlQuery.value'}${'}'})
                    </if>
                    <if test="sqlQuery.operator.toString() == 'BETWEEN'">
                        <!--X >= value and X <= value-->
                        <foreach collection="sqlQuery.multiValue" item="value" index="index">
                            <if test="index == 0">
                                AND ${'$'}${'{'}${'sqlQuery.columnName'}${'}'} &gt;= ${'#'}${'{'}${'value'}${'}'}
                            </if>
                            <if test="index == 1">
                                AND ${'$'}${'{'}${'sqlQuery.columnName'}${'}'} &lt;= ${'#'}${'{'}${'value'}${'}'}
                            </if>
                        </foreach>
                    </if>
                </if>
            </foreach>
        </where>
    </sql>

    <#if classInfo.comment??><!-- 查询${classInfo.comment}总行数 --></#if>
    <select id="queryTotal" resultType="long">
        SELECT
        <include refid="total"/>
        FROM `${classInfo.sqlName}`
        <include refid="where"/>
    </select>

    <#if classInfo.comment??><!-- 根据 id 查询 ${classInfo.comment} --></#if>
    <select id="queryById" parameterType="${ext.primaryKey.value()}" resultType="${ext.domainPackage}.${classInfo.name}">
        SELECT <include refid="columnNames"/>
        FROM `${classInfo.sqlName}`
        <where>
            ${ext.primaryKey.name()} = ${'#'}${'{'}${ext.primaryKey.name()}${'}'}
        </where>
    </select>

    <#if classInfo.comment??><!-- 使用分页查询所有 ${classInfo.comment} --></#if>
    <select id="queryAll" resultType="${ext.domainPackage}.${classInfo.name}">
        SELECT <include refid="columnNames"/>
        FROM `${classInfo.sqlName}`
        <include refid="limit"/>
    </select>

    <#if classInfo.comment??><!-- 动态查询 ${classInfo.comment} --></#if>
    <select id="query" resultType="${ext.domainPackage}.${classInfo.name}">
        SELECT
        <include refid="columnNames"/>
        FROM `${classInfo.sqlName}`
        <include refid="where"/>
        <include refid="limit"/>
    </select>

	<#if classInfo.comment??><!-- 动态查询单个 ${classInfo.comment} --></#if>
    <select id="querySingle" resultType="${ext.domainPackage}.${classInfo.name}">
        SELECT
        <include refid="columnNames"/>
        FROM `${classInfo.sqlName}`
        <include refid="where"/>
    </select>

    <#if classInfo.comment??><!-- 新增 ${classInfo.comment} --></#if>
    <insert id="insert${classInfo.name}" parameterType="${ext.domainPackage}.${classInfo.name}">
        INSERT INTO `${classInfo.sqlName}`(<include refid="columnNames"/>)
        VALUES(<#list 0..classInfo.fields?size-1 as i>${'#'}${'{'}${classInfo.fields[i].name}${'}'}<#if i < classInfo.fields?size-1>, </#if></#list>)
    </insert>

    <#if classInfo.comment??><!-- 根据 id 修改 ${classInfo.comment} --></#if>
    <update id="update${classInfo.name}">
        UPDATE `${classInfo.sqlName}`
        SET
        <foreach collection="updateDepicts" separator="," item="item">
            <bind name="_param1" value="item.columnName" />
            <if test="item.isInclude">
                ${'$'}${'{'}${'_param1'}${'}'} = ${'#'}${'{'}${'item.value'}${'}'}
            </if>
        </foreach>
        <where>
            ${ext.primaryKey.name()} = ${'#'}${'{'}${ext.primaryKey.name()}${'}'}
        </where>
    </update>

    <#if classInfo.comment??><!-- 根据 id 删除 ${classInfo.comment} --></#if>
    <delete id="delete${classInfo.name}" parameterType="${ext.primaryKey.value()}">
        DELETE FROM `${classInfo.sqlName}`
        <where>
            ${ext.primaryKey.name()} = ${'#'}${'{'}${ext.primaryKey.name()}${'}'}
        </where>
    </delete>
</mapper>