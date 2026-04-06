package com.example.api.data

import retrofit2.http.GET

interface MarsApi {
    @GET("/photos")
    suspend fun getPhotos() : List<MarsPhoto> //возвращает все фотки из /photos по API
}