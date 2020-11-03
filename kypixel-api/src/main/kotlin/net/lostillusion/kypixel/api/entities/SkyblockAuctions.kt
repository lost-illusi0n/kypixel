package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the Hypixel Skyblock Auctions endpoints.
 * This is paginated as it will list all current auctions on SkyBlock.
 */
interface SkyblockAuctions {
    /**
     * The page of this result.
     */
    val page: Int

    /**
     * The total amount of pages.
     */
    val totalPages: Int

    /**
     * The total amount of auctions.
     */
    val totalAuctions: Int

    /**
     * The last time this endpoint was updated.
     */
    val lastUpdated: Date

    /**
     * The [List] of [SkyblockAuction]s.
     */
    val auctions: List<SkyblockAuction>
}

/**
 * A Skyblock auction.
 * Could be found from the Auctions or Auction endpoint.
 */
interface SkyblockAuction {
    /**
     * The uuid of this auction.
     */
    val uuid: String

    /**
     * The uuid of the auctioneer.
     */
    val auctioneer: String

    /**
     * The profile id.
     */
    val profileId: String

    /**
     * Undocumented.
     */
    val coop: List<String>

    /**
     * The start of this auction.
     */
    val start: Date

    /**
     * The end of this auction.
     */
    val end: Date

    /**
     * The name of the item.
     */
    val itemName: String

    /**
     * The lore of the item.
     */
    val itemLore: String

    /**
     * Anything extra of this item.
     */
    val extra: String

    /**
     * The [SkyblockCategory] of this item.
     */
    val category: SkyblockCategory

    /**
     * The [SkyblockTier] of this item.
     */
    val tier: SkyblockTier

    /**
     * The starting bid of this auction.
     */
    val startingBid: Int

    /**
     * The [Item] being sold.
     */
    val itemBytes: Item

    /**
     * Whether this auction was claimed.
     */
    val claimed: Boolean

    /**
     * The highest bid amount.
     */
    val highestBidAmount: Int

    /**
     * A [List] of [SkyblockBid]s, or null if none.
     */
    val bids: List<SkyblockBid>?
}

/**
 * A Skyblock Auction bid.
 */
interface SkyblockBid {
    /**
     * The id of the auction.
     */
    val auctionId: String

    /**
     * The id of the bidder.
     */
    val bidder: String

    /**
     * The profile.
     */
    val profileId: String

    /**
     * The amount being bid.
     */
    val amount: Int

    /**
     * The timestamp this bid was made.
     */
    val timestamp: Date
}