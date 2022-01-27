package fr.daoudou.re

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface EntrepriseDAO {


    @Query("SELECT * FROM Entreprise")
    fun getAll() : List<Entreprise>

    @Query("SELECT * FROM Entreprise ORDER BY entreprise.siret = :siret ")
    fun getBySiret(siret: Long) : Entreprise?

    @Query("SELECT * FROM Entreprise ORDER BY entreprise.nameSocial LIMIT 1 OFFSET :position ")
    fun getByPosition(position: Int) :Entreprise

    @Query("SELECT COUNT(*) FROM Entreprise")
    fun getCount():Int

    @Insert
    fun insert(entreprise: Entreprise)

}