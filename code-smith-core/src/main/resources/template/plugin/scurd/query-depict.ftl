<#include 'banner.ftl'>

package ${packageInfo.fullName};

<#list imports as import>
import ${import};
</#list>

/**
 * <#if classInfo.comment??>${classInfo.comment} 查询配置</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name}QueryDepict extends HashMap<String, QueryDepict> {

    public ${classInfo.name}QueryDepict() {
<#list classInfo.fields as field>
        this.put(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, new QueryDepict("${field.sqlName}", "${field.name}"));
</#list>
    }

    /**
     * 转换 QueryDepict map 为 list
     */
    public List<QueryDepict> toList() {
        List<QueryDepict> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }

    /**
     * 重置所有 QueryDepict
     */
    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
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