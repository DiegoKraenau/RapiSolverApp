package com.example.rapisolverapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Adapters.RecomendationAdapter
import com.example.rapisolverapp.Adapters.ServiceAdapter
import com.example.rapisolverapp.Models.Recomendation
import com.example.rapisolverapp.Models.Service
import com.example.rapisolverapp.R
import kotlinx.android.synthetic.main.fragment_recomendaciones_proveedor.*
import kotlinx.android.synthetic.main.fragment_recomendaciones_proveedor.view.*

/**
 * A simple [Fragment] subclass.
 */
class RecomendacionesProveedorFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista:View
        vista=inflater.inflate(R.layout.fragment_recomendaciones_proveedor, container, false)


        vista.btnRecomendaciones.setOnClickListener {

            val someFragment = PerfilProveedorFragment()

            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.frame_layout,someFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        vista.img404.visibility=View.GONE
        vista.lblNoEncontrado.visibility=View.GONE

        if(LogueoActivity.RecomendationsSupplier.size==0){
            vista.img404.visibility=View.VISIBLE
            vista.lblNoEncontrado.visibility=View.VISIBLE

        }else{
            var recomendationAdapter = RecomendationAdapter(LogueoActivity.RecomendationsSupplier)
            vista.rvRecomendations.adapter=recomendationAdapter
            vista.rvRecomendations.layoutManager= LinearLayoutManager(this.context)
        }


        return vista
    }


}
