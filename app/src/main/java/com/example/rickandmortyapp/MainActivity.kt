package com.example.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.common.NavigationHost
import com.example.rickandmortyapp.detailscreen.ui.viewmodel.DetailCharacterViewModel
import com.example.rickandmortyapp.mainscreen.ui.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val charactersViewModel : CharactersViewModel by viewModels()
    private val detailCharacterViewModel : DetailCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavigationHost(
                navController = navController,
                detailsCharacterViewModel = detailCharacterViewModel,
                charactersViewModel = charactersViewModel
            )
        }
    }
}
