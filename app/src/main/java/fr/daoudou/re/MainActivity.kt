package fr.daoudou.re

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val svc = EntrepriseService()
        val listEntreprise = findViewById<ListView>(R.id.listeViewSearch)
        findViewById<Button>(R.id.buttonSearch).setOnClickListener{
            val query = findViewById<EditText>(R.id.editTextSearch).text.toString()
            val progressBar = findViewById<ProgressBar>(R.id.progressbarSearch)
            Thread(Runnable {
                runOnUiThread {
                    progressBar.visibility = View.VISIBLE
                    listEntreprise.visibility = View.INVISIBLE
                }
               val result = svc.getEntreprise(query)
                runOnUiThread {
                    listEntreprise.adapter = ArrayAdapter<Entreprise>(applicationContext,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    result)
                    progressBar.visibility = View.INVISIBLE
                    listEntreprise.visibility = View.VISIBLE
                }
            }).start()
        }
    }
}