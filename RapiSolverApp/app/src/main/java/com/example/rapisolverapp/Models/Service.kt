package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class Service (
    @SerializedName("servicioId")
    var servicioId:Int,
    @SerializedName("name")
    var name:String,
    @SerializedName("description")
    var description:String,
    @SerializedName("cost")
    var cost:String,
    @SerializedName("serviceCategoryId")
    var serviceCategoryId:String,
    @SerializedName("categoryName")
    var categoryName:String
)