package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Cliente
import com.example.rapisolverapp.Models.Recomendation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*

interface RecomendationService {

    @GET("recommendations/{id}")
    fun getRecomendationsBySupplierId(@Path("id") id: Int):Call<ArrayList<Recomendation>>




    @POST("recommendations")
    @Headers( "Content-Type: application/json;charset=UTF-8")
    fun postRecommendation(@Body recomendation: Recomendation):Call<Any>



}

