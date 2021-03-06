package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class Recomendation {
    @SerializedName("recommendationId")
    var recommendationId: Int=0
    @SerializedName("note")
    var note: String=""
    @SerializedName("mark")
    var mark: Int=0
    @SerializedName("supplierId")
    var supplierId: Int=0
    @SerializedName("nameSupllier")
    var nameSupllier: String=""
    @SerializedName("lastNameSupllier")
    var lastNameSupllier: String=""
    @SerializedName("emailSupllier")
    var emailSupllier: String=""
    @SerializedName("usuarioId")
    var usuarioId: Int=0
    @SerializedName("userName")
    var userName: String=""
}