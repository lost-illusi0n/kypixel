package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.Item

data class ItemImpl(
    override val type: Int?,
    override val data: String
): Item