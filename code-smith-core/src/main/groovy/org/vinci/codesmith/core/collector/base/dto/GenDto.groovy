package org.vinci.codesmith.core.collector.base.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.vinci.codesmith.core.serializer.EngineTypeDeserializer
import org.vinci.codesmith.core.serializer.FileTypeDeserializer
import org.vinci.commons.core.serializer.jackson.NameValue

/**
 * Created by XizeTian on 2017/10/27.
 */
class GenDto {
    def        dataSource       //数据源Table, Json
    String     dirPath
    String     packageName
    NameValue  primaryKey
    String     codeType
    @JsonDeserialize(using = FileTypeDeserializer.class)
    FileType   fileType
    @JsonDeserialize(using = EngineTypeDeserializer.class)
    EngineType engineType
    OneKeyConf ownerConf
    Map        otherDto
}