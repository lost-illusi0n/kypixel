package net.lostillusion.kypixel.api.entities

/**
 * Response for the GameCounts Hypixel Endpoint.
 */
interface GameCounts {
    /**
     * A map of [GameType] and [GameCountInfo].
     * Most of the information for a specific [GameType] will be in [GameCountInfo].
     */
    val games: Map<GameType, GameCountInfo>

    /**
     * The total player count of Hypixel.
     */
    val playerCount: Int
}

/**
 * The information of a [GameType].
 */
interface GameCountInfo {
    /**
     * The amount of people playing this [GameType].
     */
    val players: Int

    /**
     * A [Map] of game mode to people playing said game mode.
     */
    val modes: Map<String, Int>?
}