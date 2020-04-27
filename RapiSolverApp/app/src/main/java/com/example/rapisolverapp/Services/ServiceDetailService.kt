package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceDetailService {

    @GET("servicedetails")
    fun getServiceDeatils(@Query("format") format: String): Call<ArrayList<ServiceDetail>>
}