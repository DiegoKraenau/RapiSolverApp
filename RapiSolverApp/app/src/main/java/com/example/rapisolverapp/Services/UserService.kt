package com.example.rapisolverapp.Services

import com.example.rapisolverapp.Models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("rapiusers")
    fun getUsers(@Query("format") format: String): Call<ArrayList<User>>
}