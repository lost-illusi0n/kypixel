package net.lostillusion.kypixel.api.entities

import java.util.Date

interface SkyblockAuctions {
    val page: Int
    val totalPages: Int
    val totalAuctions: Int
    val lastUpdated: Date
    val auctions: List<SkyblockAuction>
}

interface SkyblockAuction {
    val uuid: String
    val auctioneer: String
    val profileId: String
    val coop: List<String>
    val start: Date
    val end: Date
    val itemName: String
    val itemLore: String
    val extra: String
    val category: SkyblockCategory
    val tier: SkyblockTier
    val startingBid: Int
    val itemBytes: Item
    val claimed: Boolean
    val highestBidAmount: Int
    val bids: List<SkyblockBid>?
}

interface SkyblockBid {
    val auctionId: String
    val bidder: String
    val profileId: String
    val amount: Int
    val timestamp: Date
}