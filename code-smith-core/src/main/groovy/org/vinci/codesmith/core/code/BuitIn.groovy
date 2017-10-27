package org.vinci.codesmith.core.code

import freemarker.core.BuiltIn
import org.vinci.codesmith.core.collector.database.domain.OneKeyConf

/**
 * Created by XizeTian on 2017/10/25.
 */
abstract class BuitIn {
    private static final int     NUMBER_OF_BIS = 252
    private static final HashMap builtins      = new HashMap(NUMBER_OF_BIS * 3 / 2 + 1, 0.67f)

    static {

    }

    static void putBI(String name, BuiltIn bi) {
        builtins.put(name, bi)
    }

    void start() {

    }

    abstract Map buildContext(OneKeyConf oneKeyConf)

    abstract String getTemplateName()
}