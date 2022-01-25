package fr.daoudou.re

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface EntrepriseDAO {


    @Query("SELECT * FROM Entreprise")
    fun getAll() : List<Entreprise>

    @Query("SELECT * FROM Entreprise ORDER BY entreprise.siret = :siret ")
    fun getBySiret(siret: Long) : Entreprise

    @Insert
    fun insert(entreprise: Entreprise)

}