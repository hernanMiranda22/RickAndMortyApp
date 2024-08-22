package com.example.rickandmortyapp.detailscreen.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.rickandmortyapp.detailscreen.ui.model.CardDetailCharacter
import com.example.rickandmortyapp.detailscreen.ui.screen.component.CharacterCard
import com.example.rickandmortyapp.detailscreen.ui.screen.component.ListEpisode
import com.example.rickandmortyapp.detailscreen.ui.viewmodel.DetailCharacterViewModel

@Composable
fun DetailCharacter(
    viewModel: DetailCharacterViewModel,
    cardDetailCharacter: CardDetailCharacter?,
){

    val uiState = viewModel.listEpisodes.collectAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4D4D4D))
    ){
        item {
            cardDetailCharacter?.let {
                viewModel.getListEpisode(it.episode)
                CharacterCard(it)
            }
        }
        ListEpisode(uiState)
    }

}