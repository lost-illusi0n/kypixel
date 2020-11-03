package net.lostillusion.kypixel.api.entities

interface SkyblockNewsItem {
    val item: SkyblockNewsItemData
    val link: String
    val text: String
    val title: String
}

interface SkyblockNewsItemData {
    val material: String
    val data: Int?
}