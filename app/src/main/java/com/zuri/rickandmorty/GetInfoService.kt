package com.zuri.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface GetInfoService {
    @get:GET("/api/character")
    val allRickAndMortyData: Call<Response?>?
}