package fr.daoudou.re

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.view.ViewParent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val svc = EntrepriseService()
        findViewById<Button>(R.id.buttonSearch).setOnClickListener{
            val query = findViewById<EditText>(R.id.editTextSearch).text.toString()
            val listEntreprise = findViewById<ListView>(R.id.listeViewSearch)
            val progressBar = findViewById<ProgressBar>(R.id.progressbarSearch)
            Thread(Runnable {
                runOnUiThread {
                    progressBar.visibility = View.VISIBLE
                    listEntreprise.visibility = View.VISIBLE
                }
               val result = svc.getEntreprise(query)
                runOnUiThread {
                    listEntreprise.adapter = ArrayAdapter<Entreprise>(applicationContext,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    result)
                    //findViewById<TextView>(R.id.textViewListContent).setTextColor(R.color.purple_200)

                    progressBar.visibility = View.INVISIBLE
                    listEntreprise.visibility = View.VISIBLE
                }
            }).start()
        }
    }

}