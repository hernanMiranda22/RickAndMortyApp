package com.example.rickandmortyapp.detailscreen.data.dto

import com.google.gson.annotations.SerializedName

data class EpisodeModelDto(
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val ariDate: String,
    @SerializedName("episode") val episode: String
)
