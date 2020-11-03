package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.SkyblockBazaar
import net.lostillusion.kypixel.api.entities.SkyblockOrderSummary
import net.lostillusion.kypixel.api.entities.SkyblockProduct
import net.lostillusion.kypixel.api.entities.SkyblockQuickStatus
import java.util.Date

data class SkyblockBazaarImpl(
    override val lastUpdated: Date,
    override val products: Map<String, SkyblockProductImpl>
): SkyblockBazaar

data class SkyblockProductImpl(
    @JsonProperty("product_id")
    override val productId: String,
    @JsonProperty("sell_summary")
    override val sellSummary: Set<SkyblockOrderSummaryImpl>,
    @JsonProperty("buy_summary")
    override val buySummary: Set<SkyblockOrderSummaryImpl>,
    @JsonProperty("quick_status")
    override val quickStatus: SkyblockQuickStatusImpl
): SkyblockProduct

data class SkyblockOrderSummaryImpl(
    override val amount: Int,
    override val pricePerUnit: Float,
    override val orders: Int
): SkyblockOrderSummary

data class SkyblockQuickStatusImpl(
    override val productId: String,
    override val sellPrice: Float,
    override val sellVolume: Int,
    override val sellMovingWeek: Int,
    override val sellOrders: Int,
    override val buyPrice: Float,
    override val buyVolume: Int,
    override val buyMovingWeek: Int,
    override val buyOrders: Int
): SkyblockQuickStatus