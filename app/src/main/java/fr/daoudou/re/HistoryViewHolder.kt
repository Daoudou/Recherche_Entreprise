package fr.daoudou.re

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryViewHolder(row: View) : RecyclerView.ViewHolder(row) {

        val textName = row.findViewById<TextView>(R.id.textViewHistory )
        val textDate = row.findViewById<TextView>(R.id.textViewHistoryDate)

        }