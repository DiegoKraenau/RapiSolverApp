package com.example.rapisolverapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Adapters.OnServiceDetailClickListener
import com.example.rapisolverapp.Adapters.ServiceAdapter
import com.example.rapisolverapp.Adapters.ServiceDetailAdapter
import com.example.rapisolverapp.Models.Recomendation
import com.example.rapisolverapp.Models.Service
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.RecomendationService
import com.example.rapisolverapp.Services.ServiceService
import kotlinx.android.synthetic.main.fragment_perfil_proveedor.*
import kotlinx.android.synthetic.main.fragment_perfil_proveedor.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 */
class PerfilProveedorFragment : Fragment(), OnServiceDetailClickListener {
    override fun onItemClick(serviceDeatil: ServiceDetail, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        var serviciosProveedor=ArrayList<Service>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista:View
        vista=inflater.inflate(R.layout.fragment_perfil_proveedor, container, false)


        vista.btnRecomendaciones.setOnClickListener {
            //Toast.makeText(context,"AEA",Toast.LENGTH_SHORT).show()
            val someFragment = RecomendacionesProveedorFragment() //INSTANCIA DEL OTRO FRAGMENT

            val retrofit = Retrofit.Builder()
                .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val recomendationService: RecomendationService

            recomendationService=retrofit.create(RecomendationService::class.java)

            val request=recomendationService.getRecomendationsBySupplierId(LogueoActivity.OneServiceDetail.supplierId)

            request.enqueue(object :Callback<ArrayList<Recomendation>>{
                override fun onFailure(call: Call<ArrayList<Recomendation>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<ArrayList<Recomendation>>,
                    response: Response<ArrayList<Recomendation>>
                ) {
                    if(response.isSuccessful){
                        LogueoActivity.RecomendationsSupplier=response.body()!!

                        //CAMBIO DE FRAGMENT


                        val bundle=Bundle()

                        val transaction = fragmentManager!!.beginTransaction()
                        transaction.replace(R.id.frame_layout,someFragment)
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }
                }

            })




        }

        vista.lblNombreProveedor2.text = LogueoActivity.OneServiceDetail.name + " " + LogueoActivity.OneServiceDetail.lastName
        vista.lblC.text = LogueoActivity.OneServiceDetail.email
        vista.lblT.text = LogueoActivity.OneServiceDetail.phone




        var serviceAdapter = ServiceAdapter(LogueoActivity.ServiciosProvedores, this)
        vista.rvServiciosProvedor.adapter = serviceAdapter
        vista.rvServiciosProvedor.layoutManager = LinearLayoutManager(this.context)





        return vista
    }

    private fun cargarServiciosDeProveedor() {

    }


}
