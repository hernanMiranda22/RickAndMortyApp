package com.example.rickandmortyapp.detailscreen.domain

import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.detailscreen.data.network.GetEpisodesByCharacterRepository
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import javax.inject.Inject

class GetEpisodeByCharacterUseCase @Inject constructor(private val getEpisodesByCharacterRepository: GetEpisodesByCharacterRepository) {

    suspend fun getEpisodeByCharacter(url : String) : Resource<EpisodeModelUI> = getEpisodesByCharacterRepository.listEpisodes(url)

}