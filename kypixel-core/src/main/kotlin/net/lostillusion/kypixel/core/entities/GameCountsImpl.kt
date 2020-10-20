package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.GameCountInfo
import net.lostillusion.kypixel.api.entities.GameCounts
import net.lostillusion.kypixel.api.entities.GameType

data class GameCountsImpl(
    override val games: Map<GameType, GameCountInfoImpl>,
    override val playerCount: Int
) : GameCounts, Entity<GameCountsImpl>

data class GameCountInfoImpl(
    override val players: Int,
    override val modes: Map<String, Int>?
): GameCountInfo, Entity<GameCountInfoImpl>