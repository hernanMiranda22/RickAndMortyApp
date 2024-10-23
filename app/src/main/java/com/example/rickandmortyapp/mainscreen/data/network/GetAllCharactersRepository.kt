package com.example.rickandmortyapp.mainscreen.data.network

import androidx.paging.PagingData
import androidx.paging.map
import com.example.rickandmortyapp.common.toCharacterUI
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.core.map
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class GetAllCharactersRepository @Inject constructor(private val getAllCharactersService: GetAllCharactersService) {

    fun getAllCharacters(): Flow<Resource<PagingData<CharacterModelUI>>> =
        getAllCharactersService.getAllCharacters().map { resource ->
            resource.map { pagingData ->
                pagingData.map { it.toCharacterUI() }
            }
        }
}