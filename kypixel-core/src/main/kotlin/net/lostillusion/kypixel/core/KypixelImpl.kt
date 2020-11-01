package net.lostillusion.kypixel.core

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import net.lostillusion.kypixel.api.Kypixel
import net.lostillusion.kypixel.api.entities.*
import net.lostillusion.kypixel.core.endpoints.EndpointRequest
import net.lostillusion.kypixel.core.endpoints.HypixelEndpoint
import net.lostillusion.kypixel.core.entities.MojangProfile
import net.lostillusion.kypixel.core.ratelimiter.Ratelimit
import net.lostillusion.kypixel.core.ratelimiter.Ratelimiter
import okhttp3.*
import java.io.IOException
import java.util.*
import java.util.concurrent.*
import java.util.regex.Pattern

class KypixelImpl(val token: UUID): Kypixel {
    class ThreadPool {
        val scheduledExecutor = Executors.newSingleThreadScheduledExecutor()!!
        val executor = Executors.newSingleThreadExecutor()!!
    }

    private val threadPool = ThreadPool()

    val ratelimiter = Ratelimiter(threadPool, Ratelimit(120, 60))

    private val client = OkHttpClient()

    private val mapper = jacksonObjectMapper()

    override fun watchdogStats(): CompletableFuture<out WatchdogStats> = EndpointRequest(
        HypixelEndpoint.WatchdogStatsEndpoint,
        this
    ).execute()

    override fun status(uuid: UUID): CompletableFuture<out Session> = EndpointRequest(
        HypixelEndpoint.StatusEndpoint,
        this
    ).param("uuid", uuid.toString()).execute().thenApply { it.session }

    override fun recentGames(uuid: UUID): CompletableFuture<out RecentGames> = EndpointRequest(
        HypixelEndpoint.RecentGamesEndpoint,
        this
    ).param("uuid", uuid.toString()).execute()

    override fun player(uuid: UUID): CompletableFuture<out Player> = EndpointRequest(
        HypixelEndpoint.PlayerEndpoint,
        this
    ).param("uuid", uuid.toString()).execute().thenApply { it.player }

    override fun playerCount(): CompletableFuture<out PlayerCount> = EndpointRequest(
        HypixelEndpoint.PlayerCountEndpoint,
        this
    ).execute()

    override fun boosters(): CompletableFuture<out Boosters> = EndpointRequest(
        HypixelEndpoint.BoostersEndpoint,
        this
    ).execute()

    override fun findGuild(name: String): CompletableFuture<out FindGuild> = EndpointRequest(
        HypixelEndpoint.FindGuildEndpoint,
        this
    ).param("byName", name).execute()

    override fun findGuild(uuid: UUID): CompletableFuture<out FindGuild> = EndpointRequest(
        HypixelEndpoint.FindGuildEndpoint,
        this
    ).param("byUuid", uuid.toString()).execute()

    override fun friends(uuid: UUID): CompletableFuture<out Friends> = EndpointRequest(
        HypixelEndpoint.FriendsEndpoint,
        this
    ).param("uuid", uuid.toString()).execute()

    override fun gameCounts(): CompletableFuture<out GameCounts> = EndpointRequest(
        HypixelEndpoint.GameCountsEndpoint,
        this
    ).execute()

    override fun guildById(id: String): CompletableFuture<out Guild> = EndpointRequest(
        HypixelEndpoint.GuildEndpoint,
        this
    ).param("id", id).execute().thenApply { it.guild }

    override fun guildByPlayer(playerUuid: UUID): CompletableFuture<out Guild> = EndpointRequest(
        HypixelEndpoint.GuildEndpoint,
        this
    ).param("player", playerUuid.toString()).execute().thenApply { it.guild }

    override fun guildByName(guildName: String): CompletableFuture<out Guild> = EndpointRequest(
        HypixelEndpoint.GuildEndpoint,
        this
    ).param("name", guildName).execute().thenApply { it.guild }

    private val uuidPattern = Pattern.compile("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})")

    override fun uuidByName(username: String): CompletableFuture<UUID> {
        val future = CompletableFuture<UUID>()
        client.newCall(Request.Builder().url("https://api.mojang.com/users/profiles/minecraft/$username").build()).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                future.complete(UUID.fromString(
                    uuidPattern.matcher(mapper.readValue<MojangProfile>(response.body!!.string()).id).replaceAll("$1-$2-$3-$4-$5")
                ))
            }
        })
        return future
    }

    override fun disconnect() {
        threadPool.scheduledExecutor.shutdownNow()
        threadPool.executor.shutdownNow()
    }
}