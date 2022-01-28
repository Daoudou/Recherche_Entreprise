package fr.daoudou.re

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(version = 1, entities = [Entreprise::class, History::class])
abstract class EntrepriseDatabase : RoomDatabase() {

    abstract fun entrepriseDao(): EntrepriseDAO
    abstract fun historyDao() : HistoryDAO

    companion object{
        var INSTANCE: EntrepriseDatabase? = null

        fun getDatabase(context: Context): EntrepriseDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, EntrepriseDatabase::class.java, "company.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }
    }
}