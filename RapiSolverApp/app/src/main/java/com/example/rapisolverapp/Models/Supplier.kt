package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class Supplier {

    @SerializedName("supplierId")
    var supplierId: Int = 0
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
    var country: String = ""


}