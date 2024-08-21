package com.example.rickandmortyapp.mainscreen.ui.model

sealed class Routes(val route:String) {
    data object ListCharacters:Routes("mainScreen")
    data object DetailCharacters:Routes("detailScreen")
}