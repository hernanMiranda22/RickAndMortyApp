package com.example.rickandmortyapp.core

sealed class Resource<out T>{
    data class Success<out T>(val data : T) : Resource<T>()
    data class Error<out T>(val exception:Exception) : Resource<T>()
}

inline fun<T,R> Resource<T>.map(transform:(T) -> R): Resource<R>{
    return when(this){
        is Resource.Error -> Resource.Error(this.exception)
        is Resource.Success -> Resource.Success(transform(this.data))
    }
}