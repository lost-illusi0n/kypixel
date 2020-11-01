package net.lostillusion.kypixel.core.ratelimiter

import net.lostillusion.kypixel.core.KypixelImpl
import net.lostillusion.kypixel.core.endpoints.EndpointRequest
import okhttp3.Response
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

class Ratelimiter(private val threadPool: KypixelImpl.ThreadPool, private val limit: Ratelimit) {
    private val requests: LinkedBlockingQueue<Long> = LinkedBlockingQueue()
    private val queue: LinkedBlockingQueue<EndpointRequest<*>> = LinkedBlockingQueue()

    fun queueRequest(request: EndpointRequest<*>) {
        var inQueue: Boolean
        synchronized(this) {
            inQueue = queue.peek() != null
            queue.add(request)
        }
        if(inQueue) return
        threadPool.executor.submit {
            var current = queue.peek()
            while(current != null) {
                try {
                    var sleepTime = calculateSleepTime()
                    while(sleepTime > 0) {
                        Thread.sleep(sleepTime)
                        // Update the sleep time incase it got updated
                        sleepTime = calculateSleepTime()
                    }
                    val timestamp = System.currentTimeMillis()
                    requests.add(timestamp)
                    threadPool.scheduledExecutor.schedule({ requests.remove(timestamp) }, limit.interval.toLong(), TimeUnit.SECONDS)
                    val response = current.call()
                    handleResponse(response)
                    current.result.complete(response)
                } catch(e: Throwable) {
                    current.result.completeExceptionally(e)
                } finally {
                    synchronized(this) {
                        queue.poll()
                        current = queue.peek()
                    }
                }
            }
        }
    }

    @Volatile private var remaining: Int = limit.requests
    @Volatile private var reset: Int = limit.interval

    private fun calculateSleepTime(): Long = synchronized(this) {
        if (remaining == 0) {
            val sleep = reset * 1000.toLong()
            remaining = limit.requests
            reset = limit.interval
            // one second margin of error
            sleep + 1000
        } else 0L
    }

    private fun handleResponse(response: Response) {
        val reset = response.headers["ratelimit-reset"]
        val remaining = response.headers["ratelimit-remaining"]
        val retryAfter = response.headers["retry-after"]
        synchronized(this) {
            remaining?.let { this.remaining = it.toInt() }
            retryAfter?.let { this.reset = it.toInt() }
            reset?.let { this.reset = it.toInt() }
        }
    }
}