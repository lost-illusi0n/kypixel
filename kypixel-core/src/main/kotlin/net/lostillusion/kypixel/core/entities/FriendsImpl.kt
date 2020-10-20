package net.lostillusion.kypixel.core.entities

import com.fasterxml.jackson.annotation.JsonProperty
import net.lostillusion.kypixel.api.entities.FriendRecord
import net.lostillusion.kypixel.api.entities.Friends
import java.util.Date

data class FriendsImpl(
    override val records: Set<FriendRecordImpl>
): Friends, Entity<FriendsImpl>

data class FriendRecordImpl(
    @JsonProperty("_id") override val id: String,
    override val uuidSender: String,
    override val uuidReceiver: String,
    override val started: Date
) : FriendRecord, Entity<FriendRecordImpl>