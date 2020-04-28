package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Recomendation
import retrofit2.Call
import retrofit2.http.*

interface RecomendationService {

    @GET("recommendations/{id}")
    fun getRecomendationsBySupplierId(@Path("id") id: Int):Call<ArrayList<Recomendation>>




}

