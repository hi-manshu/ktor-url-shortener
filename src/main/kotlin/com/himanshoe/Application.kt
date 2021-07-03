package com.himanshoe

import com.himanshoe.base.configureRouting
import com.himanshoe.base.configureSerialization
import io.ktor.application.*

/**
 * Please note that you can use any other name instead of *module*.
 * Also note that you can have more then one modules in your application.
 * */

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    configureRouting()
    configureSerialization()
}