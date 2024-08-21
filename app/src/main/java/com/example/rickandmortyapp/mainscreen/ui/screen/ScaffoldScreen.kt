package com.example.rickandmortyapp.mainscreen.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Scaffold(topBar = {
        SearchCharacterComponent(
            value = text,
            onValueChange = { onValueChange(it) }
        )
    }
    ) {
        Box(modifier = Modifier.padding(it)){
            MainScreen(listViewModel = viewModel, onDetailClick)
        }
    }
}