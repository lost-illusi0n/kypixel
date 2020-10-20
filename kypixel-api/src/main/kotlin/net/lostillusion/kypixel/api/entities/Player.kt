package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the Player Hypixel Endpoint.
 */
interface Player {
    /**
     * The Hypixel id for this user.
     */
    val id: String

    /**
     * A [Map] of achivements to times achieved.
     */
    val achievements: Map<String, Int>

    /**
     * A [Set] of all one time achievements achieved.
     */
    val onceTimeAchievements: Set<String>

    /**
     * The display name of the player.
     */
    val displayName: String

    /**
     * The first time this player logged onto Hypixel.
     */
    val firstLogin: Date

    /**
     * The total karma this player has earned.
     */
    val karma: Int

    /**
     * All known aliases(past names) of this player.
     */
    val knownAliases: Set<String>

    /**
     * All known aliases(past names) as lowercase of this player.
     */
    val knownAliasesLower: Set<String>

    /**
     * The last time this player logged onto Hypixel.
     */
    val lastLogin: Date

    /**
     * The total network experience this player has earned.
     */
    val networkExp: Long

    /**
     * The player name of this player.
     */
    val playerName: String

    /**
     * The total amount of hours this player played on Hypixel.
     */
    val timePlayed: Int

    /**
     * The Minecraft UUID of this player.
     */
    val uuid: String

    /**
     * The Hypixel package rank of this player.
     */
    val newPackageRank: String
}