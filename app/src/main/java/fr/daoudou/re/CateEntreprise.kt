package fr.daoudou.re

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class CateEntreprise(@PrimaryKey(autoGenerate = true)val id:Long? = null,
                            var entrepriseCate: String
                            ) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CateEntreprise

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return entrepriseCate
    }



}
