package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import net.lostillusion.kypixel.api.entities.CoopInvitation
import net.lostillusion.kypixel.api.entities.Objective
import net.lostillusion.kypixel.api.entities.Quest
import net.lostillusion.kypixel.api.entities.SkyblockMember
import net.lostillusion.kypixel.api.entities.SkyblockProfile
import net.lostillusion.kypixel.core.deserializers.SkyblockTimestampDeserializer
import java.util.Date

data class SkyblockProfilesDto(
    val profiles: Set<SkyblockProfileImpl>
): Entity<SkyblockProfilesDto>

data class SkyblockProfileImpl(
    @JsonProperty("profile_id")
    override val profileId: String,
    override val members: Map<String, SkyblockMemberImpl>,
    @JsonProperty("cute_name")
    override val cuteName: String
): Entity<SkyblockProfileImpl>, SkyblockProfile

@JsonIgnoreProperties(ignoreUnknown = true)
data class SkyblockMemberImpl(
    @JsonProperty("last_save")
    override val lastSave: Date,
    @JsonProperty("inv_armor")
    override val inventoryArmour: ItemImpl,
    @JsonProperty("coop_invitation")
    override val coopInvitation: CoopInvitationImpl?,
    @JsonProperty("first_join")
    override val firstJoin: Date,
    override val objectives: Map<String, ObjectiveImpl>,
    override val tutorial: List<String>,
    override val quests: Map<String, QuestImpl>,
    @JsonProperty("last_death")
    @JsonDeserialize(using = SkyblockTimestampDeserializer::class)
    override val lastDeath: Date
): Entity<SkyblockMemberImpl>, SkyblockMember

@JsonIgnoreProperties(ignoreUnknown = true)
data class QuestImpl(
    override val status: String,
    @JsonProperty("activated_at")
    override val activatedAt: Date,
    @JsonProperty("completed_at")
    override val completedAt: Date
): Entity<QuestImpl>, Quest

@JsonIgnoreProperties(ignoreUnknown = true)
data class ObjectiveImpl(
    override val status: String,
    override val progress: Int,
    @JsonProperty("completed_at")
    override val completedAt: Date
): Entity<ObjectiveImpl>, Objective

data class CoopInvitationImpl(
    override val timestamp: Date,
    @JsonProperty("invited_by")
    override val invitedBy: String,
    override val confirmed: Boolean,
    @JsonProperty("confirmed_timestamp")
    override val confirmedTimestamp: Date
): Entity<CoopInvitationImpl>, CoopInvitation