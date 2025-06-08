package com.example.medi_store.ui.theme.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.medi_store.viewModel.MYViewModel

@Composable
fun Signup(viewModel: MYViewModel) {

    val name = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val pinCode = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { androidx.compose.material3.Text("Name") }
        )

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { androidx.compose.material3.Text("Password") }
        )

        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            label = { androidx.compose.material3.Text("Phone Number") }
        )

        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { androidx.compose.material3.Text("Email") }
        )

        TextField(
            value = pinCode.value,
            onValueChange = { pinCode.value = it },
            label = { androidx.compose.material3.Text("Pin Code") }
        )

        TextField(
            value = address.value,
            onValueChange = { address.value = it },
            label = { androidx.compose.material3.Text("Address") }
        )

                Button(onClick = {
                    viewModel.createUser(
                        name = name.value,
                        password = password.value,
                        phoneNumber = phoneNumber.value,
                        email = email.value,
                        pinCode = pinCode.value,
                        address = address.value)
                }) {
                    Text(text = "Sign Up")
                }


    }}



