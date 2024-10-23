package com.example.rickandmortyapp.detailscreen.data.network

import com.example.rickandmortyapp.common.toEpisodeUI
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.core.map
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import javax.inject.Inject

class GetEpisodesByCharacterRepository @Inject constructor(private val getEpisodesByCharacterService: GetEpisodesByCharacterService) {
    suspend fun listEpisodes(url : String) : Resource<EpisodeModelUI> =
        getEpisodesByCharacterService.getEpisodeByCharacter(url).map {
            it?.toEpisodeUI() ?: EpisodeModelUI("","","")
        }
}