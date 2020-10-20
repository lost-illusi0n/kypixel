package net.lostillusion.kypixel.core.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.util.Date

object TimestampDeserializer: StdDeserializer<Date>(Date::class.java) {
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): Date = Date(parser.valueAsLong)
}