package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.PlayerCount

data class PlayerCountImpl(
    @JsonProperty("playerCount") override val count: Int
) : PlayerCount, Entity<PlayerCountImpl>