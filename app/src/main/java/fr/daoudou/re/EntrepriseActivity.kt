package fr.daoudou.re

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

class EntrepriseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entreprise)
        val entrepriseInformations = intent?.extras?.get("entreprise") as? Entreprise ?: return
        val entrepriseInformationsProgressBar = findViewById<ProgressBar>(R.id.progressBarInformations)
        Thread(Runnable {
            runOnUiThread {
                entrepriseInformationsProgressBar.visibility = View.VISIBLE
            }
            runOnUiThread {
                findViewById<TextView>(R.id.textViewlibelleVoie).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.libelle_de_voie),
                        entrepriseInformations.libelleVoieEntreprise,entrepriseInformations.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewDepartement).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.departement_adresse),
                        entrepriseInformations.departementEntreprise
                    )
                )
            }
        }).start()
    }
}