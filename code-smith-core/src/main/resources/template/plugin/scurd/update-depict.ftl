<#include 'banner.ftl'>

package ${packageInfo.fullName};

<#list imports as import>
import ${import};
</#list>

/**
 * <#if classInfo.comment??>${classInfo.comment} 更新配置</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name}UpdateDepict extends CurdAbstractDepictMap<UpdateDepict> {

    public ${classInfo.name}UpdateDepict() {
<#list classInfo.fields as field>
        this.put(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, new UpdateDepict(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, ${classInfo.name}Meta.${field.sqlName}_COLUMN_NAME, this));
</#list>
    }

<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * 获取更新 [${field.describe}] 的 UpdateDepict
     */
    </#if>
    public UpdateDepict getUpdateDepictFor${field.name?cap_first}() {
        return this.get(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME);
    }

</#list>
}
