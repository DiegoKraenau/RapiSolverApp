package com.example.rapisolverapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.R
import kotlinx.android.synthetic.main.prototype_servicio.view.*

class ServiceDetailAdapter(var serviceDeatils: ArrayList<ServiceDetail>, var clickListener: OnServiceDetailClickListener): RecyclerView.Adapter<ServiceDeatilPrototype>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceDeatilPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_servicio, parent, false)

        return ServiceDeatilPrototype(view)
    }

    override fun getItemCount(): Int {
        return serviceDeatils.size

    }

    override fun onBindViewHolder(holder: ServiceDeatilPrototype, position: Int) {
       // holder.bind(serviceDeatils.get(position))
        holder.initialize(serviceDeatils.get(position),clickListener)
    }
}

class ServiceDeatilPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nombreServicio = itemView.nombreServicio
    val nombreCategory = itemView.nombreCategoria
    val costoMonto=itemView.costoMonto

    fun bind(serviceDeatil: ServiceDetail) {
        nombreServicio.text = serviceDeatil.serviceName
        nombreCategory.text = serviceDeatil.categoryName
        costoMonto.text=serviceDeatil.cost
    }

    fun initialize(serviceDeatil:ServiceDetail,action: OnServiceDetailClickListener){
        nombreServicio.text=serviceDeatil.serviceName
        nombreCategory.text=serviceDeatil.categoryName
        costoMonto.text=serviceDeatil.cost

        itemView.setOnClickListener {
            action.onItemClick(serviceDeatil,adapterPosition)
        }
    }
}

interface OnServiceDetailClickListener{
    fun onItemClick(serviceDeatil: ServiceDetail,position: Int)
}