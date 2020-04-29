package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class Customer (
    @SerializedName("customerId")
    var customerId: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("lastname")
    var lastname: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("age")
    var age: Int,
    @SerializedName("genger")
    var genger: String,
    @SerializedName("usuarioId")
    var usuarioId: Int,
    @SerializedName("locationId")
    var locationId: Int,
    @SerializedName("userName")
    var userName: String,
    @SerializedName("country")
    var country: String

)