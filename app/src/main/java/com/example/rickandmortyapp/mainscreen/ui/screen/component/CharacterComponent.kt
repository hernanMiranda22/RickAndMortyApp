package com.example.rickandmortyapp.mainscreen.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard

@Composable
fun CharacterItem(
    modifier: Modifier,
    characterState: LazyPagingItems<CharacterModelUI>,
    onDetailClick: (HomeCharacterCard) -> Unit
) {
    CharacterList(
        modifier = modifier,
        character = characterState,
        onDetailClick =  {onDetailClick(it)})
}

@Composable
private fun CharacterList(
    modifier: Modifier,
    character: LazyPagingItems<CharacterModelUI>,
    onDetailClick: (HomeCharacterCard) -> Unit
) {

    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(character.itemCount) { listCharacter ->
            character[listCharacter]?.let { characterList ->
                ItemCharacter(characterModelUI = characterList, onDetailClick = onDetailClick)
            }
        }
    }

}

@Composable
private fun ItemCharacter(characterModelUI: CharacterModelUI, onDetailClick: (HomeCharacterCard) ->Unit){

    OutlinedCard(
        modifier = Modifier
            .padding(4.dp)
            .height(330.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        //, //Color(0xFF0e191a)
        shape = RoundedCornerShape(8.dp)
    ) {
        AsyncImage(
            model = characterModelUI.image,
            modifier = Modifier
                .size(250.dp)
                .fillMaxWidth()
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

        TextDetail(characterModelUI.name)
    }
}

@Composable
fun TextDetail(text:String){

    Text(
        text = text,
        modifier = Modifier
            .padding(8.dp),
        color = Color.Black, //Color(0xFFFFFFFF)
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCard(){


    ItemCharacter(
        characterModelUI = CharacterModelUI(
        gender = "",
            species = "",
            isAlive = "",
            name = "Ricador Montaner",
            image = "",
            episode = listOf()
    ),
        onDetailClick = {})
}