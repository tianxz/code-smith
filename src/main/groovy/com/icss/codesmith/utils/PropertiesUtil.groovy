package com.icss.codesmith.utils

import org.springframework.stereotype.Component

/**
 * Created by XizeTian on 2016/12/30.
 */
@Component
class PropertiesUtil {
    private static PropertiesUtil propertiesUtil = new PropertiesUtil()

    static me() {
        return propertiesUtil
    }

    Properties getMysqlDataProp() {
        return getPropByName('mysqldata.properties')
    }

    Properties getPackageProp() {
        return getPropByName('package.properties')
    }

    protected Properties getPropByName(String name) {
        Properties prop = new Properties()
        InputStream path = Thread.currentThread().getContextClassLoader().getResourceAsStream(name)
        prop.load(path)
        return prop
    }
}
