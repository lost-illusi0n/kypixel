package net.lostillusion.kypixel.api

import net.lostillusion.kypixel.api.entities.*
import java.util.*
import java.util.concurrent.CompletableFuture

/**
 * This interface contains all the methods to interact with Hypixel's API.
 */
interface Kypixel {
    /**
     * This interface contains all the methods to interact with Hypixel's API.
     */
    companion object {
        /**
         * Creates a Kypixel client with the [token].
         *
         * @param token your Hypixel key.
         * @return the [Kypixel] client.
         */
        @JvmStatic
        fun fromToken(token: UUID): Kypixel = ServiceLoader.load(KypixelProvider::class.java)
            .findFirst()
            .orElseThrow { IllegalStateException("Couldn't find implementation of KypixelProvider!") }
            .create(token)
    }

    /**
     * Sends a request to the WatchdogStats endpoint and returns the response.
     *
     * @return the response.
     */
    fun watchdogStats(): CompletableFuture<out WatchdogStats>

    /**
     * Sends a request to the Status endpoint.
     *
     * @param uuid the UUID of the player.
     * @return the response.
     */
    fun status(uuid: UUID): CompletableFuture<out Session>

    /**
     * Sends a request to the RecentGames endpoint.
     *
     * @param uuid the UUID of the player.
     * @return the response.
     */
    fun recentGames(uuid: UUID): CompletableFuture<out RecentGames>

    /**
     * Sends a request to the Player endpoint.
     *
     * @param uuid the UUID of the player.
     * @return the response.
     */
    fun player(uuid: UUID): CompletableFuture<out Player>

    /**
     * Sends a request to the PlayerCount endpoint.
     *
     * @return the response.
     */
    fun playerCount(): CompletableFuture<out PlayerCount>


    /**
     * Sends a request to the Boosters endpoint.
     *
     * @return the response.
     */
    fun boosters(): CompletableFuture<out Boosters>

    /**
     * Sends a request to the FindGuild endpoint.
     *
     * @param name the name of the guild.
     * @return the response.
     */
    fun findGuild(name: String): CompletableFuture<out FindGuild>

    /**
     * Sends a request to the FindGuild endpoint.
     *
     * @param uuid the uuid of the player.
     * @return the response.
     */
    fun findGuild(uuid: UUID): CompletableFuture<out FindGuild>

    /**
     * Sends a request to the Friends endpoint.
     *
     * @param uuid the uuid of the player.
     * @return the response.
     */
    fun friends(uuid: UUID): CompletableFuture<out Friends>

    /**
     * Sends a request to the GameCounts endpoint.
     *
     * @return the response.
     */
    fun gameCounts(): CompletableFuture<out GameCounts>

    /**
     * Sends a request to the Guild endpoint.
     *
     * @param id the Hypixel id of the guild.
     * @return the response.
     */
    fun guildById(id: String): CompletableFuture<out Guild>

    /**
     * Sends a request to the Guild endpoint.
     *
     * @param playerUuid the uuid of the player.
     * @return the response.
     */
    fun guildByPlayer(playerUuid: UUID): CompletableFuture<out Guild>

    /**
     * Sends a request to the Guild endpoint.
     *
     * @param guildName the name of the guild.
     * @return the response.
     */
    fun guildByName(guildName: String): CompletableFuture<out Guild>

    /**
     * Sends a request to Mojang's api to retrieve a UUID by username.
     *
     * @param username the username of the Minecraft account you want to get the UUID of.
     * @return the UUID.
     */
    fun uuidByName(username: String): CompletableFuture<UUID>

    /**
     * Disconnect and shut down all threads related to Kypixel.
     */
    fun disconnect()
}