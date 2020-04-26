package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName


class User (


    @SerializedName("usuarioId")
    var usuarioId:Int,
    @SerializedName("userName")
    var userName:String,
    @SerializedName("userPassword")
    var userPassword:String,
    @SerializedName("rolId")
    var rolId:Int

)




