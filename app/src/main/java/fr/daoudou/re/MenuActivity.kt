package fr.daoudou.re

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.buttonSearchMenu).setOnClickListener {

            AlertDialog.Builder(this).apply {
                setMessage("Chargement de la page de recherche")
            }.create().show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonHistoryMenu).setOnClickListener {

            AlertDialog.Builder(this).apply {
                setMessage("Chargement de l'historique")
            }.create().show()
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}