package com.example.lab21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab21.ui.theme.Lab21Theme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task5()
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
    var memory = Random.nextInt(0, 1000000)
    var memoryText by remember { mutableStateOf(memory.toString()) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${memoryText} МБ",
                fontSize = 30.sp
            )
            Button(onClick = {
                scope.launch {
                    memoryText = 0.toString()
                    snackbarHostState.showSnackbar(
                        "Кэш очищен",
                        duration = SnackbarDuration.Short
                    )
                }
            }
            ) {
                Text(text = "Очистить кэш")
            }
        }
    }
}

@Composable
fun Task5() {
    var memory = Random.nextInt(0, 1000000)
    var memoryText by remember { mutableStateOf(memory.toString()) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var gameStartState by remember { mutableStateOf(false) }
    var downloadResourceState by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (gameStartState) {
                Text(
                    "Вы вошли в игру!",
                    fontSize = 30.sp
                )
            }
            if (downloadResourceState) {
                Image(
                    ImageBitmap.imageResource(R.drawable.i), "",
                    modifier = Modifier.size(200.dp)
                )
            }



            Button(onClick = {
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        "Загрузить дополнительные ресурсы?",
                        actionLabel = "Ок",
                        withDismissAction = true
                    )
                    when (result) {
                        SnackbarResult.ActionPerformed -> {
                            gameStartState = true
                            downloadResourceState = true
                        }

                        SnackbarResult.Dismissed -> {
                            gameStartState = true
                            downloadResourceState = false
                        }
                    }
                }
            }
            ) {
                Text(text = "Играть")
            }
        }
    }
}