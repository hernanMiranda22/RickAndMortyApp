package com.example.rickandmortyapp.mainscreen.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.common.ApiService
import com.example.rickandmortyapp.common.toCharacterUI
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import java.io.IOException
import javax.inject.Inject

class CharacterPagingSource @Inject constructor(private val api : ApiService):PagingSource<Int, CharacterModelUI>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModelUI>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModelUI> {

        return try {
            val page = params.key ?: 1
            val response = api.getAllCharacter(page)
            val characters = response.resultCharacter

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = if(response.pagingInfo.next != null) page + 1 else null

            LoadResult.Page(
                data = characters.map { it.toCharacterUI() },
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}