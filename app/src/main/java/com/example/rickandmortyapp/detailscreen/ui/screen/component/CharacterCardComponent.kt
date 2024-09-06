package com.example.rickandmortyapp.detailscreen.ui.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.detailscreen.ui.model.CardDetailCharacter

@Composable
fun CharacterCard(cardDetailCharacter: CardDetailCharacter) {

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(bottomStart = 8.dp ,bottomEnd = 8.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                model = cardDetailCharacter.image,
                contentDescription = null
            )

            Column(
                Modifier
                    .padding(start = 24.dp)
                    .weight(2f)
            ) {
                TextCardDetailCharacter(
                    title = R.string.label_name,
                    text = cardDetailCharacter.name,
                    fontSize = 22,
                    fontWeight = FontWeight.Bold
                )
                TextCardDetailCharacter(
                    title = R.string.label_species,
                    text = cardDetailCharacter.species,
                    fontSize = 18
                )
                TextCardDetailCharacter(
                    title = R.string.label_isAlive,
                    text = cardDetailCharacter.isAlive,
                    fontSize = 18
                )
                TextCardDetailCharacter(
                    title = R.string.label_gender,
                    text = cardDetailCharacter.gender,
                    fontSize = 18
                )
            }
        }

    }
}

@Composable
private fun TextCardDetailCharacter(
    title: Int,
    text : String,
    fontSize : Int,
    fontWeight: FontWeight? = null,
    color: Color = colorResource(id = R.color.black)
){
    Text(
        text = "${stringResource(id = title)} $text",
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        color = color
        )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCard(){
    CharacterCard(cardDetailCharacter = CardDetailCharacter(
        name = "Rick",
        species = "Human",
        isAlive = "Alive",
        gender = "Male",
        image = "",
        episode = listOf()
    ))
}