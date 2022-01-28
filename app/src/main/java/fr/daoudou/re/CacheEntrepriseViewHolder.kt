package fr.daoudou.re

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CacheEntrepriseViewHolder(row: View) :RecyclerView.ViewHolder(row) {

    val textNameCache = row.findViewById<TextView>(R.id.textViewNameCacheEntreprise)
    //val textSiretCache = row.findViewById<TextView>(R.id.textViewListSiret)
    //val textSirenCache = row.findViewById<TextView>(R.id.textViewListSiren)
    val textLibelleVoieCache = row.findViewById<TextView>(R.id.textViewCachelibelleVoie)
    val textDepartementCache = row.findViewById<TextView>(R.id.textViewCacheDepartement)
    val textCodePostaleCache = row.findViewById<TextView>(R.id.textViewCacheCodePostal)
    //val textActiviteCache = row.findViewById<TextView>(R.id.textViewListLibelleActivite)
    val textDateCache = row.findViewById<TextView>(R.id.textViewCacheDateCreation)
    val textAdresseCache = row.findViewById<TextView>(R.id.textViewCacheAdresse)


}