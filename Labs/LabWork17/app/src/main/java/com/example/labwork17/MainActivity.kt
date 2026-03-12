package com.example.labwork17

import android.R.attr.fontWeight
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork17.ui.theme.LabWork17Theme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork17Theme {
//                Registration()
//                PinCode()
//                AboutMe()
                FontSettingsScreen()
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
    val checkedState = remember { mutableStateOf(false) }
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
        Row(Modifier.padding(horizontal = 10.dp)){
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "Я согласен на обработку своих персональных данных и принимаю условия" +
                    "Политики конфиденциальности и Пользовательского соглашения")
        }



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
        },
            enabled = if (checkedState.value == true) true else false
        ){
            Text(text = buttonState.value)
        }
    }
}

@Composable
fun PinCode() {
    var pinCode by remember { mutableStateOf("") }
    val rightPinCode = remember { mutableStateOf("1488") }
    val buttonState = remember { mutableStateOf("Отправить") }
    val counter = remember { mutableStateOf(3) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = pinCode,
            onValueChange = {
                if (pinCode.length < 4)
                    pinCode = it
            },
            enabled = if (counter.value == 0) false else true,
            label = { Text(text = "Пароль") },
            placeholder = { Text(text = "Введите пароль") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        )
        Text(text = "Осталось попыток: ${counter.value}")
        Button(onClick = {
            if (pinCode == rightPinCode.value) {
                buttonState.value = "Отправить (верно)"
                pinCode = ""
            } else {
                buttonState.value = "Отправить (неверно)"
                pinCode = ""
                counter.value -= 1
            }
        }) {
            Text(text = buttonState.value)
        }
    }
}

@Composable
fun AboutMe() {
    var text by remember { mutableStateOf("") }
    var maxLength = 300
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength){
                    text = it
                }
            },
            label = {Text(text = "О себе")},
            minLines = 4,
            maxLines = 8,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "Осталось символов для ввода: ${maxLength - text.length}",
            onValueChange = {},
            enabled = false,
        )
    }
}

@Composable
fun FontSettingsScreen() {
    val colors = listOf(
        "Красный" to Color.Red,
        "Зеленый" to Color.Green,
        "Синий" to Color.Blue,
        "Желтый" to Color.Yellow,
        "Фиолетовый" to Color.Magenta
    )
    val text = remember { mutableStateOf("ТЕКСТ") }
    var selectedColor by remember { mutableStateOf(colors[0].second) }
    var fontSize by remember { mutableStateOf(16f) }
    val isBold = remember { mutableStateOf(false) }
    val isItalic = remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp)) {
        colors.forEach { (colorText, color) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = { selectedColor = color }
                    ),
            ) {
                RadioButton(
                    selected = (selectedColor == color),
                    onClick = null
                )
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(color)
                )
                Text(text = colorText)
            }
        }

        Column(horizontalAlignment = Alignment.End){
            Slider(
                value = fontSize,
                onValueChange = { fontSize = it },
                valueRange = 10f..30f,
                steps = 19,
                modifier = Modifier.fillMaxWidth()
            )
            Text("${fontSize.toInt()}")
        }

        Row{
            Text(text = "Жирный")
            Switch(
                checked = isBold.value,
                onCheckedChange = {isBold.value = it}
            )
        }

        Row {
            Text(text = "Курсив")
            Switch(
                checked = isItalic.value,
                onCheckedChange = {isItalic.value = it}
            )
        }
        Text(
            text = text.value,
            fontSize = fontSize.sp,
            color = selectedColor,
            fontWeight = if (isBold.value) FontWeight.Bold else FontWeight.Normal,
            fontStyle = if (isItalic.value) FontStyle.Italic else FontStyle.Normal
        )
    }
}