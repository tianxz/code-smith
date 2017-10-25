<#include 'banner.ftl'>

package ${packageInfo.fullName};

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <#if classInfo.comment??>${classInfo.comment} 更新配置</#if>
 * Created by ${authorInfo.name} on ${dateInfo.now}.
 */
public class ${classInfo.name}UpdateMap extends HashMap<String, SqlUpdate> {

    public ${classInfo.name}UpdateMap() {
<#list classInfo.fields as field>
        this.put(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME, new SqlUpdate("${field.name}", "${field.sqlName}"));
</#list>
    }

	/**
     * 转换 SqlUpdate map 为 list
     */
    public List<SqlUpdate> toList() {
        List<SqlUpdate> lst = new ArrayList<>();
        for (String key : this.keySet()) {
            lst.add(this.get(key));
        }
        return lst;
    }
	
    /**
     * 重置所有 SqlUpdate
     */
    public void resetAll() {
        for (String key : this.keySet()) {
            this.get(key).reset();
        }
    }

<#list classInfo.fields as field>
    <#if field.describe??>
    /**
     * 获取更新 [${field.describe}] 的 SqlUpdate
     */
    </#if>
    public SqlUpdate getSqlUpdateFor${field.name?cap_first}() {
        return this.get(${classInfo.name}Meta.${field.sqlName}_FIELD_NAME);
    }

</#list>
}
