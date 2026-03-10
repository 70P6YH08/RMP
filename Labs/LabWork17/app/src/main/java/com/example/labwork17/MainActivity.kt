package com.example.labwork17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork17.ui.theme.LabWork17Theme
import kotlinx.coroutines.selects.RegistrationFunction

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork17Theme {
                Registration()
            }
        }
    }
}


@Composable
fun Registration() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var proofPassword by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var personalSite by remember { mutableStateOf("") }
    val buttonState = remember { mutableStateOf("Зарегистрироваться") }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(text = "Логин") },
            placeholder = { Text(text = "Введите логин") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Unspecified)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Пароль") },
            placeholder = { Text(text = "Введите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        OutlinedTextField(
            value = proofPassword,
            onValueChange = { proofPassword = it },
            label = { Text(text = "Подтверждение пароля") },
            placeholder = { Text(text = "Подтвердите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text(text = "Номер телефона") },
            placeholder = { Text(text = "Введите номер телефона") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Введите email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text(text = "Возраст") },
            placeholder = { Text(text = "Введите возраст") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = personalSite,
            onValueChange = { personalSite = it },
            label = { Text(text = "Персональный сайт") },
            placeholder = { Text(text = "Вставьте ссылку на сайт") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Button(onClick = {
            if (login.length > 0 &&
                password.length > 0 &&
                proofPassword.length > 0 &&
                phoneNumber.length > 0 &&
                email.length > 0 &&
                age.length > 0 &&
                personalSite.length > 0
            )
                buttonState.value = "${login}, Вы зарегистрированы"
            else
                buttonState.value = "Не все поля ввода заполнены"
        }) {
            Text(text = buttonState.value)
        }
    }
}

@Composable
fun pinCode(){
    var pinCode by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        OutlinedTextField(
            value = pinCode,
            onValueChange = { pinCode = it },
            label = { Text(text = "Пароль") },
            placeholder = { Text(text = "Введите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)


        )
        Button(onClick = {
            }) {
            Text(text = "Отправить")
        }
    }
}