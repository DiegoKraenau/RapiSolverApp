package com.example.rapisolverapp.Models

import com.google.gson.annotations.SerializedName

class ServiceCategorie {
    @SerializedName("serviceCategoryId")
    var serviceCategoryId : Int = 0
    @SerializedName("categoryName")
    var categoryName : String = ""
    @SerializedName("categoryDescription")
    var categoryDescription : String = ""
   // @SerializedName("servicios")
    //var servicios : List<Service> = TODO()

}