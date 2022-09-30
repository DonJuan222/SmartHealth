package com.example.project002.ul.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project002.data.models.DoctorModel
import com.example.project002.databinding.ItemDoctoresBinding
import com.example.project002.interfaces.OnDoctorClickListener


class DoctorAdapter(var list: List<DoctorModel>): RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    private var listener: OnDoctorClickListener? = null

    class ViewHolder(val view: ItemDoctoresBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        return ViewHolder(ItemDoctoresBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.view.itemDoctorTitle.text = item.speciality
        holder.view.nameDoctor.text=item.name
        holder.view.starsText.text=item.caption
        holder.view.starsDoctor.rating = (item.star/ 5.0).toFloat()
        holder.view.itemDoctoresIcon.setImageResource(item.image.toInt())
        holder.view.root.setOnClickListener {
            listener?.onClick(item)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}