package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Customer
import com.example.rapisolverapp.Models.ServiceDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomerService {

    @GET("servicedetails")
    fun getCustomers(@Query("format") format: String): Call<ArrayList<Customer>>
}