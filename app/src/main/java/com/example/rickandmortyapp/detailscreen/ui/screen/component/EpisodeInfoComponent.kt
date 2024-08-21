package com.example.rickandmortyapp.detailscreen.ui.screen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortyapp.detailscreen.ui.viewmodel.DetailCharacterViewModel

@Composable
fun EpisodeInfo(
    detailCharacterViewModel: DetailCharacterViewModel,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        ListEpisode(
            detailCharacterViewModel = detailCharacterViewModel
        )

    }
}