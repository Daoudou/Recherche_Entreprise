package fr.daoudou.re

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.view.ViewParent
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = EntrepriseDatabase.getDatabase(this)
        val entrepriseAdd = db.entrepriseDao()
        val svc = EntrepriseService()
        val listEntreprise = findViewById<ListView>(R.id.listeViewSearch)
        findViewById<ImageButton>(R.id.buttonSearch).setOnClickListener{

            AlertDialog.Builder(this).apply {
                setMessage("Chargement de la recherche")
            }.create().show()

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

            val entredb = EntrepriseDatabase.getDatabase(this)
            val entredb1 = entredb.entrepriseDao()
            entredb1.getByPosition(position)

            val entreprise = listEntreprise.adapter.getItem(position) as Entreprise

            if (entredb1.getBySiret(entreprise.siret!!) != null){

                entredb1.getByPosition(position)
                val intent = Intent(applicationContext, Cache::class.java)
                intent.putExtra("entrepriseCache",entreprise)
                startActivity(intent)

            } else {
                val intent = Intent(applicationContext, EntrepriseActivity::class.java)
                intent.putExtra("entreprise",entreprise)
                startActivity(intent)
                entrepriseAdd.insert(entreprise)
            }


            }
        }
 }
