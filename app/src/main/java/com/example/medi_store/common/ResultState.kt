package com.example.medi_store.common

sealed class ResultState<T>{

    data class Success<T>(val data:T):ResultState<T>()
    data class Error<T>(val exception: Exception):ResultState<T>()
    object Loading:ResultState<Nothing>()
}