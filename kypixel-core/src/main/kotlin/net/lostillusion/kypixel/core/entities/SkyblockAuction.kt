package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.Item
import net.lostillusion.kypixel.api.entities.SkyblockAuction
import net.lostillusion.kypixel.api.entities.SkyblockBid
import net.lostillusion.kypixel.api.entities.SkyblockCategory
import net.lostillusion.kypixel.api.entities.SkyblockTier
import java.util.Date

data class SkyblockAuctionDto(
    val auctions: List<SkyblockAuctionImpl>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class SkyblockAuctionImpl(
    @JsonAlias("_id", "uuid")
    override val uuid: String,
    override val auctioneer: String,
    @JsonProperty("profile_id")
    override val profileId: String,
    override val coop: List<String>,
    override val start: Date,
    override val end: Date,
    @JsonProperty("item_name")
    override val itemName: String,
    @JsonProperty("item_lore")
    override val itemLore: String,
    override val extra: String,
    override val category: SkyblockCategory,
    override val tier: SkyblockTier,
    @JsonProperty("starting_bid")
    override val startingBid: Int,
    @JsonProperty("item_bytes")
    override val itemBytes: Item,
    override val claimed: Boolean,
    @JsonProperty("highest_bid_amount")
    override val highestBidAmount: Int,
    override val bids: List<SkyblockBidImpl>?
): SkyblockAuction

data class SkyblockBidImpl(
    @JsonProperty("auction_id")
    override val auctionId: String,
    override val bidder: String,
    @JsonProperty("profile_id")
    override val profileId: String,
    override val amount: Int,
    override val timestamp: Date
): SkyblockBid