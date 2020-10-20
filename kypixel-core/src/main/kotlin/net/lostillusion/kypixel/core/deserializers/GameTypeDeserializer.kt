package net.lostillusion.kypixel.core.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.lostillusion.kypixel.api.entities.GameType
import net.lostillusion.kypixel.core.exceptions.HypixelParsingException

object GameTypeDeserializer: StdDeserializer<GameType>(GameType::class.java) {
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): GameType {
        val value = parser.currentToken
        val type =
            if(value == JsonToken.VALUE_NUMBER_INT) GameType.values().find { it.id == parser.intValue }
            else if(value == JsonToken.VALUE_STRING) GameType.values().find { it.typeName == parser.text }
            else throw HypixelParsingException
        return type ?: throw HypixelParsingException
    }
}