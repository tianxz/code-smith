package org.vinci.codesmith.core.collector.base.dto

/**
 * Created by XizeTian on 2017/10/27.
 */
enum EngineType {
    FREEMARKER('f'), VELOCITY('v')

    private String engineType

    private EngineType(String engineType) {
        this.engineType = engineType
    }

    def getValue() {
        return this.engineType
    }
}