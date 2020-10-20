package net.lostillusion.kypixel.api

import java.util.UUID

/**
 * This should usually never be used in your code.
 */
interface KypixelProvider {
    fun create(token: UUID): Kypixel
}