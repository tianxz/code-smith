<#include 'banner.ftl'>

package ${packageInfo.fullName};

<#list imports as import>
import ${import};
</#list>

/**
<#if classInfo.comment??> * ${classInfo.comment}</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name} {
<#list classInfo.fields as field>
    <#if field.describe??>//${field.describe}</#if>
    <#if field.javaType == 'JDateTime'>
    @JsonDeserialize(using = JDateTimeDeserializer.class)
    @JsonSerialize(using = JDateTimeSerializer.class)
    </#if>
    <#if field.javaType == 'long'>
    @JsonSerialize(using = ToStringSerializer.class)
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
    public ${classInfo.name} set${field.name?cap_first}(${field.javaType} ${field.name}) {
        this.${field.name} = ${field.name};
        return this;
    }

</#list>
}