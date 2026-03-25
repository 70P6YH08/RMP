package com.example.labwork22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork22.ui.theme.LabWork22Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Task1()
//            Task2()
//            Task3()
            Task4()
        }
    }
}

@Composable
fun Task1() {
    var state by remember { mutableStateOf(false)}
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(all = 30.dp)) {
        if(state == false){
            CircularProgressIndicator()
        }
        else{
            CircularProgressIndicator(progress = {progress})
        }
        Button({
            state = !state
            scope.launch {
                while (state == true){
                    delay(10)
                    progress+=0.001f
                }
            }
        }) {
            Text(text = "Скачать")
        }
    }
}

@Composable
fun Task2() {
    var state1 by remember { mutableStateOf(false)}
    var state2 by remember { mutableStateOf(false)}
    var state3 by remember { mutableStateOf(false)}
    var progress1 by remember { mutableStateOf(0.0f) }
    var progress2 by remember { mutableStateOf(0.0f) }
    var progress3 by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .padding(top = 50.dp)
        .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(bottom = 20.dp)) {
                LinearProgressIndicator(
                    progress = { progress1 },
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Green
                )
                Text(text = "%.2f".format(progress1 * 100) + "%")
        }
        Column(modifier = Modifier.padding(bottom = 20.dp)) {
            LinearProgressIndicator(
                progress = { progress2 },
                modifier = Modifier.fillMaxWidth(),
                color = Color.Yellow
            )
            Text(text = "%.2f".format(progress2 * 100) + "%")

        }
        Column(modifier = Modifier.padding(bottom = 20.dp)) {
                LinearProgressIndicator(
                    progress = { progress3 },
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Red
                )
                Text(text = "%.2f".format(progress3 * 100) + "%")

        }
        Button({
            state1 = !state1
            scope.launch {
                while (state1 == true && progress1 < 1f){
                    delay(100)
                    progress1+=Random.nextFloat() / 100
                }
            }
            state2 = !state2
            scope.launch {
                while (state2 == true && progress2 < 1f){
                    delay(100)
                    progress2+=Random.nextFloat() / 100
                }
            }
            state3 = !state3
            scope.launch {
                while (state3 == true && progress3 < 1f){
                    delay(100)
                    progress3+=Random.nextFloat() / 100
                }
            }
        }) {
            Text(text = "Скачать")
        }
    }
}

@Composable
fun Task3() {
    var state by remember { mutableStateOf(false)}
    var progress by remember { mutableStateOf(1.0f) }
    val scope = rememberCoroutineScope()
    var seconds by remember { mutableStateOf(60) }
    var colorIndicator by remember { mutableStateOf(Color.Green) }

    Column(modifier = Modifier.padding(top = 50.dp).padding(horizontal = 30.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 20.dp)
        ){
            CircularProgressIndicator(
                progress = {progress},
                modifier = Modifier
                    .size(100.dp),
                color = colorIndicator,
                trackColor = Color.Gray,
                strokeWidth = 5.dp,
                strokeCap = StrokeCap.Square,
                gapSize = 0.dp
            )
            Text(
                text = "${seconds} секунд осталось",
                fontSize = 35.sp
            )
        }

        Button({
            state = !state
            scope.launch {
                while (state == true && seconds > 0){
                    delay(100)
                    progress-=1/60f
                    seconds-=1
                    if(seconds < 30 && seconds >= 10){
                        colorIndicator = Color.Yellow
                    }
                    else if(seconds < 10 && seconds >= 0){
                        colorIndicator = Color.Red
                    }
                }
            }
        }) {
            Text(text = "Старт")
        }
    }
}

@Composable
fun Task4() {
    var counter by remember { mutableStateOf(0) }
    var state by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(horizontal = 20.dp)
    ) {
        if (state == true) {
            counter = 0
            AlertDialog(
                onDismissRequest = {
                    state = false
                },
                title = { Text(text = "Уведомление") },
                text = { Text("Все сообщения прочитаны") },
                confirmButton = {
                    Button({
                        state = false
                    }) {
                        Text("OK", fontSize = 22.sp)
                    }
                }
            )
        }
        BadgedBox({
            if (counter > 0) {
                Badge(
                    contentColor = Color.Green,
                    containerColor = Color.Black
                ) {
                    Text(
                        text = counter.toString()
                    )

                }
            }
        }) {
            FloatingActionButton({
                state = !state
            }) {
                Icon(Icons.Default.MailOutline, "")
            }
        }
        Button(onClick = {
            counter += Random.nextInt(1, 100)
        }) {
            Text(
                text = "Обновить",
                fontSize = 16.sp
            )
        }
    }
}