package fr.daoudou.re

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(@PrimaryKey(autoGenerate = true) val id: Long? = null,
                        val search: String) {

    override fun toString(): String {
        return search
    }


    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if (javaClass != other?.javaClass) return false

        other as History
        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}