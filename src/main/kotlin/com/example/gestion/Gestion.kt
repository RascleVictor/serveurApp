package com.example.gestion

import com.example.model.Etudiant
import java.sql.PreparedStatement

class Gestion {
    var laConnexion = Connexion("jdbc:mysql://localhost/etudiants", "root", "")
    fun lireLesEtudiants():ArrayList<Etudiant>{
        val ar_Etudiant = ArrayList<Etudiant>()
        val preparedStatement =laConnexion.getConnexion()
            .prepareStatement("SELECT*FROM info")
            val rs = preparedStatement.executeQuery()
        while (rs.next()){
            ar_Etudiant.add(
                Etudiant(
                    rs.getInt("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("age"),
                    rs.getString("image")
            ))

        }
        return ar_Etudiant
    }

    fun ajouterEtudiant(etudiant: Etudiant):Int{
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("INSERT INTO etudiants.info(firstname, lastname, age, image) VALUES (?, ?, ?, ?)")
        prepStatement.setString(1, etudiant.firstname)
        prepStatement.setString(2, etudiant.lastname)
        prepStatement.setString(3, etudiant.age)
        prepStatement.setString(4, etudiant.image)
        return prepStatement.executeUpdate()
    }

    fun supprimerEtudiant(id: String): Int{
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("DELETE FROM etudiants.info WHERE id=?")
        prepStatement.setString(1, id)
        return prepStatement.executeUpdate()
    }

    fun modifierEtudiant(etudiant: Etudiant): Int{
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("")
        prepStatement.setString(1, etudiant.id)
        prepStatement.setString(2, etudiant.firstname)
        prepStatement.setString(3, etudiant.lastname)
        prepStatement.setString(4, etudiant.age)
        prepStatement.setString(5, etudiant.image)
        return prepStatement.executeUpdate()
    }
}