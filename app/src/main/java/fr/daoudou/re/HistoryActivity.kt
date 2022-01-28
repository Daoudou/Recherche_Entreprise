package fr.daoudou.re

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entreprise_historique)

        val db = EntrepriseDatabase.getDatabase(this)

        val entreAdd = db.entrepriseDao()
        val history = db.historyDao()
        val recyclerViewHistory = findViewById<RecyclerView>(R.id.recyclerViewHistory)

        recyclerViewHistory.layoutManager = LinearLayoutManager(this)
        recyclerViewHistory.adapter = HistoryAdapter(this,history)
        (recyclerViewHistory.adapter as HistoryAdapter).notifyDataSetChanged()

        findViewById<Button>(R.id.historyButtonReturn).setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Retour au menu").create().show()
            val intent = Intent(applicationContext, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}