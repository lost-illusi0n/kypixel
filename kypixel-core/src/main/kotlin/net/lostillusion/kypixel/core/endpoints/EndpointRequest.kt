package net.lostillusion.kypixel.core.endpoints

import com.fasterxml.jackson.databind.InjectableValues
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.lostillusion.kypixel.api.entities.GameType
import net.lostillusion.kypixel.api.entities.Item
import net.lostillusion.kypixel.core.deserializers.HypixelDtoDeserializer
import net.lostillusion.kypixel.core.KypixelImpl
import net.lostillusion.kypixel.core.deserializers.GameTypeDeserializer
import net.lostillusion.kypixel.core.deserializers.ItemDeserializer
import net.lostillusion.kypixel.core.deserializers.MinecraftColorDeserializer
import net.lostillusion.kypixel.core.deserializers.TimestampDeserializer
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.awt.Color
import java.util.Date
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

class EndpointRequest<T>(private val endpoint: HypixelEndpoint<T>, private val kypixel: KypixelImpl) {
    companion object {
        private val mapper = jacksonObjectMapper()
            .registerModule(SimpleModule().addDeserializer(
                HypixelDto::class.java,
                HypixelDtoDeserializer
            ).addDeserializer(
                GameType::class.java,
                GameTypeDeserializer
            ).addDeserializer(
                Color::class.java,
                MinecraftColorDeserializer
            ).addDeserializer(
                Date::class.java,
                TimestampDeserializer
            ).addDeserializer(
                Item::class.java,
                ItemDeserializer
            ))
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
        private val client = OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS).build()
    }

    var result = CompletableFuture<Response>()

    private val params: MutableMap<String, String> = mutableMapOf()

    init {
        params["key"] = kypixel.token.toString()
    }

    fun param(key: String, value: String) = apply {
        params[key] = value
    }

    fun call(): Response {
        return client.newCall(
            Request.Builder().url("${endpoint.url}?${params.toList().map { "${it.first}=${it.second}" }.reduce { acc, s -> "$acc&$s" }}")
                .build()
        ).execute()
    }

    @Suppress("UNCHECKED_CAST")
    fun execute(): CompletableFuture<T> {
        kypixel.ratelimiter.queueRequest(this)
        return result.thenApply {
            val response = it.body!!.string()
            mapper.injectableValues = InjectableValues.Std().addValue("expected", endpoint.expected)
            mapper.readValue(response, HypixelDto::class.java).entity as T
        }
    }
}

class HypixelDto {
    var entity: Any by Delegates.notNull()
}