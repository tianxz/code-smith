package org.vinci.codesmith.core.serializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.vinci.codesmith.core.collector.base.dto.EngineType
import org.vinci.codesmith.core.collector.base.dto.FileType

/**
 * Created by XizeTian on 2017/10/27.
 */
class EngineTypeDeserializer extends JsonDeserializer<EngineType> {
    @Override
    EngineType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        for (EngineType engineType : EngineType.values()) {
            if (engineType.getValue() == p.getValueAsString()) {
                return engineType
            }
        }
    }
}