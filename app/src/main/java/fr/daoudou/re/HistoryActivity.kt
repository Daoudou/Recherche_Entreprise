package fr.daoudou.re

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entreprise_informations)

        val db = EntrepriseDatabase.getDatabase(this)

        val entreAdd = db.entrepriseDao()
        val recyclerViewHistory = findViewById<RecyclerView>(R.id.recyclerViewHistory)

        recyclerViewHistory.layoutManager = LinearLayoutManager(this)
        recyclerViewHistory.adapter = HistoryAdapter(this,entreAdd)

        (recyclerViewHistory.adapter as HistoryAdapter).notifyDataSetChanged()

    }

}