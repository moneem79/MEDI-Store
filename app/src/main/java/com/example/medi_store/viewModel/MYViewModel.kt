package com.example.medi_store.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medi_store.Repo.Repo
import com.example.medi_store.common.ResultState
import com.example.medi_store.network.response.CreateUSerResponse
import com.example.medi_store.network.response.loginresponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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




private val _loginUserState = MutableStateFlow(LoginUserState())
    val loginresponse=_loginUserState.asStateFlow()

fun loginUser(
    email:String,
    password: String){
    viewModelScope.launch (Dispatchers.IO){
        repo.loginUser(email,password).collect{
            when(it){
                is ResultState.Loading->{
                    _loginUserState.value = LoginUserState(isLoading = true)
                }


                is ResultState.Success->{
                    _loginUserState.value=LoginUserState(success = it.data, isLoading = false)
                }
                is ResultState.Error->{
                    _loginUserState.value=LoginUserState(error = it.exception.message, isLoading = false)

                }
            }
        }

    }
}





}


data class LoginUserState(
    val isLoading:Boolean=false,
    val success:loginresponse?=null,
    val error:String? = null
)