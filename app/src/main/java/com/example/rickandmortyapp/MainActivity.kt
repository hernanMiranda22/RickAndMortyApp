package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.common.NavigationHost
import com.example.rickandmortyapp.detailscreen.ui.viewmodel.DetailCharacterViewModel
import com.example.rickandmortyapp.mainscreen.ui.viewmodel.CharactersViewModel
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val charactersViewModel : CharactersViewModel by viewModels()
    private val detailCharacterViewModel : DetailCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                val valueState: String by charactersViewModel.searchCharacter.collectAsState()

                val navController = rememberNavController()

                NavigationHost(
                    navController = navController,
                    detailsCharacterViewModel = detailCharacterViewModel,
                    charactersViewModel = charactersViewModel,
                    valueState = valueState
                )
            }
        }
    }
}
