package fr.daoudou.re

import android.util.JsonReader
import android.util.JsonToken
import java.io.IOException

import java.net.URL
import javax.net.ssl.HttpsURLConnection

class EntrepriseService {

    private val serverUrl = "https://entreprise.data.gouv.fr"
    private val apiUrl = "$serverUrl/api/sirene"
    private val entrepriseUrl = "$apiUrl/v1/full_text/%s"

    fun getEntreprise(query: String): List<Entreprise> {

        val url = URL(String.format(entrepriseUrl, query))
        var conn: HttpsURLConnection? = null
        try {
            conn = url.openConnection() as HttpsURLConnection
            conn.connect()
            val code = conn.responseCode
            if (code != HttpsURLConnection.HTTP_OK)
                return emptyList()

            val inputStream = conn.inputStream ?: return emptyList()
            val reader = JsonReader(inputStream.bufferedReader())
            val result = mutableListOf<Entreprise>()
            reader.beginObject()
            while (reader.hasNext()) {
                if (reader.nextName().equals("etablissement")) {
                    reader.beginArray()
                    while (reader.hasNext()) {
                        reader.beginObject()
                        val entrepriseList = Entreprise("")
                        while (reader.hasNext()) {
                            when (reader.nextName()) {
                                "nom_raison_sociale" -> if(reader.peek() != JsonToken.NULL) entrepriseList.nameSocial = reader.nextString()
                                                        else reader.skipValue()

                                "libelle_voie" -> if (reader.peek() !== JsonToken.NULL) entrepriseList.libelleVoieEntreprise = reader.nextString()
                                                  else reader.skipValue()

                                 "departement" -> if (reader.peek() !== JsonToken.NULL) entrepriseList.departementEntreprise = reader.nextInt()
                                                           else reader.skipValue()

                                 "code_postal" -> if (reader.peek() !== JsonToken.NULL) entrepriseList.codePostaleEntreprise = reader.nextLong()
                                                 else reader.skipValue()

                                "libelle_activite_principale" -> if (reader.peek() !== JsonToken.NULL) entrepriseList.libelleActivitePrincipaleEntreprise = reader.nextString()
                                                                else reader.skipValue()

                                "date_creation" -> if (reader.peek() !== JsonToken.NULL) entrepriseList.dateCreationEntreprise = reader.nextString()
                                                    else reader.skipValue()

                                "geo_adresse" -> if (reader.peek() !== JsonToken.NULL) entrepriseList.adresseEntreprise = reader.nextString()
                                                else reader.skipValue()
                                else -> reader.skipValue()
                            }

                        }
                        result.add(entrepriseList)
                        reader.endObject()
                    }
                    reader.endArray()
                } else reader.skipValue()
            }
            reader.endObject()
            return result
        } catch (e: IOException) {
            return emptyList()
        } finally {
            conn?.disconnect()
        }
    }
}

/*

*/