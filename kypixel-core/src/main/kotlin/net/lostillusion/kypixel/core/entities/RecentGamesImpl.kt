package net.lostillusion.kypixel.core.entities

import net.lostillusion.kypixel.api.entities.Game
import net.lostillusion.kypixel.api.entities.GameType
import net.lostillusion.kypixel.api.entities.RecentGames
import java.util.Date

data class RecentGamesImpl(
    override val games: Set<GameImpl>
): RecentGames

data class GameImpl(
    override val date: Date,
    override val gameType: GameType,
    override val mode: String,
    override val map: String,
    override val ended: Date? = null
): Game