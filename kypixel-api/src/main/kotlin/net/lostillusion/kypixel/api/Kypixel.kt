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
        fun fromToken(token: String): Kypixel = ServiceLoader.load(KypixelProvider::class.java)
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
    fun status(uuid: String): CompletableFuture<out Session>

    /**
     * Sends a request to the RecentGames endpoint.
     *
     * @param uuid the UUID of the player.
     * @return the response.
     */
    fun recentGames(uuid: String): CompletableFuture<out RecentGames>

    /**
     * Sends a request to the Player endpoint.
     *
     * @param uuid the UUID of the player.
     * @return the response.
     */
    fun player(uuid: String): CompletableFuture<out Player>

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
    fun findGuildByName(name: String): CompletableFuture<out FindGuild>

    /**
     * Sends a request to the FindGuild endpoint.
     *
     * @param uuid the uuid of the player.
     * @return the response.
     */
    fun findGuildByUuid(uuid: String): CompletableFuture<out FindGuild>

    /**
     * Sends a request to the Friends endpoint.
     *
     * @param uuid the uuid of the player.
     * @return the response.
     */
    fun friends(uuid: String): CompletableFuture<out Friends>

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
    fun guildByPlayer(playerUuid: String): CompletableFuture<out Guild>

    /**
     * Sends a request to the Guild endpoint.
     *
     * @param guildName the name of the guild.
     * @return the response.
     */
    fun guildByName(guildName: String): CompletableFuture<out Guild>

    /**
     * Sends a request to the Skyblock Profiles endpoint.
     *
     * @param uuid the uuid of the player.
     * @return the response.
     */
    fun skyblockProfiles(uuid: String): CompletableFuture<Set<SkyblockProfile>>

    /**
     * Sends a request to the Skyblock Profile endpoint.
     *
     * @param profile the id of the profile.
     * @return the response.
     */
    fun skyblockProfile(profile: String): CompletableFuture<out SkyblockProfile>

    /**
     * Sends a request to the Skyblock News endpoint.
     *
     * @return the response.
     */
    fun skyblockNews(): CompletableFuture<Set<SkyblockNewsItem>>

    /**
     * Sends a request to the Skyblock Bazaar endpoint.
     *
     * @return the response.
     */
    fun skyblockBazaar(): CompletableFuture<out SkyblockBazaar>

    /**
     * Sends a request to the Skyblock Auctions endpoint.
     *
     * @param page the page to request as this endpoint is paginated, defaults to page 0
     * @return the response.
     */
    fun skyblockAuctions(page: Int = 0): CompletableFuture<out SkyblockAuctions>

    /**
     * Sends a request to the Skyblock Auction endpoint.
     *
     * @param auctionUuid the specific auction you want to query.
     * @return the response.
     */
    fun skyblockAuctionByUuid(auctionUuid: String): CompletableFuture<SkyblockAuction>

    /**
     * Sends a request to the Skyblock Auction endpoint.
     *
     * @param playerId the player you want to query auctions for.
     * @return the response.
     */
    fun skyblockAuctionByPlayer(playerId: String): CompletableFuture<List<SkyblockAuction>>

    /**
     * Sends a request to the Skyblock Auction endpoint.
     * @param profileId the profile you want to query auctions for.
     * @return the response.
     */
    fun skyblockAuctionByProfile(profileId: String): CompletableFuture<List<SkyblockAuction>>

    /**
     * Sends a request to Mojang's api to retrieve a UUID by username.
     *
     * @param username the username of the Minecraft account you want to get the UUID of.
     * @return the UUID.
     */
    fun uuidByUsername(username: String): CompletableFuture<UUID>

    /**
     * Disconnect and shut down all threads related to Kypixel.
     */
    fun disconnect()
}