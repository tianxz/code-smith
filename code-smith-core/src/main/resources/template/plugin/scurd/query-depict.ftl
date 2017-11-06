<#include 'banner.ftl'>

package ${packageInfo.fullName};

<#list imports as import>
import ${import};
</#list>

/**
 * <#if classInfo.comment??>${classInfo.comment} 查询配置</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name}QueryDepict extends CurdAbstractDepictMap<QueryDepict> {

    public ${classInfo.name}QueryDepict() {
<#list classInfo.fields as field>
        this.put(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, new QueryDepict(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, ${classInfo.name}Meta.${field.sqlName}_COLUMN_NAME, this));
</#list>
    }

<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * 获取查询 [${field.describe}] 的 QueryDepict
     */
    </#if>
    public QueryDepict getQueryDepictFor${field.name?cap_first}() {
        return this.get(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME);
    }

</#list>
}