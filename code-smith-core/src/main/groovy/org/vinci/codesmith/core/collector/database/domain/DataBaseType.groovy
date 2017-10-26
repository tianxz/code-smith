package org.vinci.codesmith.core.collector.database.domain

/**
 * Created by XizeTian on 2016/12/30.
 */
enum DataBaseType {
    MYSQL('MYSQL'),
    SQL_SERVER('SQL_SERVER')

    String name

    DataBaseType(String name) {
        this.name = name
    }

    def getUrl(ip, port) {
        def result = [value: '', driver: '']
        switch (name.toUpperCase()) {
            case "MYSQL":
                result.value = "jdbc:mysql://${ip}:${port}/information_schema?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Hongkong&useSSL=false"
                result.driver = 'com.mysql.jdbc.Driver'
                break
            case "SQL_SERVER":
                result.value = "jdbc:sqlserver://${ip}:${port}; DatabaseName=information_schema"
                result.driver = 'com.microsoft.sqlserver.jdbc.SQLServerDriver'
                break
        }
        return result
    }
}
