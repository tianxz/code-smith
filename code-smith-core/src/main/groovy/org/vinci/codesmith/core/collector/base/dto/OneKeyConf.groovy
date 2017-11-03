package org.vinci.codesmith.core.collector.base.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import org.vinci.codesmith.core.serializer.EngineTypeDeserializer
import org.vinci.codesmith.core.serializer.FileTypeDeserializer
import org.vinci.commons.core.serializer.jackson.NameValue

/**
 * Created by XizeTian on 2017/10/24.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class OneKeyConf {
    String              dirPath
    String              packageName
    String              tableName
    NameValue           primaryKey
    boolean             isCove
    @JsonDeserialize(using = FileTypeDeserializer.class)
    FileType            fileType
    @JsonDeserialize(using = EngineTypeDeserializer.class)
    EngineType          engineType
    List<GenDto>        genDtoList
    Map<String, String> aliasNameMap
}