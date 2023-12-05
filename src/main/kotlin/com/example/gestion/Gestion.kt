package com.example.gestion

import com.example.model.Etudiant

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
}