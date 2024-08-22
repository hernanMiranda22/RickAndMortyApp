package com.example.rickandmortyapp.mainscreen.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard
import com.example.rickandmortyapp.mainscreen.ui.screen.component.SearchCharacterComponent
import com.example.rickandmortyapp.mainscreen.ui.viewmodel.CharactersViewModel

@Composable
fun ScaffoldView(
    viewModel: CharactersViewModel,
    text: String,
    onValueChange: (String) -> Unit,
    onDetailClick: (HomeCharacterCard) ->Unit
) {

    val chacaterState = viewModel.character.collectAsLazyPagingItems()

    Scaffold(topBar = {
        SearchCharacterComponent(
            value = text,
            onValueChange = { onValueChange(it) }
        )
    }
    ) {
        Box(modifier = Modifier.padding(it)){
            HomeContent(chacaterState, onDetailClick)
        }
    }
}