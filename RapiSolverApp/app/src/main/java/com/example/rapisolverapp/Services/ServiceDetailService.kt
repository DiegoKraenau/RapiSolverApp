package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Recomendation
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import retrofit2.Call
import retrofit2.http.*

interface ServiceDetailService {

    @GET("servicedetails")
    fun getServiceDeatils(@Query("format") format: String): Call<ArrayList<ServiceDetail>>

    @POST("servicedetails")
    @Headers( "Content-Type: application/json;charset=UTF-8")
    fun postRecommendation(@Body servicedetail: ServiceDetail):Call<Any>
}