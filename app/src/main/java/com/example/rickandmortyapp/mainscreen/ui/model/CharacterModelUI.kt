package com.example.rickandmortyapp.mainscreen.ui.model

data class CharacterModelUI(
    val gender: String,
    val species: String,
    val isAlive: String,
    val name: String,
    val image: String,
    val episode : List<String>
)
