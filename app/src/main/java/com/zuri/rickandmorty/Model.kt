package com.zuri.rickandmorty

import com.google.gson.annotations.SerializedName

class Model {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("image")
    var image: String? = null

    @SerializedName("species")
    var specie: String? = null
}