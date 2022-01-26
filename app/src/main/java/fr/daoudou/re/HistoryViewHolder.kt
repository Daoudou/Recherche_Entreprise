package fr.daoudou.re

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryViewHolder(row: View) : RecyclerView.ViewHolder(row) {

        val textName = row.findViewById<TextView>(R.id.textViewListName)
        val textSiret = row.findViewById<TextView>(R.id.textViewListSiret)
        val textSiren = row.findViewById<TextView>(R.id.textViewListSiren)
        val textLibelleVoie = row.findViewById<TextView>(R.id.textViewListLibelleVoie)
        val textDepartement = row.findViewById<TextView>(R.id.textViewListDepartement)
        val textCodePostale = row.findViewById<TextView>(R.id.textViewListCodePostale)
        val textActivite = row.findViewById<TextView>(R.id.textViewListLibelleActivite)
        val textDate = row.findViewById<TextView>(R.id.textViewListDate)
        val textAdresse = row.findViewById<TextView>(R.id.textViewListAdresse)
}