<#include 'banner.ftl'>

package ${packageInfo.fullName};

/**
 * <#if classInfo.comment??>${classInfo.comment} 元数据</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name}Meta {
<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * ${field.describe} 字段名
     */
    </#if>
    public static final String ${field.sqlName}_FIELD_NAME = "${field.name}";

</#list>

<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * ${field.describe} 列名
     */
    </#if>
    public static final String ${field.sqlName}_COLUMN_NAME = "${field.sqlName}";

</#list>
}