package com.example.rickandmortyapp.detailscreen.domain

import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.core.map
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class GetAllEpisodesByCharacterUseCase @Inject constructor(private val getEpisodeByCharacterUseCase: GetEpisodeByCharacterUseCase) {

    suspend fun getAllEpisodeByCharacter(urlList : List<String>) : Resource<List<EpisodeModelUI?>> {

            val listEpisode = mutableListOf<EpisodeModelUI?>()

            urlList.forEach {url ->

                when(val result = getEpisodeByCharacterUseCase.getEpisodeByCharacter(url)){
                    is Resource.Error -> {
                        return Resource.Error(result.exception)
                    }
                    is Resource.Success -> {
                        listEpisode.add(result.data)
                    }
                }
            }
        return Resource.Success(listEpisode)
    }
}