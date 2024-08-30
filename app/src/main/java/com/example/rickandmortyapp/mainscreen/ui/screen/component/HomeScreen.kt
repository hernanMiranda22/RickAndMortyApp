package com.example.rickandmortyapp.mainscreen.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard
import com.example.rickandmortyapp.mainscreen.ui.viewmodel.CharactersViewModel

@Composable
fun HomeScreen(
    viewModel: CharactersViewModel,
    onDetailClick: (HomeCharacterCard) ->Unit
) {

    val characterState = viewModel.character.collectAsLazyPagingItems()

    HomeContent(characterState, onDetailClick)

}

