package com.zuri.rickandmorty

import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("results")
    var list: List<Model>? = null
}