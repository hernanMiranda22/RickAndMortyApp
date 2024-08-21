package com.example.rickandmortyapp.mainscreen.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterModelDto (
    @SerializedName("gender") val gender: String,
    @SerializedName("species") val species: String,
    @SerializedName("status") val isAlive: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image : String,
    @SerializedName("episode") val episode : List<String>
)