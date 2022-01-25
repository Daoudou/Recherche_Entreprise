package fr.daoudou.re

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.view.ViewParent
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val svc = EntrepriseService()
        //EntrepriseDatabase.getDatabase(this)
        val listEntreprise = findViewById<ListView>(R.id.listeViewSearch)
        findViewById<Button>(R.id.buttonSearch).setOnClickListener{
            val query = findViewById<EditText>(R.id.editTextSearch).text.toString()
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
                    progressBar.visibility = View.INVISIBLE
                    listEntreprise.visibility = View.VISIBLE
                }
            }).start()
        }
        listEntreprise.setOnItemClickListener{_,_,position,_ ->
            val entreprise = listEntreprise.adapter.getItem(position) as Entreprise
            val intent = Intent(applicationContext, EntrepriseActivity::class.java)
            intent.putExtra("entreprise",entreprise)
            startActivity(intent)
        }
    }
}