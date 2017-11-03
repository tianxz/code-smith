<#include 'banner.ftl'>

package ${packageInfo.fullName};

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
<#list imports as import>
import ${import};
</#list>

import java.util.List;

@Mapper
public interface ${classInfo.name}Dao {
    long queryTotal(@Param("queryDepicts") List<QueryDepict> queryDepicts);

    List<${classInfo.name}> queryAll(@Param("limit") Limit limit);

    List<${classInfo.name}> query(@Param("queryDepicts") List<QueryDepict> queryDepicts, @Param("limit") Limit limit);

    ${classInfo.name} querySingle(@Param("queryDepicts") List<QueryDepict> queryDepicts);

    ${classInfo.name} queryById(${ext.primaryKey.value()} ${ext.primaryKey.name()});

    int insert${classInfo.name}(${classInfo.name} ${classInfo.name?cap_first});

    int update${classInfo.name}(@Param("${ext.primaryKey.name()}") ${ext.primaryKey.value()} ${ext.primaryKey.name()}, @Param("updateDepicts") List<UpdateDepict> updateDepicts);

    int delete${classInfo.name}(${ext.primaryKey.value()} ${ext.primaryKey.name()});
}