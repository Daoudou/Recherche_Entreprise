package fr.daoudou.re

import android.util.JsonReader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

import java.net.URL
import javax.net.ssl.HttpsURLConnection

class EntrepriseService {

    private val serverUrl = "https://entreprise.data.gouv.fr"
    private val apiUrl = "$serverUrl/api/sirene"
    private val entrepriseUrl = "$apiUrl/v1/full_text/%s"

    fun getEntreprise(query:String) : List<Entreprise>{

        val url = URL(String.format(entrepriseUrl,query))
        var conn : HttpsURLConnection? = null
        try {
            conn = url.openConnection() as HttpsURLConnection
            var code = conn.responseCode
            if (code != HttpsURLConnection.HTTP_OK) return emptyList()

            val inputStream = conn.inputStream ?: return emptyList()
            val reader = JsonReader(inputStream.bufferedReader())
            val result = mutableListOf<Entreprise>()
            val entreprise = Entreprise("")

            reader.beginObject()
            while (reader.hasNext()){
                when (reader.nextName()){
                    "name" -> entreprise.name = reader.nextString()
                    else -> reader.skipValue()
                }
                result.add(entreprise)
            }
            reader.endObject()
            reader.close()
            result.sort()
            return result
        } catch (e: IOException){
            return emptyList()
        } finally {
            conn?.disconnect()
        }
    }
}