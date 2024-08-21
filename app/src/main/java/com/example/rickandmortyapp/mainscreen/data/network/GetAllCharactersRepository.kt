package com.example.rickandmortyapp.mainscreen.data.network

import androidx.paging.PagingData
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersRepository @Inject constructor(private val getAllCharactersService: GetAllCharactersService) {

    fun getAllCharacters() : Flow<PagingData<CharacterModelUI>> = getAllCharactersService.getAllCharacters()
}