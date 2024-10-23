package com.example.rickandmortyapp.mainscreen.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapp.common.ApiService
import com.example.rickandmortyapp.core.Resource
import com.example.rickandmortyapp.mainscreen.data.dto.CharacterModelDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCharactersService @Inject constructor(private val api : ApiService) {
    companion object{
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 3
    }

    fun getAllCharacters(): Flow<Resource<PagingData<CharacterModelDto>>> = flow {
        try {
            val pagerFlow = Pager(
                config = PagingConfig(
                pageSize = MAX_ITEMS,
                prefetchDistance = PREFETCH_ITEMS
                ),
                pagingSourceFactory = {
                    CharacterPagingSource(api)
                }).flow
            pagerFlow.collect{pagingData ->
                emit(Resource.Success(pagingData))
            }
        } catch (e: Exception) {
           emit( Resource.Error(e))
        }
    }
}