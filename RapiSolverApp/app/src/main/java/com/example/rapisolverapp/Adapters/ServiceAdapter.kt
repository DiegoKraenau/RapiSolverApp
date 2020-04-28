package com.example.rapisolverapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rapisolverapp.Models.Service
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.R
import kotlinx.android.synthetic.main.prototype_servicio.view.*

class ServiceAdapter(var serviciosProvedor: ArrayList<Service> ,var clickListener: OnServiceDetailClickListener): RecyclerView.Adapter<ServicioPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_servicio, parent, false)

        return ServicioPrototype(view)
    }

    override fun getItemCount(): Int {
        return serviciosProvedor.size
    }

    override fun onBindViewHolder(holder: ServicioPrototype, position: Int) {
        // holder.bind(serviceDeatils.get(position))
        holder.initialize(serviciosProvedor.get(position),clickListener)
    }


}

class ServicioPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nombreServicio = itemView.nombreServicio
    val nombreCategory = itemView.nombreCategoria
    val costoMonto=itemView.costoMonto

    fun bind(serviceDeatil: ServiceDetail) {
        nombreServicio.text = serviceDeatil.serviceName
        nombreCategory.text = serviceDeatil.categoryName
        costoMonto.text=serviceDeatil.cost
    }

    fun initialize(service:Service,action: OnServiceDetailClickListener){
        nombreServicio.text=service.name
        nombreCategory.text=service.categoryName
        costoMonto.text=service.cost
        /*
        itemView.setOnClickListener {
            action.onItemClick(service,adapterPosition)
        }

         */
    }
}