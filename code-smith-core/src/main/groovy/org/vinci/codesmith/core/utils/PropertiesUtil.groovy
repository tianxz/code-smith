package org.vinci.codesmith.core.utils

import org.springframework.stereotype.Component

/**
 * Created by XizeTian on 2016/12/30.
 */
@Component
class PropertiesUtil {
    private static PropertiesUtil propertiesUtil = new PropertiesUtil()

    static of() {
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
        InputStream path = null
        try {
            path = Thread.currentThread().getContextClassLoader().getResourceAsStream(name)
            prop.load(path)
        } finally {
            if (path) path.close()
        }
        return prop
    }
}
