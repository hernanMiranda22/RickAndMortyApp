package com.example.rickandmortyapp.detailscreen.ui.screen.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.detailscreen.ui.model.CardDetailCharacter
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeStateUI

@Composable
fun DetailsCharacterScreenContent(
    uiState: EpisodeStateUI,
    cardDetailCharacter: CardDetailCharacter?
) {


    when (uiState) {
        is EpisodeStateUI.Error -> {

        }

        EpisodeStateUI.Loading -> {
            SkeletonDetails()
        }

        is EpisodeStateUI.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    cardDetailCharacter?.let {
                        CharacterCard(it)
                    }
                }
                ListEpisode(uiState.listEpisode)

            }
        }
    }
}


