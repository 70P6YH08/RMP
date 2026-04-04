package com.example.lab25

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.documentfile.provider.DocumentFile
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            LicenseAgreementScreen()
//            Registration()
//            Notes()
            ExternalFiles()
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
fun Notes() {
    var name by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    var buttonState by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val folder = context.getDir("notes", 0)

    if (!folder.exists())
        folder.mkdirs()

    val file = File(folder, "${name}.txt")

    val files = context.getDir("notes", 0)?.listFiles()?.toList()

    var showText by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, bottom = 40.dp)
    ) {
        Text(
            text = "Имя файла не указано",
            fontSize = 25.sp,
            modifier = Modifier
                .alpha(
                    if (buttonState == false)
                        1f
                    else
                        0f
                )
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Имя файла") },
            maxLines = 1
        )
        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Содержимое") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1
        )

        if (name.isNullOrEmpty())
            buttonState = false
        else
            buttonState = true

        Button(
            onClick = {
                file.writeText(content)
            },
            enabled = buttonState
        ) {
            Text(text = "Сохранить")
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp)
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Список файлов:",
                fontSize = 30.sp,
            )
            files?.forEach { file ->
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(2.dp, color = Color.Green),
                            )
                        .padding(10.dp)
                ) {
                    Text(
                        text = file.name,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .clickable {
                                showText = true
                            }
                    )
                    if (showText == true) {
                        AlertDialog(
                            onDismissRequest = { showText = false },
                            confirmButton = {
                                Button({
                                    showText = false
                                }
                                ) {
                                    Text(text = "Ок")
                                }
                            },
                            title = {
                                Text(
                                    text = file.name,
                                    color = Color.Red
                                )
                            },
                            text = {
                                Text(
                                    text = file.readText(),
                                    color = Color.Red
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        {
                            file.delete()
                        },
                    ) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "Удалить",
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ExternalFiles() {
    var name by remember { mutableStateOf("") }

    var buttonSaveState by remember { mutableStateOf(true) }
    var buttonOpenState by remember { mutableStateOf(true) }

    val context = LocalContext.current

    var path by remember { mutableStateOf<Uri?>(null) }

    val open = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){ uri ->
        path = uri
    }

    val docFile = DocumentFile.fromSingleUri(context, path)?.name

    val save = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument()
    ){ uri ->
        path = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp, bottom = 40.dp)
    ) {

        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ){
            Button(
                onClick = {
                    open.launch("notes/*")
                },
                enabled = buttonOpenState,
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Text(text = "Открыть")
            }

            Button(
                onClick = {
                    open.launch("notes/*")
                },
                enabled = buttonSaveState
            ) {
                Text(text = "Сохранить")
            }
        }

        Spacer(modifier = Modifier.padding(bottom = 5.dp))


        Text(text = docFile.readText())
    }
}