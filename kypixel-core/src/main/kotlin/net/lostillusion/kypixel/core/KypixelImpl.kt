package net.lostillusion.kypixel.core

import net.lostillusion.kypixel.api.Kypixel
import net.lostillusion.kypixel.api.entities.*
import net.lostillusion.kypixel.core.endpoints.EndpointRequest
import net.lostillusion.kypixel.core.endpoints.HypixelEndpoint
import net.lostillusion.kypixel.core.ratelimiter.Ratelimit
import net.lostillusion.kypixel.core.ratelimiter.Ratelimiter
import java.util.*
import java.util.concurrent.*

class KypixelImpl(val token: UUID): Kypixel {
    class ThreadPool {
        val scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
        val executor = Executors.newSingleThreadExecutor()
    }

    val threadPool = ThreadPool()

    val ratelimiter = Ratelimiter(threadPool, Ratelimit(120, 60))

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

    override fun disconnect() {
        threadPool.scheduledExecutor.shutdownNow()
        threadPool.executor.shutdownNow()
    }
}