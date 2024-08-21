package com.example.rickandmortyapp.mainscreen.data.dto

import com.google.gson.annotations.SerializedName

data class ResponseDtoWrapper(
    @SerializedName("info") val pagingInfo : HomeResponseDto,
    @SerializedName("results") val resultCharacter : List<CharacterModelDto>
)