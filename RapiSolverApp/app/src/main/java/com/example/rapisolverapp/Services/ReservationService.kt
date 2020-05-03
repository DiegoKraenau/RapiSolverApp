package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Reservation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ReservationService {
    @POST("reservations")
    @Headers( "Content-Type: application/json;charset=UTF-8")
    fun postReservation(@Body reservation: Reservation): Call<Any>

}