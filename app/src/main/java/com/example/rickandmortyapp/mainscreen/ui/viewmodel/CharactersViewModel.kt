package com.example.rickandmortyapp.mainscreen.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.core.map
import com.example.rickandmortyapp.mainscreen.domain.GetAllCharactersUseCase
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
     private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _character : MutableStateFlow<PagingData<CharacterModelUI>> = MutableStateFlow(value = PagingData.empty())

    val character : StateFlow<PagingData<CharacterModelUI>> get() = _character.asStateFlow()

    fun setPagingList(){
        viewModelScope.launch {
            val result = getAllCharactersUseCase.getAllCharacters()

            result.collect { resultPaging ->
                when(resultPaging){
                    is Resource.Error -> _character.update {
                         PagingData.empty()
                    }
                    is Resource.Success -> _character.update {
                        resultPaging.data
                    }
                }
            }
        }
    }


//    val character : Flow<PagingData<CharacterModelUI>> = getAllCharactersUseCase.getAllCharacters()

}