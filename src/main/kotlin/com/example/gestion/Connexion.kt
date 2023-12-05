package com.example.gestion

import com.mysql.jdbc.Driver
import java.sql.Connection
import java.sql.DriverManager

class Connexion(url : String, username : String, password :String) {
    private lateinit var conn :Connection
    private val url = url
    private val username = username
    private val password = password
    init {


            conn = DriverManager.getConnection(url, username, password)


        }

    fun getConnexion(): Connection {
        return conn
    }
}
