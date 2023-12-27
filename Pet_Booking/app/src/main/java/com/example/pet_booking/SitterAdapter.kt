package com.example.pet_booking

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sitter.view.*

class SitterAdapter: RecyclerView.Adapter<SitterAdapter.SitterViewHolder> (){

    private var sitterList = emptyList<SitterModel>()

    class SitterViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SitterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sitter, parent, false)
        return SitterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sitterList.size
    }

    override fun onBindViewHolder(holder: SitterViewHolder, position: Int) {
        holder.itemView.name_sitter.text = sitterList[position].sitterName
        holder.itemView.location_sitter.text = sitterList[position].locationSitter
        holder.itemView.textView2.text = sitterList[position].jobSitter
        holder.itemView.estimation_sitter.text = sitterList[position].estimationSitter
        holder.itemView.price_sitter.text = sitterList[position].priceSitter

    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<SitterModel>){
        sitterList = list
        notifyDataSetChanged()
    }
}