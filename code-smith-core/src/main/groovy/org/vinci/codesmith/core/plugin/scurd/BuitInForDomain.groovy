package org.vinci.codesmith.core.plugin.scurd

import org.vinci.codesmith.core.code.BuitIn
import org.vinci.codesmith.core.collector.base.dto.GenDto

/**
 * Created by XizeTian on 2017/10/27.
 */
class BuitInForDomain extends BuitIn {
    private final String DIR_NAME = 'domain'

    @Override
    Map buildContext(GenDto genDto) {
        return null
    }

    @Override
    String buildDirName() {
        return DIR_NAME
    }

    @Override
    String buildTemplateName() {
        return DIR_NAME
    }
}
