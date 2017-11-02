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

    ${classInfo.name} queryById(long uuid);

    int insert${classInfo.name}(${classInfo.name} ${classInfo.name?cap_first});

    int update${classInfo.name}(@Param("uuid") long uuid, @Param("updateDepicts") List<UpdateDepict> updateDepicts);

    int delete${classInfo.name}(long uuid);
}
