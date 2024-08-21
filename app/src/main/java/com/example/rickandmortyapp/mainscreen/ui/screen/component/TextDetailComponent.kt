package com.example.rickandmortyapp.mainscreen.ui.screen.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextDetail(stringResource : Int, text:String){

    Text(
        text = "${stringResource(id = stringResource)} $text",
        modifier = Modifier
            .padding(8.dp),
        color = Color(0xFFFFFFFF),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )

}