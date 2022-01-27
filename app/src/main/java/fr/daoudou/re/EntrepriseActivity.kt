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

                entrepriseInformationsProgressBar.visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textViewSiret).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.Siret),
                        entrepriseInformations.siret
                    )
                )
                findViewById<TextView>(R.id.textViewSiren).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.Siren),
                        entrepriseInformations.siren
                    )
                )

                findViewById<TextView>(R.id.textViewNameEntreprise).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.nameEntre),
                        entrepriseInformations.nameSocial, entrepriseInformations.toString()
                    )
                )

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
                findViewById<TextView>(R.id.textViewLibelleActivity).setText(
                    String.format(applicationContext.resources.getString(
                        R.string.libelle_activity),
                        entrepriseInformations.libelleActivitePrincipaleEntreprise,entrepriseInformations.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewDateCreation).setText(
                    String.format(applicationContext.resources.getString(
                        R.string.date_de_creation_entreprise),
                    entrepriseInformations.dateCreationEntreprise, entrepriseInformations.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewAdresse).setText(
                    String.format(applicationContext.resources.getString(R.string.adresse_entreprise),
                        entrepriseInformations.adresseEntreprise, entrepriseInformations.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewCodePostal).setText(
                    String.format(applicationContext.resources.getString(R.string.code_postale),
                        entrepriseInformations.codePostaleEntreprise
                    )
                )
            }
        }).start()

    }
}