package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.SkyblockNewsItem
import net.lostillusion.kypixel.api.entities.SkyblockNewsItemData

data class SkyblockNewsItemDao(
    val items: Set<SkyblockNewsItemImpl>
)

data class SkyblockNewsItemImpl(
    override val item: SkyblockNewsItemDataImpl,
    override val link: String,
    override val text: String,
    override val title: String
): SkyblockNewsItem

data class SkyblockNewsItemDataImpl(
    override val material: String,
    override val data: Int?
): SkyblockNewsItemData