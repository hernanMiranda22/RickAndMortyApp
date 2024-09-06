package com.example.rickandmortyapp.detailscreen.ui.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.detailscreen.ui.model.EpisodeModelUI

fun LazyListScope.ListEpisode(listFilms : List<EpisodeModelUI?>){
    EpisodeSection(listFilms)
}


private fun LazyListScope.EpisodeSection(listFilms : List<EpisodeModelUI?>){
    items(listFilms){
        ItemEpisode(list = it)
    }
}

@Composable
private fun ItemEpisode(list : EpisodeModelUI?){
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.color_yellow_morty)
        )
    ) {

        TextEpisodeContent(
            title = R.string.label_nameEpisode,
            text =  list?.name,
            fontSize = 22,
            fontWeight = FontWeight.Bold,
        )

        TextEpisodeContent(
            title = R.string.label_nameEpisode,
            text =  list?.ariDate,
            fontSize = 20,
            fontWeight = FontWeight.Bold,
        )

        TextEpisodeContent(
            title = R.string.label_numberEpisode,
            text =  list?.episode,
            fontSize = 18,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun TextEpisodeContent(
    title : Int,
    text : String?,
    modifier: Modifier = Modifier,
    fontSize : Int,
    fontWeight: FontWeight,
    color : Color = colorResource(id = R.color.black)
){
    Text(
        modifier = modifier.padding(8.dp),
        text = "${stringResource(id = title)} $text",
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        color = color
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewItem(){
    
    Column {
        ItemEpisode(list = EpisodeModelUI(
            name = "Un dia memorable",
            ariDate = "19/11/2004",
            episode = "1"
        ))

        ItemEpisode(list = EpisodeModelUI(
            name = "Un dia memorable",
            ariDate = "19/11/2004",
            episode = "1"
        ))

        ItemEpisode(list = EpisodeModelUI(
            name = "Un dia memorable",
            ariDate = "19/11/2004",
            episode = "1"
        ))

        ItemEpisode(list = EpisodeModelUI(
            name = "Un dia memorable",
            ariDate = "19/11/2004",
            episode = "1"
        ))

        ItemEpisode(list = EpisodeModelUI(
            name = "Un dia memorable",
            ariDate = "19/11/2004",
            episode = "1"
        ))
    }

}