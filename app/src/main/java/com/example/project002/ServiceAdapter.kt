package com.example.project002

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project002.databinding.ItemServiceBinding

class ServiceAdapter(var list: List<ServiceModel>):RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    var listener: OnServiceClickListener?=null

    class ViewHolder(val view:ItemServiceBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        return ViewHolder(ItemServiceBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=list[position]
        holder.view.itemServiceTitleGene.text=item.title
        holder.view.itemServiceDescription.text=item.description
        holder.view.itemServiceIco.setImageResource(item.icon.toInt())
        holder.view.root.setOnClickListener {
            listener?.onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}