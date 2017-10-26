<#include 'banner.ftl'>

package ${packageInfo.fullName};

import com.icss.ccp.ios.bridge.domain.*;
import com.icss.ccp.ios.core.mybatis.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ${classInfo.name}Dao {
    long queryTotal(@Param("sqlQueries") List<SqlQuery> sqlQueries);

    List<${classInfo.name}> queryAll(@Param("limit") Limit limit);

    List<${classInfo.name}> query(@Param("sqlQueries") List<SqlQuery> sqlQueries, @Param("limit") Limit limit);

    ${classInfo.name} querySingle(@Param("sqlQueries") List<SqlQuery> sqlQueries);

    ${classInfo.name} queryById(long uuid);

    int insert${classInfo.name}(${classInfo.name} ${classInfo.name?cap_first});

    int update${classInfo.name}(@Param("uuid") long uuid, @Param("sqlUpdates") List<SqlUpdate> sqlUpdates);

    int delete${classInfo.name}(long uuid);
}
