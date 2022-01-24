package fr.daoudou.re

import android.provider.ContactsContract
import java.io.Serializable
import java.util.*


data class Entreprise(  var nameSocial:String
                        ): Comparable<Entreprise>, Serializable{

    override fun toString(): String {
        return nameSocial
    }

    override fun compareTo(other: Entreprise): Int {
        return nameSocial.compareTo(other.nameSocial)
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





