package com.example.rickandmortyapp.common

import com.example.rickandmortyapp.detailscreen.ui.model.CardDetailCharacter
import com.example.rickandmortyapp.mainscreen.data.dto.CharacterModelDto
import com.example.rickandmortyapp.mainscreen.ui.model.CharacterModelUI
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard

fun CharacterModelDto.toCharacterUI(): CharacterModelUI {
    return CharacterModelUI(
        name = this.name,
        species = this.species,
        isAlive = this.isAlive,
        gender = this.gender,
        image = this.image,
        episode = this.episode

    )
}

fun HomeCharacterCard.toDetail(): CardDetailCharacter {
    return CardDetailCharacter(
        name = this.name,
        species = this.species,
        isAlive = this.isAlive,
        image = this.image,
        gender = this.gender,
        episode = this.episode

    )
}