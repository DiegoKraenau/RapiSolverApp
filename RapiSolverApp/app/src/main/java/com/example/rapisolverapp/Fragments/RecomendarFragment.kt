package com.example.rapisolverapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.RecomendationService
import kotlinx.android.synthetic.main.fragment_recomendar.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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


            }else{
                Toast.makeText(context,"Debe ingresar el puntaje",Toast.LENGTH_SHORT).show()
            }
        }



        return vista
    }


}
