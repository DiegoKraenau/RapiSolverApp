package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.ServiceCategorie
import com.example.rapisolverapp.Models.ServiceDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceCategorieService {

    @GET("servicecategories")
    fun getServiceCategories(@Query("format") format: String): Call<ArrayList<ServiceCategorie>>

}