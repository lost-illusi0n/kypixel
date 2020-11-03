package net.lostillusion.kypixel.core.endpoints

import net.lostillusion.kypixel.core.entities.*

sealed class HypixelEndpoint<T>(val url: String, val expected: Class<T>) {
    companion object {
        private const val API_BASE = "https://api.hypixel.net"
    }

    object WatchdogStatsEndpoint: HypixelEndpoint<WatchdogStatsImpl>("$API_BASE/watchdogStats", WatchdogStatsImpl::class.java)
    object StatusEndpoint: HypixelEndpoint<SessionDto>("$API_BASE/status", SessionDto::class.java)
    object RecentGamesEndpoint: HypixelEndpoint<RecentGamesImpl>("$API_BASE/recentGames", RecentGamesImpl::class.java)
    object PlayerCountEndpoint: HypixelEndpoint<PlayerCountImpl>("$API_BASE/playerCount", PlayerCountImpl::class.java)
    object PlayerEndpoint: HypixelEndpoint<PlayerDao>("$API_BASE/player", PlayerDao::class.java)
    object BoostersEndpoint: HypixelEndpoint<BoostersImpl>("$API_BASE/boosters", BoostersImpl::class.java)
    object FindGuildEndpoint: HypixelEndpoint<FindGuildImpl>("$API_BASE/findGuild", FindGuildImpl::class.java)
    object FriendsEndpoint: HypixelEndpoint<FriendsImpl>("$API_BASE/friends", FriendsImpl::class.java)
    object GameCountsEndpoint: HypixelEndpoint<GameCountsImpl>("$API_BASE/gameCounts", GameCountsImpl::class.java)
    object GuildEndpoint: HypixelEndpoint<GuildDao>("$API_BASE/guild", GuildDao::class.java)
    object SkyblockProfilesEndpoint: HypixelEndpoint<SkyblockProfilesDto>("$API_BASE/skyblock/profiles", SkyblockProfilesDto::class.java)
    object SkyblockProfileEndpoint: HypixelEndpoint<SkyblockProfileImpl>("$API_BASE/skyblock/profile", SkyblockProfileImpl::class.java)
    object SkyblockNewsEndpoint: HypixelEndpoint<SkyblockNewsItemDao>("$API_BASE/skyblock/news", SkyblockNewsItemDao::class.java)
    object SkyblockBazaarEndpoint: HypixelEndpoint<SkyblockBazaarImpl>("$API_BASE/skyblock/bazaar", SkyblockBazaarImpl::class.java)
    object SkyblockAuctionsEndpoint: HypixelEndpoint<SkyblockAuctionsImpl>("$API_BASE/skyblock/auctions", SkyblockAuctionsImpl::class.java)
    object SkyblockAuctionEndpoint: HypixelEndpoint<SkyblockAuctionDto>("$API_BASE/skyblock/auction", SkyblockAuctionDto::class.java)
}