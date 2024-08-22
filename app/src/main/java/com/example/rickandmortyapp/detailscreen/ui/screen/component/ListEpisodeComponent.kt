package com.example.rickandmortyapp.detailscreen.ui.screen.component


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeStateUI

fun LazyListScope.ListEpisode(uiState : EpisodeStateUI){

    when(uiState){
        is EpisodeStateUI.Error -> {

        }
        EpisodeStateUI.Loading -> {
            item {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    CircularProgressExtraInfo()
                }
            }

        }
        is EpisodeStateUI.Success -> {
            EpisodeSection(uiState.listEpisode)
        }
    }
}


private fun LazyListScope.EpisodeSection(listFilms : List<EpisodeModelUI?>){
    items(listFilms){
        ItemEpisode(list = it)
    }
}

@Composable
private fun ItemEpisode(list : EpisodeModelUI?){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF000000)
        )
    ) {
        Text(
            text = "${stringResource(id = R.string.label_nameEpisode)} ${list?.name}",
            modifier = Modifier.padding(4.dp),
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF)
        )
        Text(
            text = "${stringResource(id = R.string.label_airDate)} ${list?.ariDate}",
            modifier = Modifier.padding(4.dp),
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF)
        )
        Text(
            text = "${stringResource(id = R.string.label_numberEpisode)} ${list?.episode}",
            modifier = Modifier.padding(4.dp),
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF)
        )
    }
}