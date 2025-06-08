package com.example.medi_store.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medi_store.Repo.Repo
import com.example.medi_store.network.response.CreateUSerResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MYViewModel:ViewModel() {

    val repo = Repo()
    val createUserState= mutableStateOf<CreateUSerResponse?>(null)


    fun createUser(
        name:String,
        password: String,
        phoneNumber: String,
        email: String,
        pinCode: String,
        address: String,
    ){
         viewModelScope.launch (Dispatchers.IO){
             val response =repo.createUser(name,password,email,phoneNumber,pinCode, address)
             createUserState.value=response.body()

         }

    }
}