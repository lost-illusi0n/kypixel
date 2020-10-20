package net.lostillusion.kypixel.core

import net.lostillusion.kypixel.api.Kypixel
import net.lostillusion.kypixel.api.KypixelProvider
import java.util.UUID

class KypixelProviderImpl: KypixelProvider {
    override fun create(token: UUID): Kypixel = KypixelImpl(token)
}