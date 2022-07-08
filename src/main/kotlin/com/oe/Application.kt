package com.oe

import com.oe.di.mainModule
import com.oe.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.Netty
import org.koin.ktor.ext.Koin
import io.ktor.application.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(Koin) {
            modules(mainModule)
        }
        configureMonitoring()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
