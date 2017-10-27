package org.vinci.codesmith.core.collector.base.dto
/**
 * Created by XizeTian on 2017/10/27.
 */
enum FileType {
    JAVA("java"), XML("xml"),

    def fileType

    private FileType(String fileType) {
        this.fileType = fileType
    }

    def getValue() {
        return this.fileType
    }
}