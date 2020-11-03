package net.lostillusion.kypixel.api.entities

interface Item {
    /**
     * Type of the item.
     */
    val type: Int?

    /**
     * The data of this item.
     * This is a base64 gzip encoded string.
     */
    val data: String
}