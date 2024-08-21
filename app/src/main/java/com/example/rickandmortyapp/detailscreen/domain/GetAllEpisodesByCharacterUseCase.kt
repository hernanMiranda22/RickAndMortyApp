package com.example.rickandmortyapp.detailscreen.domain

import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class GetAllEpisodesByCharacterUseCase @Inject constructor(private val getEpisodeByCharacterUseCase: GetEpisodeByCharacterUseCase) {

    suspend fun getAllEpisodeByCharacter(urlList : List<String>) : List<EpisodeModelUI?> {

        val listEpisode = mutableListOf<EpisodeModelUI?>()

        urlList.forEach { url ->

            val resultFilms = CoroutineScope(Dispatchers.IO).async {
                listOf(getEpisodeByCharacterUseCase.getEpisodeByCharacter(url))
            }.await()

            listEpisode.addAll(resultFilms)
        }
        return listEpisode
    }
}