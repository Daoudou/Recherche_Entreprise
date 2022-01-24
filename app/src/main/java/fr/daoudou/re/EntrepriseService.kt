package fr.daoudou.re

import android.util.JsonReader
import java.io.IOException

import java.net.URL
import javax.net.ssl.HttpsURLConnection

class EntrepriseService {

    private val serverUrl = "https://entreprise.data.gouv.fr"
    private val apiUrl = "$serverUrl/api/sirene"
    private val entrepriseUrl = "$apiUrl/v1/full_text/%s"

    fun getEntreprise(query:String) : List<Entreprise> {

        val url = URL(String.format(entrepriseUrl,query))
        var conn : HttpsURLConnection? = null
        try {
            conn = url.openConnection() as HttpsURLConnection
            conn.connect()
            var code = conn.responseCode
            if (code != HttpsURLConnection.HTTP_OK)
                return emptyList()

            val inputStream = conn.inputStream ?: return emptyList()
            val reader = JsonReader(inputStream.bufferedReader())
            val result = mutableListOf<Entreprise>()
            reader.beginObject()
            while (reader.hasNext()){
                if (reader.nextName().equals("etablissement")){
                    reader.beginArray()
                    while (reader.hasNext()){
                        reader.beginObject()
                        val entrepriseList = Entreprise("")
                        while(reader.hasNext()){
                            when(reader.nextName()){
                                "suggestion" -> break
                                "nom_raison_sociale" -> entrepriseList.nameSocial = reader.nextString()
                                else -> reader.skipValue()
                            }

                        }
                        result.add(entrepriseList)
                        reader.endObject()
                    }
                    reader.endArray()
                }
                else reader.skipValue()
            }
            reader.endObject()
            return result
        } catch (e: IOException){
            return emptyList()
        } finally {
            conn?.disconnect()
        }
    }

    fun getEntrepriseInformations(entreprise: Entreprise): EntrepriseInformations? {

        val url = URL(String.format(entrepriseUrl))
        var conn: HttpsURLConnection? = null
        try {
            conn = url.openConnection() as HttpsURLConnection
            conn.connect()
            if (conn.responseCode != HttpsURLConnection.HTTP_OK){
                return null
            }
            val inputStreamInformatios = conn.inputStream?: return null
            val reader = JsonReader(inputStreamInformatios.bufferedReader())
            val resultInformation = EntrepriseInformations("",
                "","","",
                "","")
            reader.beginObject()
            while (reader.hasNext()){
                if (reader.nextName().equals("etablissement")){
                    reader.beginArray()
                    while (reader.hasNext()){
                        reader.beginObject()

                        while(reader.hasNext()){
                            when(reader.nextName()){
                                "suggestion" -> break
                              //  "nom_raison_sociale" -> entrepriseList.nameSocial = reader.nextString()
                                "libelle_voie" -> resultInformation.libelleVoieEntreprise = reader.nextString()
                                "departement" -> resultInformation.departementEntreprise = reader.nextString()
                                "code_postal" -> resultInformation.codePostaleEntreprise = reader.nextString()
                                "libelle_activite_principale" -> resultInformation.libelleActivitePrincipaleEntreprise = reader.nextString()
                                "date_creation" -> resultInformation.dateCreationEntreprise = reader.nextString()
                                "geo_adresse" -> resultInformation.adresseEntreprise = reader.nextString()
                                else -> reader.skipValue()
                            }

                        }
                        reader.endObject()
                    }
                    reader.endArray()
                }
                else reader.skipValue()
            }
            reader.endObject()
            return resultInformation
        }catch (e: IOException){
            return null
        } finally {
            conn?.disconnect()
        }
    }
}

/*                      "nom_raison_sociale"                   -> entreprise.nameSocial = reader.nextString()
                        "siren"                                -> entreprise.sirenEntreprise = reader.nextLong()
                        "siret"                                -> entreprise.siretEntreprise = reader.nextLong()
                        "nic"                                  -> entreprise.nicEntreprise = reader.nextLong()
                        "numero_voie"                          -> entreprise.numeroVoie = reader.nextLong()
                        "indice_repetition"                    -> entreprise.indiceRepetition = reader.nextString()
                        "type_voie"                            -> entreprise.typeVoie = reader.nextString()
                        "libelle_voie"                         -> entreprise.libelleVoie = reader.nextString()
                        "code_postal"                          -> entreprise.codePostale = reader.nextLong()
                        "region"                               -> entreprise.regionEntreprise = reader.nextString()
                        "libelle_region"                       -> entreprise.libelleRegion = reader.nextString()
                        "departement"                          -> entreprise.departementEntreprise = reader.nextLong()
                        "arrondissement"                       -> entreprise.arrondissementEntreprise = reader.nextLong()
                        "commune"                              -> entreprise.communeEntreprise = reader.nextLong()
                        "date_creation"                        -> entreprise.dateDeCreation = reader.nextLong()
                        "email"                                -> entreprise.emailEntreprise = reader.nextString()
                        "libelle_nature_juridique_entreprise"  -> entreprise.libelleJuridique = reader.nextString()
                        "geo_adresse"                          -> entreprise.adresseGeo = reader.nextString()
                        else -> reader.skipValue()

*/