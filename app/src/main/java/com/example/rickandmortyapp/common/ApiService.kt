package com.example.rickandmortyapp.common

import com.example.rickandmortyapp.mainscreen.data.dto.ResponseDtoWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("character/")
    suspend fun getAllCharacter(@Query("page") page : Int): ResponseDtoWrapper

//    @GET
//    suspend fun getEpisodeByCharacter(@Url url : String): Response<EpisodeModelDto?>
}