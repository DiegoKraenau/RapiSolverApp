package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Customer
import com.example.rapisolverapp.Models.ServiceDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CustomerService {

    @GET("customers")
    fun getCustomers(@Query("format") format: String): Call<ArrayList<Customer>>

    @GET("customers/{id}")
    fun getCustomerById(@Path("id") id: Int): Call<Customer>

    @GET("customers/{id}")
    fun getCustomerbyUserId(@Path("id") id: Int): Call<ArrayList<Customer>>
}