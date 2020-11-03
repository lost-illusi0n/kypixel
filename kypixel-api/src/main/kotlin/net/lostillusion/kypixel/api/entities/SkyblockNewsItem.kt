package net.lostillusion.kypixel.api.entities

/**
 * Response for the Hypixel Skyblock News endpoint.
 */
interface SkyblockNewsItem {
    /**
     * The item data.
     */
    val item: SkyblockNewsItemData

    /**
     * The Hypixel link to this article.
     */
    val link: String

    /**
     * The text of this article.
     */
    val text: String

    /**
     * The title of this article.
     */
    val title: String
}

/**
 * The item data of a news item.
 */
interface SkyblockNewsItemData {
    /**
     * The material.
     */
    val material: String

    /**
     * The data.
     */
    val data: Int?
}