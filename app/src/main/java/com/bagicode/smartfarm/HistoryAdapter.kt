package com.bagicode.smartfarm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val historyList: ArrayList<History>) :
    RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.history_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = historyList[position]
        holder.tvriwWaktu.text = currentItem.waktu
        holder.tvriwSuhu.text = currentItem.temp
        holder.tvriwketSuhu.text = currentItem.ketSuhu
        holder.tvriwPh.text = currentItem.PH
        holder.tvriwketPh.text = currentItem.ketPH
        holder.tvriwKeruh.text = currentItem.keruh
        holder.tvriwketKeruh.text = currentItem.ketKeruh
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val tvriwWaktu : TextView = itemView.findViewById(R.id.tv_waktu)
        val tvriwSuhu : TextView = itemView.findViewById(R.id.tv_riwSuhu)
        val tvriwketSuhu : TextView = itemView.findViewById(R.id.tv_riwketSuhu)
        val tvriwPh: TextView = itemView.findViewById(R.id.tv_riwPh)
        val tvriwketPh : TextView = itemView.findViewById(R.id.tv_riwketPh)
        val tvriwKeruh : TextView = itemView.findViewById(R.id.tv_riwKeruh)
        val tvriwketKeruh : TextView = itemView.findViewById(R.id.tv_riwketKeruh)


    }
}