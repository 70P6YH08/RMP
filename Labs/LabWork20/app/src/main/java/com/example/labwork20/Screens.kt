package com.example.labwork20

import android.R.attr.clickable
import android.hardware.display.DeviceProductInfo
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Authorization(
    onListProduct : () -> Unit,
    onRegistration : () -> Unit,
    onBack : () -> Unit
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Button(
        onClick = { onBack() },
        modifier = Modifier
            .padding(top = 30.dp, start = 10.dp)
    ) {
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = "Вернуться назад"
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Авторизация",
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Column {
            Text(
                text = "Логин",
                modifier = Modifier.align(Alignment.Start)
            )
            TextField(
                value = login,
                onValueChange = { login = it },
                label = { Text(text = "Логин") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Unspecified),
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }

        Column {
            Text(
                text = "Пароль",
                modifier = Modifier.align(Alignment.Start)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Пароль") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }

        Row{
            Button(
                onClick = { onListProduct()},
                modifier = Modifier.padding(end = 100.dp)
            ) {
                Text(text = "Ок")
            }

            Button(onClick = { onRegistration() }
            ) {
                Text(text = "Регистрация")
            }
        }
    }
}

@Composable
fun Registration(onAuthorization : () -> Unit) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberPassword by remember { mutableStateOf("") }

    Button(
        onClick = {onAuthorization()},
        modifier = Modifier
            .padding(top = 30.dp, start = 10.dp)
        ) {
        Icon(Icons.Filled.ArrowBack,
            contentDescription = "Вернуться назад")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Регистрация",
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Column {
            Text(text = "Логин",
                modifier = Modifier.align(Alignment.Start))
            TextField(
                value = login,
                onValueChange = { login = it },
                label = { Text(text = "Логин") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Unspecified),
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }

        Column {
            Text(
                text = "Пароль",
                modifier = Modifier.align(Alignment.Start)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Пароль") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }

        Column{
            Text(text = "Подтверждение пароля")
            TextField(
                value = rememberPassword,
                onValueChange = { rememberPassword = it },
                label = { Text(text = "Подтвердите пароль") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
        Button(
            onClick = {onAuthorization()}
        ){
            Text(text = "Ок")
        }
    }
}



@Composable
fun ListProduct(
    onPrintProduct : (String, Int) -> Unit,
    onAuthorization: () -> Unit) {
    var products = mapOf(
        "творог" to 209,
        "не хочу" to 123,
        "миньон" to 52,
        "банан" to 62,
        "ок" to 72,
        "шапка" to 82,
        "варежки?" to 92,
        "можно и санки купить!?" to 102,
        "а так же сникерс!!!!" to 112,
        "жаропонижающие таблетки" to 122
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp, start = 10.dp)
    ){
        Button(onClick = {onAuthorization()}) {
            Icon(Icons.Filled.ArrowBack,
                contentDescription = "Вернуться назад")
        }
        Text(
            text = "Список товаров:",
            fontSize = 25.sp
        )
        products.forEach { (productName, productPrice) ->
            Row(){
                Text(text = " - $productName, $productPrice",
                    modifier = Modifier
                        .clickable{onPrintProduct(productName, productPrice)}
                )
            }
        }
    }
}

@Composable
fun PrintProduct(
    onListProduct: () -> Unit,
    productName : String, productPrice : Int
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp, start = 10.dp)
    ){
        Button(onClick = {onListProduct()}) {
            Icon(Icons.Filled.ArrowBack,
                contentDescription = "Вернуться назад")
        }
        Text(text = "Товар", fontSize = 25.sp)
        Text(text = "Название: ${productName}")
        Text(text = "Цена: ${productPrice}")
    }
}


