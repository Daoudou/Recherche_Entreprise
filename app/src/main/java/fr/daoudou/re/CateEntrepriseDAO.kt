package fr.daoudou.re

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CateEntrepriseDAO {


    @Query("SELECT * FROM CateEntreprise ORDER BY entrepriseCate LIMIT 1 OFFSET :position")
    fun getByPosition(position: Int) : CateEntreprise

    @Query("SELECT COUNT(*) FROM CateEntreprise")
    fun getCount():Int

    @Insert
    fun instert(entreprise: CateEntreprise) : Long


}