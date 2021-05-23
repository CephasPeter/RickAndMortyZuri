package com.zuri.rickandmorty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zuri.rickandmorty.DataRecycleView.CustomViewHolder

internal class DataRecycleView(private val context: Context, private val dataList: List<Model?>?) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.model, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val model = dataList?.get(position)
        if (model != null) {
            Glide.with(context).load(model.image).into(holder.image)
        }
        if (model != null) {
            holder.name.text = model.name
        }
        if (model != null) {
            holder.specie.text = model.specie
        }
        if (model != null) {
            holder.status.text = model.status
        }
    }

    override fun getItemCount(): Int {
        if (dataList != null) {
            return dataList.size
        }
        return 0
    }

    internal inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var specie: TextView = itemView.findViewById(R.id.specie)
        var status: TextView = itemView.findViewById(R.id.status)
        var image: ImageView = itemView.findViewById(R.id.image)
    }
}