package fr.daoudou.re

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView


class CacheEntrepriseAdapter(val context: Context,
                            private val entrepriseDAO: EntrepriseDAO) : RecyclerView.Adapter<CacheEntrepriseViewHolder>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CacheEntrepriseViewHolder {
        return CacheEntrepriseViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_cache,parent,false))
    }

    override fun onBindViewHolder(holder: CacheEntrepriseViewHolder, position: Int) {

        val cache = entrepriseDAO.getByPosition(position)
        holder.textNameCache.setText(String.format("Nom : %s", cache.nameSocial))

    }

    override fun getItemCount(): Int {
       return entrepriseDAO.getCount()
    }


}