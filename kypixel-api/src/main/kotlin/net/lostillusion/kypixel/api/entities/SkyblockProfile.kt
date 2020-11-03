package net.lostillusion.kypixel.api.entities

import java.util.Date

interface SkyblockProfile {
    val profileId: String
    val members: Map<String, SkyblockMember>
    val cuteName: String
}

interface SkyblockMember {
    val lastSave: Date
    val inventoryArmour: Item
    val coopInvitation: CoopInvitation?
    val firstJoin: Date
    val objectives: Map<String, Objective>
    val tutorial: List<String>
    val quests: Map<String, Quest>
    val lastDeath: Date
}

interface Quest {
    val status: String
    val activatedAt: Date
    val completedAt: Date
}

interface Objective {
    val status: String
    val progress: Int
    val completedAt: Date
}

interface CoopInvitation {
    val timestamp: Date
    val invitedBy: String?
    val confirmed: Boolean
    val confirmedTimestamp: Date?
}