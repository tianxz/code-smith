package org.vinci.codesmith.jdbc

import org.vinci.codesmith.utils.UserDataSourceUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.util.Assert

import javax.sql.DataSource

/**
 * 数据库路由数据源
 * Created by XizeTian on 2016/12/30.
 */
class VinciDataSource extends AbstractRoutingDataSource {
    private Map<Object, Object> dataSources = new HashMap<>()

    @Autowired
    UserDataSourceUtil userDataSourceUtil

    VinciDataSource() {
        targetDataSources = dataSources
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dbId = "USER:DB:${userDataSourceUtil.sessionId}"
        dataSources.put(dbId, userDataSourceUtil.getDataSource())
        return dbId
    }

    @Override
    protected DataSource determineTargetDataSource() {
        Assert.notNull(this.dataSources, "数据库没有初始化")
        Object lookupKey = determineCurrentLookupKey()
        DataSource dataSource = this.dataSources.get(lookupKey)
        if (dataSource == null) {
            throw new IllegalStateException("不能根据所给的 [${lookupKey}] Key确定数据库")
        }
        return dataSource
    }
}
