package com.example.medi_store.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiProvider{
    fun providerApiService()=Retrofit.Builder().baseUrl("")client(OkHttpClient().Builder()..builder())




}