package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class Reservation {

    @SerializedName("servicioId")
    var servicioId : Int = 0
    @SerializedName("usuarioId")
    var usuarioId : Int = 0
    @SerializedName("supplierId")
    var supplierId : Int = 0
    @SerializedName("fecha")
    var fecha : String = ""
    @SerializedName("note")
    var note : String = ""

}