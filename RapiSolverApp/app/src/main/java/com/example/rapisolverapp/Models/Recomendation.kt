package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class Recomendation (
    @SerializedName("recommendationId")
    var recommendationId:Int,
    @SerializedName("note")
    var note:String,
    @SerializedName("mark")
    var mark:Int,
    @SerializedName("supplierId")
    var supplierId:Int,
    @SerializedName("nameSupllier")
    var nameSupllier:String,
    @SerializedName("lastNameSupllier")
    var lastNameSupllier:String,
    @SerializedName("emailSupllier")
    var emailSupllier:String,
    @SerializedName("usuarioId")
    var usuarioId:Int,
    @SerializedName("userName")
    var userName:String
)