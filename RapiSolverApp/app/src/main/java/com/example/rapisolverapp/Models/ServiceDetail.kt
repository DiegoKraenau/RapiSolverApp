package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class ServiceDetail {
    @SerializedName("serviceDetailsId")
    var serviceDetailsId: Int = 0
    @SerializedName("supplierId")
    var supplierId: Int = 0
    @SerializedName("servicioId")
    var servicioId: Int= 0
    @SerializedName("name")
    var name: String = ""
    @SerializedName("lastName")
    var lastName: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("phone")
    var phone: String = ""
    @SerializedName("age")
    var age: String = ""
    @SerializedName("genger")
    var genger: String = ""
    @SerializedName("usuarioId")
    var usuarioId: Int = 0
    @SerializedName("locationId")
    var locationId: Int = 0
    @SerializedName("userName")
    var userName: String = ""
    @SerializedName("country")
    var country: String= ""
    @SerializedName("serviceName")
    var serviceName: String= ""
    @SerializedName("description")
    var description: String= ""
    @SerializedName("cost")
    var cost: String= ""
    @SerializedName("serviceCategoryId")
    var serviceCategoryId: Int = 0
    @SerializedName("categoryName")
    var categoryName: String = ""
}