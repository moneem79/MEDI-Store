package com.example.medi_store.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider{
    fun providerApiServices()=
        Retrofit.Builder()
            .baseUrl("https://moneem7.pythonanywhere.com")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}