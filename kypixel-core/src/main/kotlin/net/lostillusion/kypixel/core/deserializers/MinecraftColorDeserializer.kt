package net.lostillusion.kypixel.core.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.awt.Color
import java.lang.RuntimeException

object MinecraftColorDeserializer: StdDeserializer<Color>(Color::class.java) {
    private val MINECRAFT_TO_KOTLIN_COLORS = mapOf(
        "DARK_RED" to Color(170, 0, 0),
        "RED" to Color(255, 85, 85),
        "GOLD" to Color(255, 255, 85),
        "DARK_GREEN" to Color(0, 170, 0),
        "GREEN" to Color(85, 255, 85),
        "AQUA" to Color(85, 255, 255),
        "DARK_AQUA" to Color(0, 170, 170),
        "DARK_BLUE" to Color(0, 0, 170),
        "BLUE" to Color(85, 85, 255),
        "LIGHT_PURPLE" to Color(255, 85, 255),
        "DARK_PURPLE" to Color(170, 0, 170),
        "WHITE" to Color(255, 255, 255),
        "GRAY" to Color(170, 170, 170),
        "DARK_GRAY" to Color(85, 85, 85),
        "BLACK" to Color(0, 0, 0)
    )

    override fun deserialize(parser: JsonParser, ctxt: DeserializationContext): Color =
        MINECRAFT_TO_KOTLIN_COLORS[parser.valueAsString] ?: throw RuntimeException("Tried to parse ${parser.valueAsString} into a color but no index was found!")
}