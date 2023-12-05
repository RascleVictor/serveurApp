package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Etudiant(
    val id : Int?=null,
    val firstname : String?=null,
    val lastname : String?=null,
    val age : String?=null,
    val image: String?=null
)
