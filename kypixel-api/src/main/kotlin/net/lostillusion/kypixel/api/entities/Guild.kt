package net.lostillusion.kypixel.api.entities

import java.awt.Color
import java.util.Date

/**
 * Response for the Guild Hypixel Endpoint.
 */
interface Guild {
    /**
     * The Hypixel id of this guild.
     */
    val id: String

    /**
     * The date this guild was created.
     */
    val created: Date

    /**
     * The name of this guild.
     */
    val name: String

    /**
     * The name as lower of this guild.
     */
    val nameLower: String

    /**
     * The description of this guild.
     */
    val description: String

    /**
     * The tag of this guild.
     */
    val tag: String

    /**
     * The tag color of this guild.
     */
    val tagColor: Color

    /**
     * The total amount of exp this guild has earned.
     */
    val exp: Int

    /**
     * A [Set] of [GuildMember]s in this guild.
     */
    val members: Set<GuildMember>

    /**
     * A [Map] of achivements to times achieved.
     */
    val achievements: Map<String, Int>

    /**
     * A [Set] of [GuildRank]s in this guild.
     */
    val ranks: Set<GuildRank>

    /**
     * Whether this guild is joinable.
     */
    val joinable: Boolean

    /**
     * The legacy ranking of this guild.
     */
    val legacyRanking: Int

    /**
     * Whether this guild is listed publicly.
     */
    val publiclyListed: Boolean

    /**
     * Whether the guild master tag is hidden in chat.
     */
    val hideGmTag: Boolean

    /**
     * The preferred [GameType] of this guild.
     */
    val preferredGames: Set<GameType>

    /**
     * The [Date] guild chat will be unmuted at.
     * The [Date] epoch will be 0 if guild chat is not muted.
     */
    val chatMute: Date

    /**
     * A [Map] of [GameType] to experience earned in said [GameType].
     */
    val guildExpByGameType: Map<GameType, Int>
}

/**
 * The representation of a Guild Member.
 */
interface GuildMember {
    /**
     * The Minecraft UUID of this guild member.
     */
    val uuid: String

    /**
     * The guild rank of this guild member.
     */
    val rank: String

    /**
     * The date this guild member join their guild.
     */
    val joined: Date

    /**
     * A map of the last 7 days(formatted YYYY-MM-DD) and exp earned by this guild member.
     */
    val expHistory: Map<String, Int>

    /**
     * The amount of current quest challenges this guild member completed.
     */
    val questParticipation: Int

    /**
     * The [Date] this guild member wil be unmuted.
     */
    val mutedTill: Date?
}


/**
 * The representation of a Guild Rank.
 */
interface GuildRank {
    /**
     * The name of this guild rank.
     */
    val name: String

    /**
     * Whether this rank is the default for the guild.
     */
    val default: Boolean

    /**
     * The [Date] this rank was created.
     */
    val created: Date

    /**
     * The priority of this rank.
     */
    val priority: Int

    /**
     * The tag of this rank.
     */
    val tag: String?
}