package com.example.rickandmortyapp.mainscreen.data.dto

import com.google.gson.annotations.SerializedName

data class HomeResponseDto(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages : Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val previous: String?
)