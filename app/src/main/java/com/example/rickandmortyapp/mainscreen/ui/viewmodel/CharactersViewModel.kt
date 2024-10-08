package com.example.rickandmortyapp.mainscreen.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.rickandmortyapp.mainscreen.domain.GetAllCharactersUseCase
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
     getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    val character : Flow<PagingData<CharacterModelUI>> = getAllCharactersUseCase.getAllCharacters()

}