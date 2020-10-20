package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the Boosters Hypixel Endpoint.
 */
interface Boosters {
    /**
     * A set of [Booster]s.
     */
    val boosters: Set<Booster>

    /**
     * The [BoosterState].
     */
    val boosterState: BoosterState
}

/**
 * The state of Boosts.
 */
interface BoosterState {
    /**
     * Whether the time is decrementing.
     */
    val decrementing: Boolean
}

/**
 * The representation of a Hypixel Boost.
 */
interface Booster {
    /**
     * The id of the boost.
     */
    val id: String

    /**
     * The UUID of the person who purchased this boost.
     */
    val purchaserUuid: String

    /**
     * The multiplier of the boost.
     */
    val amount: Double

    /**
     * The original length of the boost.
     */
    val originalLength: Int

    /**
     * The remaining length of the boost.
     */
    val length: Int

    /**
     * The boost's [GameType].
     */
    val gameType: GameType

    /**
     * The date on which this boost was activated.
     */
    val dateActivated: Date
}