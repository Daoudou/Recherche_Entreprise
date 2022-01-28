package fr.daoudou.re

import android.provider.ContactsContract
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Entreprise(@PrimaryKey(autoGenerate = true) var siret: Long? = null,
                      var siren: Long? = null,
                      var nameSocial:String, var id: Int? = null,
                      var libelleVoieEntreprise: String? = null,
                      var departementEntreprise: String? = null,
                      var codePostaleEntreprise: Long? = null,
                      var libelleActivitePrincipaleEntreprise: String? = null,
                      var dateCreationEntreprise: String? = null,
                      var adresseEntreprise: String? = null
                        ): Comparable<Entreprise>, Serializable{

    override fun toString(): String {
        return nameSocial
    }

    override fun compareTo(other: Entreprise): Int {
        return nameSocial.compareTo(other.nameSocial)
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Entreprise
        return true
    }

    override fun hashCode(): Int {
        return siret.hashCode()
    }

}


/*var sirenEntreprise:            Long? = null,
                        var siretEntreprise:            Long? = null,
                        var nicEntreprise:              Long? = null,
                        var numeroVoie:                 Long? = null,
                        var indiceRepetition:           String? = null,
                        var typeVoie:                   String? = null,
                        var libelleVoie:                String? = null,
                        var codePostale:                Long? = null,
                        var regionEntreprise:           String? = null,
                        var libelleRegion:              String? = null,
                        var departementEntreprise:      Long? = null,
                        var arrondissementEntreprise:   Long? = null,
                        var communeEntreprise:          Long? = null,
                        var dateDeCreation:             Long? = null,
                        var emailEntreprise:            String? = null,
                        var libelleJuridique:            String? = null,
                        var adresseGeo:                 String? = null,
                        */





