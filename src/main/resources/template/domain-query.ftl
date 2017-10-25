<#include 'banner.ftl'>

package ${packageInfo.fullName};

/**
 * <#if classInfo.comment??>${classInfo.comment} 查询配置</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name}QueryMap extends HashMap<String, SqlQuery> {

    public ${classInfo.name}QueryMap() {
<#list classInfo.fields as field>
        this.put(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, new SqlQuery("${field.sqlName}", "${field.name}"));
</#list>
    }

	/**
     * 转换 SqlQuery map 为 list
     */
    public List<SqlQuery> toList() {
        List<SqlQuery> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }

    /**
     * 重置所有 SqlQuery
     */
    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
    }

<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * 获取查询 [${field.describe}] 的 SqlQuery
     */
    </#if>
    public SqlQuery getSqlQueryFor${field.name?cap_first}() {
        return this.get(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME);
    }

</#list>
}
