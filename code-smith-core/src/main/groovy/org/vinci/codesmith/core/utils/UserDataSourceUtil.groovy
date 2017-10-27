package org.vinci.codesmith.core.utils

import org.vinci.codesmith.core.collector.database.domain.DataBaseConf
import org.vinci.codesmith.core.exception.VinciException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.servlet.http.HttpSession
import javax.sql.DataSource

/**
 * Created by XizeTian on 2016/12/30.
 */
@Component
class UserDataSourceUtil {
    final String dataBaseConfKey = "DB:CONF"
    final String dataSourceKey   = "DB:SOURCE"

    @Autowired
    HttpSession httpSession

    /**
     * 获取当前用户已经配置的数据库名称
     * @return
     */
    String getDefaultDbName() {
        return dataBaseConf.name
    }

    /**
     * 获取当前用户SessionID
     * @return
     */
    String getSessionId() {
        return httpSession.getId().toUpperCase()
    }

    /**
     * 保存当前用户的数据源配置
     * @param dataBaseConf
     */
    void setDataBaseConf(DataBaseConf dataBaseConf) {
        httpSession.setAttribute(dataBaseConfKey, dataBaseConf)
    }

    /**
     * 保存当前用户的DataSource
     * @param dataSource
     */
    void setDataSource(DataSource dataSource) {
        httpSession.setAttribute(dataSourceKey, dataSource)
    }

    /**
     * 获取当前用户数据源配置
     * @return
     */
    DataBaseConf getDataBaseConf() {
        def conf = httpSession.getAttribute(dataBaseConfKey)
        if (conf == null) {
            throw new VinciException("尚未初始化数据库")
        }
        return conf
    }

    /**
     * 获取当前用户DataSource
     * @return
     */
    DataSource getDataSource() {
        def dbs = httpSession.getAttribute(dataSourceKey)
        if (dbs == null) {
            throw new VinciException("尚未初始化数据库")
        }
        return dbs
    }

    /**
     * 生成新的DataSource
     * @param dataBase
     * @return
     */
    DataSource buildDataSource(DataBaseConf dataBase) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource()
        dataSource.driverClassName = dataBase.type.getUrl(dataBase.ipAddress, dataBase.port).driver
        dataSource.url = dataBase.type.getUrl(dataBase.ipAddress, dataBase.port).value
        dataSource.username = dataBase.loginName
        dataSource.password = dataBase.loginPassword
        dataSource.maxActive = 8
        dataSource.initialSize = 1
        dataSource.maxWait = 60000
        dataSource.minIdle = 10
        dataSource.timeBetweenEvictionRunsMillis = 60000
        dataSource.minEvictableIdleTimeMillis = 300000
        dataSource.validationQuery = "SELECT 1"
        dataSource.testWhileIdle = true
        dataSource.testOnBorrow = false
        dataSource.testOnReturn = false
        return dataSource
    }
}
