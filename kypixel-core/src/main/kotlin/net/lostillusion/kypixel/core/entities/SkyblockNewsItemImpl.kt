package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.SkyblockNewsItem
import net.lostillusion.kypixel.api.entities.SkyblockNewsItemData

data class SkyblockNewsItemDao(
    val items: Set<SkyblockNewsItemImpl>
): Entity<SkyblockNewsItemDao>

data class SkyblockNewsItemImpl(
    override val item: SkyblockNewsItemDataImpl,
    override val link: String,
    override val text: String,
    override val title: String
): Entity<SkyblockNewsItemImpl>, SkyblockNewsItem

data class SkyblockNewsItemDataImpl(
    override val material: String,
    override val data: Int?
): Entity<SkyblockNewsItemDataImpl>, SkyblockNewsItemData