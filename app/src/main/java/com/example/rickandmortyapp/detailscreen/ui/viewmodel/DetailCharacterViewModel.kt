package com.example.rickandmortyapp.detailscreen.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.detailscreen.domain.GetAllEpisodesByCharacterUseCase
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeStateUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailCharacterViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesByCharacterUseCase
) : ViewModel() {

    private val _listEpisodes = MutableStateFlow<EpisodeStateUI>(
        EpisodeStateUI.Loading
    )
    val listEpisodes : StateFlow<EpisodeStateUI> get() = _listEpisodes.asStateFlow()

    fun getListEpisode(url: List<String>){
        viewModelScope.launch {
            when(val result = getAllEpisodesUseCase.getAllEpisodeByCharacter(url)){
                is Resource.Error -> _listEpisodes.update{
                    EpisodeStateUI.Error(result.exception)
                }
                is Resource.Success -> _listEpisodes.update {
                    EpisodeStateUI.Success(result.data)
                }
            }

        }
    }
}