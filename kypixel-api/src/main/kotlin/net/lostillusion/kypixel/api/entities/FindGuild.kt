package net.lostillusion.kypixel.api.entities

/**
 * Response for the FindGuild Hypixel Endpoint.
 */
interface FindGuild {
    /**
     * The Hypixel ID of the guild found.
     */
    val guild: String
}