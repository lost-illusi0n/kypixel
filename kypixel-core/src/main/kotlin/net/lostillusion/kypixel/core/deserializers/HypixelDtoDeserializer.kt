package net.lostillusion.kypixel.core.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import net.lostillusion.kypixel.core.exceptions.HypixelParsingException
import net.lostillusion.kypixel.core.exceptions.HypixelException
import net.lostillusion.kypixel.core.endpoints.HypixelDto
import kotlin.jvm.Throws
import kotlin.properties.Delegates

object HypixelDtoDeserializer: JsonDeserializer<HypixelDto>() {
    @Throws(HypixelException::class, HypixelParsingException::class)
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): HypixelDto {
        val expected = ctxt.findInjectableValue("expected", null, null)
        var entity: Any by Delegates.notNull()
        while(!parser.isClosed) {
            val token = parser.nextToken()
            if(token == JsonToken.FIELD_NAME) {
                val name = parser.currentName
                parser.nextToken()
                if(name == "success" && parser.valueAsBoolean) {
                    parser.nextToken()
                    entity = ctxt.readValue(parser, expected as Class<*>)
                    break
                }
                else if(name == "success" && !parser.valueAsBoolean) continue
                else if(name == "cause") throw HypixelException(parser.valueAsString)
                else throw HypixelException("Unknown response received from Hypixel API!")
            } else throw HypixelParsingException
        }
        val response = HypixelDto()
        response.entity = entity
        return response
    }
}
