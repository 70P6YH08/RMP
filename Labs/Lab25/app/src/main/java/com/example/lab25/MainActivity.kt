package com.example.lab25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LicenseAgreementScreen()
//            Registration()
//            Notes()
        }
    }
}

@Composable
fun LicenseAgreementScreen() {
    var state by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val text = context.assets.open("eula.txt")
        .bufferedReader().use {
            it.readText()
        }

    Column(
        modifier = Modifier
            .padding(vertical = 30.dp, horizontal = 10.dp)

    ){
        Text(
            text = text,
            fontSize = 30.sp
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                Row{
                    Checkbox(
                        onCheckedChange = { state = it },
                        checked = state
                    )
                    Text(
                        text = "Я прочитал условия лицензионного соглашения",
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Button(
                    {},
                    enabled = state,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Принять",
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(all = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Registration() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var buttonState by remember { mutableStateOf(false)}

    val context = LocalContext.current

    val textPassword = context.assets.open("weak_passwords.txt")
        .bufferedReader().use {
            it.readText()
        }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(text = "Логин") }
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        if(password.length >= 8) {
            buttonState = true
            if (textPassword.contains(password)) {
                Text(text = "Ненадёжный пароль!")
                buttonState = false
            }
        }
        else
            buttonState = false
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            onClick = {},
            enabled = buttonState
        ){
            Text(text = "Зарегистрироваться")
        }
    }
}

@Composable
fun Notes(){
    var name by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    var buttonState by remember { mutableStateOf(false)}

    val context = LocalContext.current

//    context.filesDir?.let{Text(it.path)}

    val file = File(context.filesDir, "/com.example.lab25/app_notes/")


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Название") }
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Содержимое") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        if(!content.isNullOrEmpty() && !name.isNullOrEmpty()){
            buttonState = true
        }

        Button(
            onClick = {
                file.writeText(content)
            },
            enabled = buttonState
        ){
            Text(text = "Сохранить")
        }
    }
}