package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.GameType
import net.lostillusion.kypixel.api.entities.Session

data class SessionImpl(
    override val online: Boolean,
    override val gameType: GameType? = null,
    override val mode: String? = null,
    override val map: String? = null
): Session

data class SessionDto(
    val session: SessionImpl
)