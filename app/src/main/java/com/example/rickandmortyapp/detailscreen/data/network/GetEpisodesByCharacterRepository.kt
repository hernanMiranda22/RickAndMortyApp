package com.example.rickandmortyapp.detailscreen.data.network

import com.example.rickandmortyapp.common.toEpisodeUI
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import javax.inject.Inject

class GetEpisodesByCharacterRepository @Inject constructor(private val getEpisodesByCharacterService: GetEpisodesByCharacterService) {
    suspend fun listEpisodes(url : String) : EpisodeModelUI? = getEpisodesByCharacterService.getEpisodeByCharacter(url)?.toEpisodeUI()
}