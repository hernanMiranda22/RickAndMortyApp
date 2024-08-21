package com.example.rickandmortyapp.mainscreen.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard
import com.example.rickandmortyapp.mainscreen.ui.screen.component.CharacterItem
import com.example.rickandmortyapp.mainscreen.ui.viewmodel.CharactersViewModel

@Composable
fun MainScreen(listViewModel: CharactersViewModel, onDetailClick: (HomeCharacterCard) -> Unit) {
    ScreenComponent(
        listViewModel = listViewModel,
        onDetailClick = onDetailClick
    )
}

@Composable
private fun ScreenComponent(
    listViewModel: CharactersViewModel,
    onDetailClick: (HomeCharacterCard) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        CharacterItem(
            Modifier.align(Alignment.Center),
            listViewModel, onDetailClick
        )
    }

}