package com.example.rapisolverapp

import com.google.gson.annotations.SerializedName

class Cliente {
    @SerializedName("id")
    var id: Int=0
    @SerializedName("nombre")
    var nombre: String=""
    @SerializedName("apellido")
    var apellido: String=""
}