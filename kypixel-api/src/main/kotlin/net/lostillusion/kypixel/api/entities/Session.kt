package net.lostillusion.kypixel.api.entities

/**
 * Response for the Session Hypixel Endpoint.
 */
interface Session {
    /**
     * Whether this player is online or not.
     */
    val online: Boolean

    /**
     * The [GameType] this player is currently in.
     */
    val gameType: GameType?

    /**
     * The current mode this player is currently in.
     */
    val mode: String?

    /**
     * The current map this player is currently in.
     */
    val map: String?
}