package com.example.rickandmortyapp.detailscreen.data.network

import com.example.rickandmortyapp.common.ApiService
import com.example.rickandmortyapp.detailscreen.data.dto.EpisodeModelDto
import javax.inject.Inject

class GetEpisodesByCharacterService @Inject constructor(private val api : ApiService) {
    suspend fun getEpisodeByCharacter(url: String): EpisodeModelDto? {

        val response = api.getEpisodeByCharacter(url)

        return if (response.isSuccessful) {
            val episodeData = response.body()
            episodeData
        } else {
            null
        }
    }
}