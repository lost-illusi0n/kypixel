package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the Hypixel Skyblock Bazaar endpoint.
 */
interface SkyblockBazaar {
    /**
     * A [Date] representing when the Bazaar was last updated.
     */
    val lastUpdated: Date
    /**
     * A [SkyblockProduct] mapped to it's [SkyblockProduct.profileId].
     */
    val products: Map<String, SkyblockProduct>
}

/**
 * A Skyblock Bazaar product.
 */
interface SkyblockProduct {
    /**
     * The id of this product.
     */
    val productId: String

    /**
     * The order summaries for selling this product.
     */
    val sellSummary: Set<SkyblockOrderSummary>

    /**
     * The top 30 order summaries for buying this product.
     */
    val buySummary: Set<SkyblockOrderSummary>

    /**
     * A summary of the live state of this product.
     */
    val quickStatus: SkyblockQuickStatus
}

/**
 * An order of a [SkyblockProduct].
 */
interface SkyblockOrderSummary {
    /**
     * The quantity this order is selling/buying.
     */
    val amount: Int

    /**
     * The price per unit of this order.
     */
    val pricePerUnit: Float

    /**
     * The amount of orders of this product.
     */
    val orders: Int
}

/**
 * A summary of the live state of this product.
 */
interface SkyblockQuickStatus {
    /**
     * The product id of the product.
     */
    val productId: String

    /**
     * The weighted average of the top 2% of orders by volume.
     */
    val sellPrice: Float
    /**
     * The sum of item amounts in all orders.
     */
    val sellVolume: Int
    /**
     * Historic transacted volume from the last 7 days + live state.
     */
    val sellMovingWeek: Int
    /**
     * Count of active sell orders.
     */
    val sellOrders: Int
    /**
     * The weighted average of the top 2% of orders by volume.
     */
    val buyPrice: Float
    /**
     * The sum of item amounts in all orders.
     */
    val buyVolume: Int
    /**
     * Historic transacted volume from the last 7 days + live state.
     */
    val buyMovingWeek: Int
    /**
     * Count of active buy orders.
     */
    val buyOrders: Int
}