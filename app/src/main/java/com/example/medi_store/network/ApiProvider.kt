package com.example.medi_store.network

import com.example.medi_store.utils.BASE_URl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider{
    fun providerApiServices()=
        Retrofit.Builder()
            .baseUrl(BASE_URl)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiServices::class.java)

}