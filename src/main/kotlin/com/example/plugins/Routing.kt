package com.example.plugins

import com.example.gestion.Gestion
import com.example.model.Etudiant
import  io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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
            post("/ajouter") {
                var etudiant = call.receive<Etudiant>()
                when(maGestion.ajouterEtudiant(etudiant)){
                    1->{
                        call.respond(HttpStatusCode.OK)
                    }
                    else->{
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }
            }
            delete("/Supprimer/{id}") {
                var id = call.parameters["id"]
                when(maGestion.supprimerEtudiant(id!!)){
                    1->{
                        call.respond(HttpStatusCode.OK)
                    }
                    else->{
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }

            }

        }
    }
}
