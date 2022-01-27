package fr.daoudou.re

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cache : AppCompatActivity() {

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.cache)

        val entrepriseInformations = intent?.extras?.get("entrepriseCache") as? Entreprise ?: return

        val db = EntrepriseDatabase.getDatabase(this)

        val entreAdd = db.entrepriseDao()
        val recyclerViewHistory = findViewById<RecyclerView>(R.id.recyclerViewHistory)

        recyclerViewHistory.layoutManager = LinearLayoutManager(this)
        recyclerViewHistory.adapter = CacheEntrepriseAdapter(this,entreAdd)

        (recyclerViewHistory.adapter as CacheEntrepriseAdapter).notifyDataSetChanged()

    }

}