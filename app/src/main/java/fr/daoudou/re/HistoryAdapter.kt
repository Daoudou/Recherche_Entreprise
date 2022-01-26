package fr.daoudou.re

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter (val context: Context,
                      private val entrepriseDAO: EntrepriseDAO
                      ) : RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.listrow,parent,false))
    }


    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        val entre = entrepriseDAO.getByPosition(position)
        holder.textName.setText(String.format("Nom : %s",entre.nameSocial))
        holder.textSiret.setText(String.format("Siret: %d",entre.siret))
        holder.textSiren.setText(String.format("Siren: %d",entre.siren))
        holder.textLibelleVoie.setText(String.format("Libelle de la voie: %s",entre.libelleVoieEntreprise))
        holder.textDepartement.text = entre.departementEntreprise.toString()
        holder.textCodePostale.text = entre.codePostaleEntreprise.toString()
        holder.textActivite.text = entre.libelleActivitePrincipaleEntreprise
        holder.textDate.text = entre.dateCreationEntreprise
        holder.textAdresse.text = entre.adresseEntreprise
    }


    override fun getItemCount(): Int {
        return entrepriseDAO.getCount()
    }


}