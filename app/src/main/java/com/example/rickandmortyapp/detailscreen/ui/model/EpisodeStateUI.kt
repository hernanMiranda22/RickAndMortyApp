package com.example.rickandmortyapp.detailscreen.ui.model

sealed interface EpisodeStateUI {
    data object Loading : EpisodeStateUI
    data class Success(val listEpisode : List<EpisodeModelUI?>):EpisodeStateUI
    data class Error(val error : Throwable):EpisodeStateUI
}