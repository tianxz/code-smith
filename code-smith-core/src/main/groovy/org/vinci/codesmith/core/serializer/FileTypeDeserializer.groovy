package org.vinci.codesmith.core.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.vinci.codesmith.core.collector.base.dto.FileType

/**
 * Created by XizeTian on 2017/10/27.
 */
class FileTypeDeserializer extends JsonDeserializer<FileType> {
    @Override
    FileType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        for (FileType fileType : FileType.values()) {
            if (fileType.getValue() == p.getValueAsString()) {
                return fileType
            }
        }
    }
}
