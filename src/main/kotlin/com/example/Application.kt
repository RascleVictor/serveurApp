package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    val environnment = applicationEngineEnvironment {
        connector{
            port = 8080
            host = "0.0.0.0"
        }
        module{
            configureSerialization()
            configureRouting()
        }
    }
    embeddedServer(Netty, environnment)
        .start(wait = true)
}


