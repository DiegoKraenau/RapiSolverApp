package com.example.rapisolverapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rapisolverapp.Models.Recomendation
import com.example.rapisolverapp.Models.Service
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.R
import kotlinx.android.synthetic.main.prototype_recomendation.view.*


class RecomendationAdapter (var recomendationsSuppliert: ArrayList<Recomendation>): RecyclerView.Adapter<RecomendationPrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendationPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_recomendation, parent, false)

        return RecomendationPrototype(view)
    }

    override fun getItemCount(): Int {
        return recomendationsSuppliert.size
    }

    override fun onBindViewHolder(holder: RecomendationPrototype, position: Int) {
        holder.bind(recomendationsSuppliert.get(position))
    }


}


class RecomendationPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nombreUsuario = itemView.txtUsuario
    val puntaje = itemView.txtPuntaje
    val comentario=itemView.txtComentario

    fun bind(recomendation: Recomendation) {
        nombreUsuario.text = recomendation.userName
        puntaje.text = recomendation.mark.toString()
        comentario.text=recomendation.note
    }


}