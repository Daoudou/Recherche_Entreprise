package fr.daoudou.re

import androidx.room.Insert
import androidx.room.Query

interface HistoryDAO {

    @Query("SELECT * FROM History ORDER BY history.search ")
    fun getAll()

    @Query("SELECT COUNT(*) FROM HISTORY")
    fun getCount():Int

    @Query("SELECT * FROM History ORDER BY history.search LIMIT 1 OFFSET :position")
    fun getByPosition(position: Int) : History

    @Insert
    fun insert(history: History)

}