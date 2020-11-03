package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the Skyblock Profile endpoint.
 */
interface SkyblockProfile {
    /**
     * The Hypixel ID of this profile.
     */
    val profileId: String

    /**
     * The members in this profile.
     */
    val members: Map<String, SkyblockMember>

    /**
     * The cute name.
     */
    val cuteName: String
}

/**
 * A Skyblock Member.
 */
interface SkyblockMember {
    /**
     * The last save date.
     */
    val lastSave: Date

    /**
     * The inventory armour and its data.
     */
    val inventoryArmour: Item

    /**
     * The invitation for this member.
     */
    val coopInvitation: CoopInvitation?

    /**
     * The date they first joined the coop.
     */
    val firstJoin: Date

    /**
     * A map of objective names to objective data.
     */
    val objectives: Map<String, Objective>

    /**
     * Undocumented.
     */
    val tutorial: List<String>

    /**
     * A map of quest name to quest data.
     */
    val quests: Map<String, Quest>

    /**
     * The date of last death/
     */
    val lastDeath: Date
}

/**
 * A Skyblock quest.
 */
interface Quest {
    /**
     * Current status of the quest.
     */
    val status: String

    /**
     * The date this quest was activated.
     */
    val activatedAt: Date

    /**
     * The date this quest was completed, or 0 epoch if not completed.
     */
    val completedAt: Date
}

/**
 * A Skyblock Objective.
 */
interface Objective {
    /**
     * Current status of this objective.
     */
    val status: String

    /**
     * The progress of this objective.
     */
    val progress: Int

    /**
     * The date this objective was completed. or 0 epoch if not completed.
     */
    val completedAt: Date
}

/**
 * A Skyblock Coop Invitation.
 */
interface CoopInvitation {
    /**
     * The timestamp of when this invitation was made.
     */
    val timestamp: Date

    /**
     * The person who made this invitation.
     */
    val invitedBy: String?

    /**
     * Whether this invitation was confirmed.
     */
    val confirmed: Boolean

    /**
     * The date this invitation was confirmed.
     */
    val confirmedTimestamp: Date?
}