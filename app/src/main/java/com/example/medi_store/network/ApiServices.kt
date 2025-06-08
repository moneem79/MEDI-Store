package com.example.medi_store.network

import com.example.medi_store.network.response.CreateUSerResponse
import com.example.medi_store.network.response.loginresponse
import okhttp3.Address
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiServices {
    @FormUrlEncoded


    @POST("createUser")
    suspend fun createUser(

        @Field("name") name:String,
        @Field ("password") password :String,
        @Field ("phoneNumber") phoneNumber:String,
        @Field ("email") email:String,
        @Field ("pinCode") pinCode :String,
        @Field ("address") address:String

    ) :Response<CreateUSerResponse>


    @FormUrlEncoded

    @POST("login")
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password:String
    ) :Response<loginresponse>



}