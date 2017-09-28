<#include 'banner.ftl'>

package ${generateParams.packageInfo};

<#list imports as import>
import ${import};
</#list>

/**
 * <#if classInfo.comment??>${classInfo.comment}</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name} {
<#list classInfo.fields as field>
    <#if field.describe??>//${field.describe}</#if>
    <#if field.javaType == 'JDateTime'>
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    </#if>
    private ${field.javaType} ${field.name};

</#list>
<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * 获取 ${field.describe}
     */
    </#if>
    public ${field.javaType} get${field.name?cap_first}() {
        return ${field.name};
    }

    <#if field.describe??>
    /**
     * 设置 ${field.describe}
     */
    </#if>
    public void set${field.name?cap_first}(${field.javaType} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#list>
}