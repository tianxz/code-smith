package com.icss.codesmith.template.info

import com.icss.codesmith.template.util.WordUtil

/**
 * Created by XizeTian on 2016/12/19.
 */
class InfoBase {
    String name;

    String getNameFirstUpper() {
        return WordUtil.inValue(name).firstToUp().outValue()
    }
}
