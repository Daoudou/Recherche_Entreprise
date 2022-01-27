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

    }


    override fun getItemCount(): Int {
        return entrepriseDAO.getCount()
    }


}