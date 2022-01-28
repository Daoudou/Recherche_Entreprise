package fr.daoudou.re

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class HistoryAdapter (val context: Context,
                      private val historyDAO: HistoryDAO
                      ) : RecyclerView.Adapter<HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.listrow,parent,false))
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        val hisotry = historyDAO.getByPosition(position)

        holder.textName.text = hisotry.search
        //holder.textDate.text = SimpleDateFormat("dd/MM/yyy").format(cacheRequete.dateRequete).toString()

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())
        holder.textDate.setText(String.format(currentDate))


    }


    override fun getItemCount(): Int {
        return historyDAO.getCount()
    }


}