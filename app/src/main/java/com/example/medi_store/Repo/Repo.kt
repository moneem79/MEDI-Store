package com.example.medi_store.Repo

import com.example.medi_store.common.ResultState
import com.example.medi_store.network.ApiProvider
import com.example.medi_store.network.response.loginresponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repo {
    suspend fun createUser(
        name:String,
        password: String,
        phoneNumber: String,
        email: String,
        pinCode: String,
        address: String,
    ) = ApiProvider.providerApiServices().createUser(name,password,phoneNumber,email,pinCode,address)


    suspend fun loginUser(
        email: String,
        password: String
    ): Flow<ResultState<loginresponse>> = flow{
        emit(ResultState.Loading)

        try{
            val response = ApiProvider.providerApiServices().loginUser(email,password)

            emit(ResultState.Success(response.body()!!))


        }
        catch (e :Exception){
            emit(ResultState.Error(e))

        }





    }








}