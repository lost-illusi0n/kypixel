package net.lostillusion.kypixel.api.entities

/**
 * Response for the WatchdogStats Hypixel Endpoint.
 */
interface WatchdogStats {
    /**
     * The amount of bans by Watchdog in the last minute.
     */
    val watchdogLastMinute: Int

    /**
     * The amount of bans by Staff in the past day.
     */
    val staffRollingDaily: Int

    /**
     * The amount of Watchdog bans in the past day.
     */
    val watchdogRollingDaily: Int

    /**
     * The total amount of Watchdog bans ever.
     */
    val watchdogTotal: Int

    /**
     * The total amount of Staff bans ever.
     */
    val staffTotal: Int
}