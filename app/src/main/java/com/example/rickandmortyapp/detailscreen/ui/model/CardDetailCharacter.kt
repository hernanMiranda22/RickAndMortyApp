package com.example.rickandmortyapp.detailscreen.ui.model

data class CardDetailCharacter (
    val gender: String,
    val species: String,
    val isAlive: String,
    val name: String,
    val image: String,
    val episode : List<String>
)