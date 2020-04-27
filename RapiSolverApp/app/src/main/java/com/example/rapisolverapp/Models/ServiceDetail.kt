package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class ServiceDetail (
    @SerializedName("serviceDetailsId")
    var serviceDetailsId:Int,
    @SerializedName("supplierId")
    var supplierId:Int,
    @SerializedName("servicioId")
    var servicioId:Int,
    @SerializedName("name")
    var name:String,
    @SerializedName("lastName")
    var lastName:String,
    @SerializedName("email")
    var email:String,
    @SerializedName("phone")
    var phone:String,
    @SerializedName("age")
    var age:String,
    @SerializedName("genger")
    var genger:String,
    @SerializedName("usuarioId")
    var usuarioId:Int,
    @SerializedName("locationId")
    var locationId:Int,
    @SerializedName("userName")
    var userName:String,
    @SerializedName("country")
    var country:String,
    @SerializedName("serviceName")
    var serviceName:String,
    @SerializedName("description")
    var description:String,
    @SerializedName("cost")
    var cost:String,
    @SerializedName("serviceCategoryId")
    var serviceCategoryId:Int,
    @SerializedName("categoryName")
    var categoryName:String
)