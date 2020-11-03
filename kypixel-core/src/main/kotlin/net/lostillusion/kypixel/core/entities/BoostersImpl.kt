package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.Booster
import net.lostillusion.kypixel.api.entities.BoosterState
import net.lostillusion.kypixel.api.entities.Boosters
import net.lostillusion.kypixel.api.entities.GameType
import java.util.Date

data class BoostersImpl(
    override val boosters: Set<BoosterImpl>,
    override val boosterState: BoosterStateImpl
): Boosters

data class BoosterStateImpl(override val decrementing: Boolean) : BoosterState

@JsonIgnoreProperties(ignoreUnknown = true)
data class BoosterImpl(
    @JsonProperty("_id") override val id: String,
    override val purchaserUuid: String,
    override val amount: Double,
    override val originalLength: Int,
    override val length: Int,
    override val gameType: GameType,
    override val dateActivated: Date
): Booster