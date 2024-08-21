package com.example.rickandmortyapp.detailscreen.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.detailscreen.ui.model.CardDetailCharacter
import com.example.rickandmortyapp.detailscreen.ui.viewmodel.DetailCharacterViewModel

@Composable
fun DetailCharacter(
    viewModel: DetailCharacterViewModel,
    cardDetailCharacter: CardDetailCharacter?,
){

    Column(modifier = Modifier.fillMaxWidth()) {

//        cardDetailCharacter?.let {
//            viewModel.getListEpisode(it.episode)
//            CharacterCard(it)
//        }
//
//        TabExtraInfo(detailCharacterViewModel = viewModel)

    }
}