package com.example.project002.ul.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project002.interfaces.OnServiceClickListener
import com.example.project002.data.models.ServiceModel
import com.example.project002.databinding.ItemServiceBinding

class ServiceAdapter(var list: MutableList<ServiceModel>):RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

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
    
    fun changeDataSet(newList: List<ServiceModel>){
        while (list.size > 0){
            list.removeAt(0)
            notifyItemRemoved(0)
        }
        newList.forEach { 
            this.list.add(it)
            notifyItemInserted(this.list.size - 1)
        }
    }
}