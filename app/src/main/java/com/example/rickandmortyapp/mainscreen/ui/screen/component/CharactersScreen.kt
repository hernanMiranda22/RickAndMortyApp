package com.example.rickandmortyapp.mainscreen.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard
import com.example.rickandmortyapp.mainscreen.ui.screen.component.CharacterItem

@Composable
fun HomeContent(
    characterState: LazyPagingItems<CharacterModelUI>,
    onDetailClick: (HomeCharacterCard) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {

        when{
            characterState.loadState.refresh is LoadState.Loading && characterState.itemCount == 0 -> {
                HomeSkeleton()
            }
            characterState.loadState.refresh is LoadState.NotLoading && characterState.itemCount == 0 -> {
                Text(text = "No hay personajes")
            }
            characterState.loadState.hasError -> {
                Text(text = "Error en la red")
            }
            else -> {

                CharacterItem(
                    Modifier.align(Alignment.Center),
                    characterState, onDetailClick
                )

                if (characterState.loadState.append is LoadState.Loading){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter))
                }
            }
        }

    }
}
