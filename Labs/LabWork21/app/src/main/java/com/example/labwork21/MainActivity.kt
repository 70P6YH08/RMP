package com.example.labwork21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork21.ui.theme.LabWork21Theme
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Authorization1()
//            Authorization2()
        }
    }
}

@Composable
fun Authorization1(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var openDialog by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(Modifier.padding(bottom = 8.dp)){
            Text(text = "Логин")
            TextField(
                value = login,
                onValueChange = {login = it},
                label = {Text(text = "Логин")}
            )
        }
        Column{
            Text(text = "Пароль")
            TextField(
                value = password,
                onValueChange = {password = it},
                label = {Text(text = "Пароль")}
            )
        }
        Button(onClick = {openDialog = true }){
            Text(text = "Авторизоваться")
        }
        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false},
                title = {Text(text = "Вы авторизованы!")},
                text = { Text("Добро пожаловать, $login!") },
                confirmButton = {
                    Button({ openDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}

@Composable
fun Authorization2() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var openDialog by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.padding(bottom = 8.dp)) {
            Text(text = "Логин")
            TextField(
                value = login,
                onValueChange = { login = it },
                label = { Text(text = "Логин") }
            )
        }
        Column {
            Text(text = "Пароль")
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Пароль") }
            )
        }
        Button(onClick = { openDialog = true }) {
            Text(text = "Авторизоваться")
        }
        if ((!password.isNullOrEmpty() && !login.isNullOrEmpty()) && openDialog) {
            AlertDialog(
                containerColor = Color.Cyan,
                titleContentColor = Color.Gray,
                textContentColor = Color.Gray,
                onDismissRequest = { openDialog = false },
                title = { Text(text = "Вы авторизованы") },
                text = { Text("Добро пожаловать, $login!") },
                confirmButton = {
                    Button(
                        { openDialog = false },
                        modifier = Modifier
                            .align(alignment = Alignment.End),
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color.Green,
                                contentColor = Color.Black
                            )
                    ) {
                        Icon(Icons.Filled.Done, "Ок")
                        Text("Ок")
                    }
                }
            )
        } else if (openDialog) {
            AlertDialog(
                containerColor = Color.Cyan,
                titleContentColor = Color.Gray,
                textContentColor = Color.Gray,
                onDismissRequest = { openDialog = false },
                title = { Text(text = "Вы авторизованы!Ошибка авторазации") },
                text = { Text("Поля ввода логина и пароля пусты!") },
                confirmButton = {
                    Column {
                        Button(
                            { openDialog = false },
                            modifier = Modifier
                                .align(alignment = Alignment.End),
                            colors = ButtonDefaults
                                .buttonColors(
                                    containerColor = Color.Green,
                                    contentColor = Color.Black
                                )
                        ) {
                            Icon(Icons.Filled.Done, "Ок")
                            Text("Ок")
                        }
                        Button(
                            { openDialog = false },
                            colors = ButtonDefaults
                                .buttonColors(
                                    containerColor = Color.Red,
                                    contentColor = Color.Black
                                )
                        ) {
                            Icon(Icons.Filled.Close, "Отмена")
                            Text("Отмена")
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun Task4() {
    var memory = Random.nextInt(0,10000)
    val memoryText = remember {mutableStateOf(memory)}
    var openDialog by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(Modifier.padding(bottom = 8.dp)) {
            Text(text = "Логин")
            TextField(
                value = memoryText.value.toString(),
                onValueChange = { memoryText.value = it },
                label = { Text(text = "Логин") }
            )
        }
        Button(onClick = {}) {
            Text(text = "Очистить кэш")
        }
        if (openDialog) {
            memory = 0
            AlertDialog(
                onDismissRequest = { openDialog = false},
                title = {Text(text = "Вы авторизованы!")},
                text = { Text("Добро пожаловать, $!") },
                confirmButton = {}
            )
        }
    }
}