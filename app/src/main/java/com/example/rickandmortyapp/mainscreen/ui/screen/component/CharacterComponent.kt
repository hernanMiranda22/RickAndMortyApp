package com.example.rickandmortyapp.mainscreen.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard

@Composable
fun CharacterItem(
    modifier: Modifier,
    chacaterState: LazyPagingItems<CharacterModelUI>,
    onDetailClick: (HomeCharacterCard) -> Unit
) {

   // val character = listViewModel.character.collectAsLazyPagingItems()

    when{
        chacaterState.loadState.refresh is LoadState.Loading && chacaterState.itemCount == 0 -> {
            Box(modifier = modifier
                .fillMaxSize()
                .background(Color(0xFF000000)),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        chacaterState.loadState.refresh is LoadState.NotLoading && chacaterState.itemCount == 0 -> {
            Text(text = "No hay personajes")
        }
        chacaterState.loadState.hasError -> {
            Text(text = "Error en la red")
        }
        else -> {
            CharacterList(modifier, chacaterState, onDetailClick)

            if (chacaterState.loadState.append is LoadState.Loading){
                Box(modifier = modifier
                    .fillMaxSize()
                    .background(Color(0xFF000000)),
                    contentAlignment = Alignment.BottomCenter
                ){
                    CircularProgressIndicator()
                }
            }
        }
    }

}

@Composable
private fun CharacterList(
    modifier: Modifier,
    character: LazyPagingItems<CharacterModelUI>,
    onDetailClick: (HomeCharacterCard) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {

        items(character.itemCount) { listCharacter ->
            character[listCharacter]?.let { characterList ->
                ItemCharacter(characterModelUI = characterList, onDetailClick = onDetailClick)
            }
        }

    }
}

@Composable
private fun ItemCharacter(characterModelUI: CharacterModelUI, onDetailClick: (HomeCharacterCard) ->Unit){

    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
        color = Color(0xFF0e191a),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            AsyncImage(
                model = characterModelUI.image,
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        onDetailClick(
                            HomeCharacterCard(
                                name = characterModelUI.name,
                                gender = characterModelUI.gender,
                                isAlive = characterModelUI.isAlive,
                                episode = characterModelUI.episode,
                                species = characterModelUI.species,
                                image = characterModelUI.image
                            )
                        )
                    },
                contentDescription = null,
                alignment = Alignment.TopStart,
                contentScale = ContentScale.FillBounds
            )

            Column(
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally) {
                TextDetail(R.string.label_name, characterModelUI.name)
            }
        }

    }
}