package net.lostillusion.kypixel.core.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.util.Date

object SkyblockTimestampDeserializer: StdDeserializer<Date>(Date::class.java) {
    private const val SKYBLOCK_EPOCH = 1573058700L

    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): Date = Date(parser.valueAsLong + SKYBLOCK_EPOCH)
}