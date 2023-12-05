package com.example.plugins

import com.example.gestion.Gestion
import  io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing() {
        val maGestion = Gestion()
        route("/test"){

        }
        route("/bdd"){
            get("/lireLesEtudiants"){
                val lesEtudiants = maGestion.lireLesEtudiants()
                println(lesEtudiants)
                when(lesEtudiants.size > 0){
                    true-> {
                        call.respond(HttpStatusCode.OK, lesEtudiants)
                    }

                    false -> {
                        call.respond(HttpStatusCode.NoContent)
                    }
                }
            }

        }
    }
}
