package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.SkyblockAuctions
import java.util.Date

data class SkyblockAuctionsImpl(
    override val page: Int,
    override val totalPages: Int,
    override val totalAuctions: Int,
    override val lastUpdated: Date,
    override val auctions: List<SkyblockAuctionImpl>
): SkyblockAuctions