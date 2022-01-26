package fr.daoudou.re

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

class CacheMain(context: Context) {

    fun getInfoDb(position: Int){

        val db = EntrepriseDatabase.getDatabase(context)
        val entrepriseDB = db.entrepriseDao().getByPosition()
        val entrepriseDbInformations = intent?.extras?.get("entrepriseDB") as? Entreprise ?: return
        val entrepriseDbInformationsProgressBar = findViewById<ProgressBar>(R.id.progressBarCacheInformations)
        Thread(Runnable {
            runOnUiThread {
                entrepriseDbInformationsProgressBar.visibility = View.VISIBLE
            }
            runOnUiThread {
                entrepriseDbInformationsProgressBar.visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textViewSiret).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.Siret),
                        entrepriseDB.siret
                    )
                )
                findViewById<TextView>(R.id.textViewSiren).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.Siren),
                        entrepriseDB.siren
                    )
                )

                findViewById<TextView>(R.id.textViewNameEntreprise).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.nameEntre),
                        entrepriseDB.nameSocial, entrepriseDB.toString()
                    )
                )

                findViewById<TextView>(R.id.textViewlibelleVoie).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.libelle_de_voie),
                        entrepriseDB.libelleVoieEntreprise,entrepriseDB.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewDepartement).setText(
                    String.format(
                        applicationContext.resources.getString(R.string.departement_adresse),
                        entrepriseDB.departementEntreprise
                    )
                )
                findViewById<TextView>(R.id.textViewLibelleActivity).setText(
                    String.format(applicationContext.resources.getString(
                        R.string.libelle_activity),
                        entrepriseDB.libelleActivitePrincipaleEntreprise,entrepriseDB.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewDateCreation).setText(
                    String.format(applicationContext.resources.getString(
                        R.string.date_de_creation_entreprise),
                        entrepriseDB.dateCreationEntreprise, entrepriseDB.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewAdresse).setText(
                    String.format(applicationContext.resources.getString(R.string.adresse_entreprise),
                        entrepriseDB.adresseEntreprise, entrepriseDB.toString()
                    )
                )
                findViewById<TextView>(R.id.textViewCodePostal).setText(
                    String.format(applicationContext.resources.getString(R.string.code_postale),
                        entrepriseDB.codePostaleEntreprise
                    )
                )
            }
        }).start()

    }


}