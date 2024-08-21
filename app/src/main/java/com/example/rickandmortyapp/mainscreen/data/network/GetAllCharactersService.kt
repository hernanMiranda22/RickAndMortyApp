package com.example.rickandmortyapp.mainscreen.data.network

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapp.common.ApiService
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersService @Inject constructor(private val api : ApiService) {
    companion object{
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 3
    }

    fun getAllCharacters(): Flow<PagingData<CharacterModelUI>> {
        return Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                CharacterPagingSource(api)
            }).flow
    }
}