package com.example.penjualan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.itempenjualan_layout.*

class MyAdapter(private val barangList : ArrayList<Barang>) :
    RecyclerView.Adapter<MyAdapter.myViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itempenjualan_layout,
        parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentItem = barangList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading


    }

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading  : TextView = itemView.findViewById(R.id.tvHeading)
        val tvHargaBarang:TextView = itemView.findViewById(R.id.tvHargaBarang)
    }

    override fun getItemCount(): Int {
        return barangList.size
    }
}