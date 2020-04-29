package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceService {

    var userId:Int
    @GET("rapiservices/user/{id}")
    fun getServiciosByUserId(@Path("id") id: Int): Call<ArrayList<Service>>




}