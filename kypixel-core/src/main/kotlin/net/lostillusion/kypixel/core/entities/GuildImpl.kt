package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.GameType
import net.lostillusion.kypixel.api.entities.Guild
import net.lostillusion.kypixel.api.entities.GuildMember
import net.lostillusion.kypixel.api.entities.GuildRank
import java.awt.Color
import java.util.Date

data class GuildDao(
    val guild: GuildImpl
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GuildImpl(
    @JsonProperty("_id") override val id: String,
    override val created: Date,
    override val name: String,
    @JsonProperty("name_lower") override val nameLower: String,
    override val description: String,
    override val tag: String,
    override val tagColor: Color,
    override val exp: Int,
    override val members: Set<GuildMemberImpl>,
    override val achievements: Map<String, Int>,
    override val ranks: Set<GuildRankImpl>,
    override val joinable: Boolean,
    override val legacyRanking: Int,
    override val publiclyListed: Boolean,
    override val hideGmTag: Boolean,
    override val preferredGames: Set<GameType>,
    override val chatMute: Date,
    override val guildExpByGameType: Map<GameType, Int>
): Guild

data class GuildMemberImpl(
    override val uuid: String,
    override val rank: String,
    override val joined: Date,
    override val expHistory: Map<String, Int>,
    override val questParticipation: Int,
    override val mutedTill: Date? = null
) : GuildMember

data class GuildRankImpl(
    override val name: String,
    override val default: Boolean,
    override val created: Date,
    override val priority: Int,
    override val tag: String? = null
) : GuildRank