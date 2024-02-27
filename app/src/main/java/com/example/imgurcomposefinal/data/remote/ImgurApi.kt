package com.example.imgurcomposefinal.data.remote

import com.example.imgurcomposefinal.data.remote.dto.Data
import com.example.imgurcomposefinal.data.remote.dto.FirstData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurApi {


    @GET("gallery/search/?q=dogs")
    suspend fun getGallery(
        //@Header("Authorization") clientId: String,
    ): FirstData



    companion object{
        const val BASE_URL = "https://api.imgur.com/3/"
    }
}

