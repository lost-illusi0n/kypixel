package net.lostillusion.kypixel.api

/**
 * This should usually never be used in your code.
 */
interface KypixelProvider {
    fun create(token: String): Kypixel
}