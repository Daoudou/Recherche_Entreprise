package fr.daoudou.re

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CateEntrepriseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cate_entreprise)

        val db = EntrepriseDatabase.getDatabase(this)

    }
}