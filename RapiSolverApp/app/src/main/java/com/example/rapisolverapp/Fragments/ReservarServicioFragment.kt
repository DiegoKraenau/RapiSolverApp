package com.example.rapisolverapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.Toast
import com.example.rapisolverapp.Activities.LogueoActivity
import com.example.rapisolverapp.Models.Reservation
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.ReservationService
import com.example.rapisolverapp.Services.ServiceDetailService
import kotlinx.android.synthetic.main.fragment_reservar_servicio.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.time.days

/**
 * A simple [Fragment] subclass.
 */
class ReservarServicioFragment : Fragment() {
    companion object{
        var msg = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var vista : View
        vista = inflater.inflate(R.layout.fragment_reservar_servicio, container, false)


        vista.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            //Note that months are indexed from 0. So, 0 means january, 1 means February, 2 means march etc.
            msg = dayOfMonth.toString() + "/" + (month+1) + "/" + year
            Toast.makeText(vista.context, msg, Toast.LENGTH_SHORT).show()

        }



        vista.btnReservar.setOnClickListener {



            val retrofit = Retrofit.Builder()
                .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val reservationService: ReservationService
            reservationService = retrofit.create(ReservationService::class.java)
            var reservation = Reservation()

            val calendarView = vista.calendar






            reservation.fecha = msg
            reservation.note = vista.txt_comentario.text.toString()
            reservation.usuarioId = LogueoActivity.usuarioVisitante.usuarioId
            reservation.servicioId = LogueoActivity.OneServiceDetail.servicioId
            reservation.supplierId = LogueoActivity.OneServiceDetail.supplierId

            val request=reservationService.postReservation(reservation)

            request.enqueue(object : Callback<Any>{
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    if (response.isSuccessful){
                        vista.txt_comentario.text.clear()
                        Toast.makeText(context,"Se agregó exitosamente.", Toast.LENGTH_SHORT).show()
                    }
                }

            })


        }








        return vista
    }


}
