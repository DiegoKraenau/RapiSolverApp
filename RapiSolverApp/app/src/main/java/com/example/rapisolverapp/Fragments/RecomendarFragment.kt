package com.example.rapisolverapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Cliente
import com.example.rapisolverapp.Models.Recomendation
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.RecomendationService
import com.example.rapisolverapp.Services.ServiceService
import kotlinx.android.synthetic.main.fragment_recomendar.*
import kotlinx.android.synthetic.main.fragment_recomendar.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.OkHttpClient





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RecomendarFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RecomendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecomendarFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var vista:View
        vista=inflater.inflate(R.layout.fragment_recomendar, container, false)




        var puntaje: Int=0

        vista.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            puntaje=rating.toInt()
            //Toast.makeText(context,rating.toString(),Toast.LENGTH_SHORT).show()
        }

        vista.agregarRecomendacion.setOnClickListener {
            if(puntaje!=0){

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


                val recomendationService: RecomendationService

                recomendationService=retrofit.create(RecomendationService::class.java)

                var recomendation=Recomendation()
                recomendation.usuarioId=LogueoActivity.usuarioVisitante.usuarioId
                recomendation.supplierId=LogueoActivity.OneServiceDetail.supplierId
                recomendation.note=txtComentario.text.toString()
                recomendation.mark=puntaje


                val request=recomendationService.postRecommendation(recomendation)

                request.enqueue(object : Callback<Any>{
                    override fun onFailure(call: Call<Any>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        Toast.makeText(context,"Tiempo de espera insuficiente.",Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        if(response.isSuccessful){
                        txtComentario.text.clear()
                        Toast.makeText(context,"Se agregó exitosamente.",Toast.LENGTH_SHORT).show()
                        }
                    }

                })


            }else{
                Toast.makeText(context,"Debe ingresar el puntaje",Toast.LENGTH_SHORT).show()
            }
        }




        return vista
    }


}
