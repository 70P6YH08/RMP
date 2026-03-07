package screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Authorization(onRegistrationClick: () -> Unit, onAuthorizationClick: () -> Unit) {
    Row(Modifier.padding(start = 10.dp, top = 50.dp)) {
        Icon(Icons.Filled.Check, "", modifier = Modifier
            .height(60.dp)
            .width(60.dp),
            tint = Color.White
        )
    }
    Column(
        Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        Text(
            text = "Авторизация",
            fontSize = 30.sp,
            color = Color(red = 0x4A, green = 0x3A, blue = 0x2A, alpha = 0x6A)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Логин") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 25.sp),
        )
        TextField(
            text,
            { text = it },
            label = { Text("Пароль") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 25.sp),
        )
        Row() {
            Button(onClick = onAuthorizationClick,
                modifier = Modifier.padding(horizontal = 10.dp), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan, contentColor = Color.Gray)){
                Text("Войти")
            }
            Button(onClick = onRegistrationClick, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan, contentColor = Color.Gray
            )){
                Text("Зарегистрироваться")
            }
        }
    }
}

@Composable
fun Registration(onAuthorizationClick: () -> Unit) {
    Row(Modifier.padding(start = 10.dp, top = 50.dp)) {
        Icon(Icons.Filled.Create, "", modifier = Modifier
            .height(60.dp)
            .width(60.dp),
            tint = Color.White
        )
    }
    Column(
        Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        Text(
            text = "Регистрация",
            fontSize = 30.sp,
            color = Color(red = 0x4A, green = 0x3A, blue = 0x2A, alpha = 0x6A)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Логин") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Unspecified)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Пароль") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Подтвердите пароль") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Номер") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Email") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Возраст") },
            maxLines = 1,
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth()
                .height(80.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row() {
            Button(onClick = onAuthorizationClick, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan, contentColor = Color.Gray
            )){
                Text("Ок")
            }
        }
    }
}

@Composable
fun UserProfile(onAuthorizationClick: () -> Unit) {
    Row(Modifier.padding(start = 10.dp, top = 50.dp)) {
        Icon(Icons.Filled.Person, "", modifier = Modifier
            .height(60.dp)
            .width(60.dp),
            tint = Color.White
        )
    }
    Column(
        Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        Text(
            text = "Профиль пользователя",
            fontSize = 30.sp,
            color = Color(red = 0x4A, green = 0x3A, blue = 0x2A, alpha = 0x6A)
        )
        TextField(
            text,
            { text = it },
            label = { Text("Логин") },
            maxLines = 1,
            textStyle = TextStyle(fontSize = 14.sp),
        )
        TextField(
            text,
            { text = it },
            label = { Text("Имя") },
            maxLines = 1,
            textStyle = TextStyle(fontSize = 14.sp),
        )
        TextField(
            text,
            { text = it },
            label = { Text("Возраст") },
            maxLines = 1,
            textStyle = TextStyle(fontSize = 14.sp),
        )
        TextField(
            text,
            { text = it },
            label = { Text("Email") },
            maxLines = 1,
            textStyle = TextStyle(fontSize = 14.sp),
        )
        TextField(
            text,
            { text = it },
            label = { Text("О себе") },
            maxLines = 5,
            textStyle = TextStyle(fontSize = 14.sp),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        )
        Row() {
            Button(onClick = onAuthorizationClick, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan, contentColor = Color.Gray
            )){
                Text("Назад")
            }
        }
    }
}