package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.Player
import java.util.Date

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlayerImpl(
    @JsonProperty("_id") override val id: String,
    override val achievements: Map<String, Int>,
    @JsonProperty("achievementsOneTime") override val onceTimeAchievements: Set<String>,
    @JsonProperty("displayname") override val displayName: String,
    override val firstLogin: Date,
    override val karma: Int,
    override val knownAliases: Set<String>,
    override val knownAliasesLower: Set<String>,
    override val lastLogin: Date,
    override val networkExp: Long,
    @JsonProperty("playername") override val playerName: String,
    @JsonProperty("timePlaying") override val timePlayed: Int,
    override val uuid: String,
    override val newPackageRank: String
) : Player

data class PlayerDao(
    val player: PlayerImpl
)