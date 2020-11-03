package net.lostillusion.kypixel.core.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.lostillusion.kypixel.api.entities.Item
import net.lostillusion.kypixel.core.entities.ItemImpl

object ItemDeserializer: StdDeserializer<Item>(Item::class.java) {
    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): Item {
        var type: Int? = null
        var data = ""
        var isObject = false
        while (!parser.isClosed) {
            val token = parser.currentToken
            if(token == JsonToken.START_OBJECT) {
                isObject = true
                parser.nextToken()
                continue
            }
            if (token == JsonToken.VALUE_STRING && !isObject) {
                data = parser.valueAsString
                break
            }
            if(token == JsonToken.FIELD_NAME && isObject) {
                val name = parser.currentName
                parser.nextToken()
                if(name == "type") {
                    type = parser.valueAsInt
                    parser.nextToken()
                    continue
                } else if(name == "data") {
                    data = parser.valueAsString
                    parser.nextToken()
                    continue
                }
            }
            if(token == JsonToken.END_OBJECT) break
        }
        return ItemImpl(type, data)
    }
}