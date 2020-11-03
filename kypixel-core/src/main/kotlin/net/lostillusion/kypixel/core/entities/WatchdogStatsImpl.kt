package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.WatchdogStats

data class WatchdogStatsImpl(
    @JsonProperty("watchdog_lastMinute") override val watchdogLastMinute: Int,
    @JsonProperty("staff_rollingDaily") override val staffRollingDaily: Int,
    @JsonProperty("watchdog_rollingDaily") override val watchdogRollingDaily: Int,
    @JsonProperty("watchdog_total") override val watchdogTotal: Int,
    @JsonProperty("staff_total") override val staffTotal: Int
): WatchdogStats