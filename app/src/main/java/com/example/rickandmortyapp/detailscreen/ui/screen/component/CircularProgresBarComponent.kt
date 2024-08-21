package com.example.rickandmortyapp.detailscreen.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CircularProgressExtraInfo(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFD4D4D4))
    ){
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}