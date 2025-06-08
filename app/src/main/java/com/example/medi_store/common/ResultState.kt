package com.example.medi_store.common

sealed class ResultState{

    data class Success(val data:T):ResultState<T>()
}