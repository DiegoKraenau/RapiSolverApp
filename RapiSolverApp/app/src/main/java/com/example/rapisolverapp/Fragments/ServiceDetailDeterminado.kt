package com.example.rapisolverapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import com.example.rapisolverapp.R
import kotlinx.android.synthetic.main.fragment_buscar_servicio.view.*
import kotlinx.android.synthetic.main.fragment_service_detail_determinado.*
import kotlinx.android.synthetic.main.fragment_service_detail_determinado.view.*

/**
 * A simple [Fragment] subclass.
 */
class ServiceDetailDeterminado : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var vista:View
        vista=inflater.inflate(R.layout.fragment_service_detail_determinado, container, false)
        vista.lblNombreProveedor.text=LogueoActivity.OneServiceDetail.name+ " "+ LogueoActivity.OneServiceDetail.lastName
        vista.lblNS.text=LogueoActivity.OneServiceDetail.serviceName
        vista.lblNC.text=LogueoActivity.OneServiceDetail.categoryName
        vista.lblC.text=LogueoActivity.OneServiceDetail.cost+ " "+"/S"
        vista.lblD.text=LogueoActivity.OneServiceDetail.description

        vista.lblVerMas.setOnClickListener {
            val someFragment = PerfilProveedorFragment()
            val bundle=Bundle()
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.frame_layout,someFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        vista.btnCalificar.setOnClickListener {
            val someFragment = RecomendarFragment()
            val bundle=Bundle()
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.frame_layout,someFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        vista.btnContactar.setOnClickListener {



            val someFragment = ReservarServicioFragment()

            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.frame_layout,someFragment)
            transaction.addToBackStack(null)
            transaction.commit()


        }







        return vista
    }


}
