package net.lostillusion.kypixel.api.entities

import java.util.Date

/**
 * Response for the Friends Hypixel Endpoint.
 */
interface Friends {
    /**
     * A set of all friend relationships.
     */
    val records: Set<FriendRecord>
}

/**
 * The representation of a Friend.
 */
interface FriendRecord {
    /**
     * The Hypixel id of this record.
     */
    val id: String

    /**
     * The Minecraft UUID of the friendship sender.
     */
    val uuidSender: String

    /**
     * The Minecraft UUID of the friendship receiver.
     */
    val uuidReceiver: String

    /**
     * The date this friendship started.
     */
    val started: Date
}