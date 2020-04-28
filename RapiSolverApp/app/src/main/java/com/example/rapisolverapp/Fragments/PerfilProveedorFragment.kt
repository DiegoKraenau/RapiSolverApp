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
import com.example.rapisolverapp.Models.Service
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.ServiceService
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

        /*
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


         */
        vista.lblNombreProveedor2.text = LogueoActivity.OneServiceDetail.name + " " + LogueoActivity.OneServiceDetail.lastName
        vista.lblC.text = LogueoActivity.OneServiceDetail.email
        vista.lblT.text = LogueoActivity.OneServiceDetail.phone

        //val serviceService: ServiceService

        //serviceService=retrofit.create(ServiceService::class.java)

        //val request=serviceService.getServiciosByUserId(LogueoActivity.OneServiceDetail.usuarioId)
        /*
        request.enqueue(object : Callback<ArrayList<Service>>{
            override fun onFailure(call: Call<ArrayList<Service>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ArrayList<Service>>,
                response: Response<ArrayList<Service>>
            ) {
                if (response.isSuccessful) {
                    serviciosProveedor=response.body()!!
                    //Toast.makeText(context, serviciosProveedor.size.toString(),Toast.LENGTH_SHORT).show()

                }
            }

        })

         */


            var serviceAdapter = ServiceAdapter(LogueoActivity.ServiciosProvedores, this)
            vista.rvServiciosProvedor.adapter = serviceAdapter
            vista.rvServiciosProvedor.layoutManager = LinearLayoutManager(this.context)




        return vista
    }

    private fun cargarServiciosDeProveedor() {

    }


}
