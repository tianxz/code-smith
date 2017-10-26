package org.vinci.codesmith.core.utils

/**
 * Created by XizeTian on 2017/10/25.
 */
class TemplateEngineContextUtil {
    Map getContextMap() {
        def contextMap = [
                "generateParams": generateParams,
                "packageInfo"   : packageInfo,
                "classInfo"     : classInfo,
                "authorInfo"    : authorInfo,
                "dateInfo"      : dateInfo,
                "imports"       : imports,
                "WordUtil"      : WordUtil.class
        ]

        return contextMap
    }
}
