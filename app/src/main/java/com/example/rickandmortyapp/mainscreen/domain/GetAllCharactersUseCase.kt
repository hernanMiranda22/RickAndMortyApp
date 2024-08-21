package com.example.rickandmortyapp.mainscreen.domain

import androidx.paging.PagingData
import com.example.rickandmortyapp.mainscreen.data.network.GetAllCharactersRepository
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val getAllCharactersRepository: GetAllCharactersRepository) {
    fun getAllCharacters() : Flow<PagingData<CharacterModelUI>> = getAllCharactersRepository.getAllCharacters()
}