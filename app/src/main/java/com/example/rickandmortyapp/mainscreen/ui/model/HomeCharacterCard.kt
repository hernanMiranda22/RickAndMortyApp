package com.example.rickandmortyapp.mainscreen.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeCharacterCard(
    val gender: String,
    val species: String,
    val isAlive: String,
    val name: String,
    val image: String,
    val episode : List<String>
): Parcelable {
    companion object {
        val TAG: String = HomeCharacterCard::class.java.simpleName
    }
}