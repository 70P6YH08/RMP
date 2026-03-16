package com.example.labwork18

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork18.ui.theme.LabWork18Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork18Theme {
//                Task1()
//                Task2()
//                Task3()
//                Task4()
                Task5()
            }
        }
    }
}

@Composable
fun Task1() {
    val randomColor = listOf(
        Color.LightGray,
        Color.Blue, Color.Gray,
        Color.Magenta, Color.Green,
        Color.Green, Color.Yellow,
        Color.Cyan
    )
    var buttonColor by remember { mutableStateOf(Color.Red) }

    var counter by remember { mutableStateOf(0) }

    Row(modifier = Modifier.fillMaxSize().padding(top = 50.dp)) {

        Column {
            Button(onClick = { counter++ }
            ) {
                Text(text = "Button")
            }
            OutlinedButton(onClick = { counter++ }
            ) {
                Text(text = "OutlinedButton")
            }
            TextButton(onClick = { counter++ }
            ) {
                Text(text = "TextButton")
            }
        }

        Column {
            Button(
                onClick = { counter++ },
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
            }
            Button(
                onClick = { counter++ },
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
            }
            Button(
                onClick = { counter++ },
                modifier = Modifier.size(100.dp),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                shape = RoundedCornerShape(100.dp)
            ) {
            }
        }



        Button(
            onClick = {
                buttonColor = randomColor.random()
                counter++
            },
            modifier = Modifier.size(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {

        }

        Text(text = counter.toString())
    }
}

@Composable
fun Task2() {
    val products = listOf(
        "творог",
        "туалетка",
        "йогурт",
        "салфетки",
        "чперма",
        "мыло",
        "вазелин",
        "нож",
        "верёвка",
        "ребёнок (настоящий)",
        "boobsы настоящие",
        "titsы селиконовые",
        "мороженое",
        "сливы",
        "один банан",
        "яблоко одно",
        "баба чай",
        "бэм бэм бэм",
        "chipsi lays with краб"
    )

    var counter by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().padding(top = 50.dp).verticalScroll(rememberScrollState())) {
        Text(text = counter.toString())
        products.forEach { product ->
            Row(
                modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
            ){
                Text(text = product)
                Button(onClick = {counter++}){
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        "корзина"
                    )
                }
            }
        }

    }
}

@Composable
fun Task3() {

    var productName = remember { mutableStateOf("Особенный товар") }
    var productPrice = remember { mutableStateOf(179) }
    var counter by remember { mutableStateOf(0) }
    var totalPrice = remember {mutableStateOf(0)}

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 50.dp).verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Text(text = "Товар: ${productName.value}\n" +
                    "Цена: ${productPrice.value.toString()}")
            IconButton(
                onClick = {
                    counter++
                    totalPrice.value += productPrice.value},
                enabled = counter != 10
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    "добавить"
                )
            }
            IconButton(
                onClick = {
                    counter--
                    totalPrice.value -= productPrice.value
                          },
                enabled = counter != 0
            ){
                Icon(
                    imageVector = Icons.Filled.Delete,
                    "удалить"
                )
            }
        }
        Row{
            Text(text = "Количество особенного товара: ${counter.toString()}\n" +
                    "Итоговая стоимость: ${totalPrice.value.toString()}")
        }

    }
}

@Composable
fun Task4() {
    val products = listOf(
        "123",
        "111",
        "102",
        "02",
        "03",
        "1488",
        "Коля Вата",
        "Шурик Нож",
        "Серёга Ресторан",
        "Абу Дробовик",
        "Боря Гений",
        "Ега Сига",
        "Вован Антоха",
        "Вадик Слива",
        "Карабас Глент",
        "Владик Яблочный",
        "баба чай",
        "бэм бэм бэм",
        "Мистер Крабсбургер"
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        products.forEach { product ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Text(
                    text = product,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .clickable(onClick = {})
                )
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxSize().padding(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(
                Icons.Filled.Call,
                "звонок"
            )
        }
        FloatingActionButton(onClick = {}) {
            Icon(
                Icons.Filled.Email,
                "email"
            )
        }
    }
}

@Composable
fun Task5() {
    val tasks = remember {mutableStateMapOf(
        "поесть" to false,
        "попить" to false,
        "дз сделать" to false,
        "покакать" to false,
        "покушать" to false,
        "погулять" to false,
        "пососать" to  false,
        "полежать" to  false,
        "попрыгать" to  false,
        "полизать" to false,
        "поприседать" to false,
        "попа теть" to false,
        "посушиться" to false,
        "помыться" to false,
        "попа мпиться" to false,
        "помолиться" to false,
        "поглумиться" to false,
        "побэмбэмбэмиться" to false,
        "потупить" to false,
        "поспать" to false
    )
}

    var counter by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        tasks.forEach { (task, state) ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Checkbox(
                    checked = state,
                    onCheckedChange = {tasks[task] = it}
                )
                Text(
                    text = task,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .clickable(onClick = {})
                )
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        ExtendedFloatingActionButton(
            onClick = {
                counter++
                tasks["task ${counter}"] = false
            },
        ) {
            Icon(
                Icons.Filled.Add,
                ""
            )
            Text(text = "Добавить")
        }
    }
}