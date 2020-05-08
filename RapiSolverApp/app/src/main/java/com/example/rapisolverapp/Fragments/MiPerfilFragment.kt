package com.example.rapisolverapp.Fragments


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Activities.PantallaPrincipal
import com.example.rapisolverapp.Models.Customer
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.CustomerService
import kotlinx.android.synthetic.main.fragment_mi_perfil.*
import kotlinx.android.synthetic.main.fragment_mi_perfil.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class MiPerfilFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_mi_perfil, container, false)

        if (LogueoActivity.usuarioVisitante.rolId == 1){
            vista.tvNombreUsuario.text = LogueoActivity.custumervisitante[0].name + " " + LogueoActivity.custumervisitante[0].lastname
            vista.tvUbicacion.text = LogueoActivity.custumervisitante[0].country
            vista.tvTelefono.text = LogueoActivity.custumervisitante[0].phone
            vista.tvCorreo.text = LogueoActivity.custumervisitante[0].email
        }else if (LogueoActivity.usuarioVisitante.rolId == 2){
            vista.tvNombreUsuario.text = LogueoActivity.suppliervisitante[0].name + " " + LogueoActivity.suppliervisitante[0].lastName
           vista.tvUbicacion.text = LogueoActivity.suppliervisitante[0].country
            vista.tvTelefono.text = LogueoActivity.suppliervisitante[0].phone
           vista.tvCorreo.text = LogueoActivity.suppliervisitante[0].email
        }

        return vista
    }

    private fun loadCustomerProfile() {

    }
}
