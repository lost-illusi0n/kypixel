# kypixel
An easy to use library for communicating with the Hypixel API in Kotlin or Java.

Kypixel is a modern library, developed in Kotlin, designed to be simple yet powerful. It utilizes powerful ``CompletableFuture``s to return responses to you and by doing so, it allows you to work with Kypixel in whatever way fits your needs. Along with its api, it has straight-forward documentation.

## Dependency
Internally, Kypixel is composed of both an api and core module, however to properly have these modules on your classpath, Kypixel provides a proper dependency for you to use.

#### Gradle
```groovy
repositories { maven { url "https://jitpack.io" } }

dependencies { implementation 'com.github.lost-illusi0n.kypixel:kypixel:1.1.0' }
```

## Kotlin/Java Interop
This library is developed in Kotlin, however it has full Java support as well. All documented methods and classes should fundamentally be the same in both languages.

## Ratelimiting
The Hypixel API has a default ratelimit of 120 requests in 60 seconds (can be increased by contacting Hypixel). Kypixel takes in account this ratelimit and will properly throttle your requests to prevent hitting this limit. Kypixel figures this out by reading the ratelimit headers from Discord and the ``Ratelimit`` defined in your Kypixel intance.

## Examples
#### Getting a Kypixel instance
Getting a Kypixel instance is as simple as calling a method. ``Kypixel.fromToken`` will provide a Kypixel instance for you to use with the provided token.
```kotlin
val kypixel = Kypixel.fromToken("private")
```
#### Handling requests
All requests made in Kypixel will be wrapped in a ``CompletableFuture``. You can handle these either synchronously or asynchronously.
##### Asynchronously
```kotlin
val kypixel = Kypixel.fromToken("private")
kypixel.watchdogStats().thenAccept { stats ->
    println(stats)
}.exceptionally { handleException(it) }
```
Using ``CompletableFuture``s is quite simple, though it is important to handle exceptions(by adding ``#exceptionally``) as it will be silently swallowed otherwise.
##### Synchronously
```kotlin
val kypixel = Kypixel.fromToken("private")
println(kypixel.watchdogStats().join())
```
It is important to note that handling these requests synchronously will block whatever thread it's running on. However, in small requests, blocking the current thread will most likely not cause problems. To run ``CompletableFuture``s synchronously, you need to add ``#join`` to the future you get from Kypixel. 