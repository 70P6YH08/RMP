package com.example.inputs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inputs.ui.theme.InputsTheme
import com.google.android.gms.fitness.data.Field

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    InputsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.fillMaxSize().padding(innerPadding)) {
                var text by remember { mutableStateOf("") }
                TextField(
                    text,
                    { text = if (it.length > 5) text else it }, //ограничение ввода текста
                    label = { Text("Текстик") },
                    placeholder = { Text("...") },
                    leadingIcon = { Icon(Icons.Filled.Email, "") }, //иконка вначала
                    trailingIcon = { Icon(Icons.Filled.Search, "") },
                    minLines = 2,
                    maxLines = 4
                ) //иконка вконце
                OutlinedTextField(
                    text, //отличается от TextField только рамкой
                    { text = it },
                    label = { Text("Текстик") },
                    placeholder = { Text("...") },
                    isError = text.isEmpty(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = OutlinedTextFieldDefaults.colors(),
                    singleLine = true
                )
                var checked by remember { mutableStateOf(true) }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { checked != checked }) {
                    Checkbox(true, { checked = it })
                    Text("Установить кроссаут")
                }

                val students = listOf("Матигоров", "Терентьев", "Власов", "Луканин")
                var selected by remember { mutableStateOf(students[0]) }

                students.forEach {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(it == selected, { selected = it })
                        Text(it)
                    }
                }

                var num by remember { mutableStateOf(0f) }

                Slider(
                    num, { num = it },
                    modifier = Modifier.padding(20.dp),
                    valueRange = 10f..30f, steps = 3
                )

                Button({},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red, contentColor = Color.Blue)) {
                    Text("Привет")
                }
            }
        }
    }
}