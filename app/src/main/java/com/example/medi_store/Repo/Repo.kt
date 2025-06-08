package com.example.medi_store.Repo

import com.example.medi_store.network.ApiProvider

class Repo {
    suspend fun createUser(
        name:String,
        password: String,
        phoneNumber: String,
        email: String,
        pinCode: String,
        address: String,
    ) = ApiProvider.providerApiServices().createUser(name,password,phoneNumber,email,pinCode,address)


}