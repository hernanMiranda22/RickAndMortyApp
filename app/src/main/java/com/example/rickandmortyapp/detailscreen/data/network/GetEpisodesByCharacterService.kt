package com.example.rickandmortyapp.detailscreen.data.network

import com.example.rickandmortyapp.common.ApiService
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.detailscreen.data.dto.EpisodeModelDto
import javax.inject.Inject

class GetEpisodesByCharacterService @Inject constructor(private val api : ApiService) {
    suspend fun getEpisodeByCharacter(url: String): Resource<EpisodeModelDto?> =

        try {
            val response = api.getEpisodeByCharacter(url)

            if (response.isSuccessful) {
                val episodeData = response.body()
                Resource.Success(episodeData)
            } else {
                Resource.Success(null)
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
}