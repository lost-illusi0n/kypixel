package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the RecentGames Hypixel Endpoint.
 */
interface RecentGames {
    /**
     * A [Set] of recent [Game]s.
     */
    val games: Set<Game>
}

/**
 * The representation of a Game.
 */
interface Game {
    /**
     * The date this game started.
     */
    val date: Date

    /**
     * The [GameType].
     */
    val gameType: GameType

    /**
     * The game mode.
     */
    val mode: String

    /**
     * The game map.
     */
    val map: String

    /**
     * The date this game ended.
     */
    val ended: Date?
}