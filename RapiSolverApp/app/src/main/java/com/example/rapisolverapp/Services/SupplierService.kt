package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.Customer
import com.example.rapisolverapp.Models.Supplier
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SupplierService {

    @GET("suppliers/{id}")
    fun getSupplierbyUserId(@Path("id") id: Int): Call<ArrayList<Supplier>>

    @GET("suppliers")
    fun getSuppliers(@Query("format") format: String): Call<ArrayList<Supplier>>

}