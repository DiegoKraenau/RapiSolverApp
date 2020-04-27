package com.example.rapisolverapp.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Adapters.OnServiceDetailClickListener
import com.example.rapisolverapp.Adapters.ServiceDetailAdapter
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.ServiceDetailService
import com.example.rapisolverapp.Services.UserService
import kotlinx.android.synthetic.main.fragment_buscar_servicio.*
import kotlinx.android.synthetic.main.fragment_buscar_servicio.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class BuscarServicioFragment : Fragment(),OnServiceDetailClickListener {
    override fun onItemClick(serviceDeatils: ServiceDetail, position: Int) {
        Toast.makeText(context,serviceDeatils.serviceName,Toast.LENGTH_SHORT).show()
    }

    var serviceDetailAdapter = ServiceDetailAdapter(LogueoActivity.listaServiceDeatil,this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista:View




        vista=inflater.inflate(R.layout.fragment_buscar_servicio, container, false)

        vista.lblNoEncontrado.visibility=View.GONE


        vista.rvServicios.adapter =serviceDetailAdapter
        vista.rvServicios.layoutManager = LinearLayoutManager(this.context)

        vista.btnBuscar.setOnClickListener {
            var busqueda=lblBusqueda.text.toString().toLowerCase()
            if(lblBusqueda.text.isEmpty()){
                vista.lblNoEncontrado.visibility=View.GONE
                var serviceDetailAdapter = ServiceDetailAdapter(LogueoActivity.listaServiceDeatil,this)
                vista.rvServicios.adapter =serviceDetailAdapter
                vista.rvServicios.layoutManager = LinearLayoutManager(this.context)
            }
            else{
                var resultado=ArrayList<ServiceDetail>()
                for(serviceDetail in LogueoActivity.listaServiceDeatil){
                    if(serviceDetail.serviceName.toLowerCase()==busqueda){
                        resultado.add(serviceDetail)
                    }
                }

                if(resultado.size==0){
                    vista.lblNoEncontrado.visibility=View.VISIBLE
                }

                var sda = ServiceDetailAdapter(resultado,this)
                vista.rvServicios.adapter =sda
                vista.rvServicios.layoutManager = LinearLayoutManager(this.context)
            }
        }

        return vista


    }




}
