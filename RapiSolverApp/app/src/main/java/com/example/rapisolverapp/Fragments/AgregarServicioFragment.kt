package com.example.rapisolverapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Activities.LogueoActivity.Companion.categoryList
import com.example.rapisolverapp.Models.ServiceCategorie
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.ServiceDetailService
import com.example.rapisolverapp.Services.ServiceService
import kotlinx.android.synthetic.main.fragment_agregar_servicio.*
import kotlinx.android.synthetic.main.fragment_agregar_servicio.view.*
import kotlinx.android.synthetic.main.fragment_buscar_servicio.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class AgregarServicioFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val vista: View
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_agregar_servicio, container, false)

        var categoryListNames = ArrayList<String>()
        for (item in categoryList) {
            categoryListNames.add(item.categoryName)
        }

        vista.spinnerSeCategory.adapter = ArrayAdapter<String>(
            vista.context,
            android.R.layout.simple_dropdown_item_1line,
            categoryListNames
        )

        vista.agregarServicio.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val serviceDetailService: ServiceDetailService

            serviceDetailService = retrofit.create(ServiceDetailService::class.java)
            var serviceDetail = ServiceDetail()
            serviceDetail.serviceName = vista.txt_nombreservicio.text.toString()
            serviceDetail.categoryName = vista.spinnerSeCategory.selectedItem.toString()
            serviceDetail.description = vista.txt_descripservicio.text.toString()
            serviceDetail.cost = vista.txt_costoservicio.text.toString()
            serviceDetail.supplierId = LogueoActivity.suppliervisitante[0].supplierId

            val request = serviceDetailService.postService(serviceDetail)

            request.enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Se agregó exitosamente.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            })
        }
        return vista
    }


}
