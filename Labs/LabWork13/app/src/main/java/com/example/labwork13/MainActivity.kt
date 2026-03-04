package com.example.labwork13

import android.R
import android.R.attr.onClick
import android.os.Bundle
import android.widget.Button
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork13.ui.theme.LabWork13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork13Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "ispp-31",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Task2Column()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(1f)) {
        Text(
            "Hello $name!",
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            color = Color.Blue,
            modifier = modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork13Theme {
        Greeting("ispp-31")
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Column() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Добро пожаловать",
            fontSize = 20.sp,
            color = Color.Blue
        )
        Button(onClick = {}) {
            Text(text = "ОК")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Row() {
    Row(Modifier.fillMaxSize()) {
        Text(
            text = "Добро пожаловать",
            fontSize = 20.sp,
            color = Color.Blue
        )
        Button(onClick = {}) {
            Text(text = "ОК")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Box() {
    Box(Modifier.fillMaxSize()) {
        Text(
            text = "Добро пожаловать",
            fontSize = 20.sp,
            color = Color.Blue,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Button({}, modifier = Modifier.align(Alignment.TopEnd)) {
            Text(text = "ОК")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Box() {
    Box(Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text("",
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Red))
        Text("",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Cyan))
        Text("",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .width(100.dp)
                .height(200.dp)
                .background(Color.DarkGray))
        Text("",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Green))
        Text("",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Magenta))
        Text("",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Blue))
        Text("",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Gray))
        Text("",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .width(100.dp)
                .height(200.dp)
                .background(Color.Yellow))
        Text("",
            modifier = Modifier
                .align(Alignment.Center)
                .width(300.dp)
                .height(700.dp)
                .background(Color.Black))
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Column() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "5%",
            color = Color.White,
            modifier = Modifier
                .weight(5f)
                .background(Color.Red)
                .fillMaxWidth()
        )
        Text(
            text = "15%",
            color = Color.White,
            modifier = Modifier
                .weight(15f)
                .background(Color.Green)
                .fillMaxWidth()
            )
        Text(
            text = "30%",
            color = Color.White,
            modifier = Modifier
                .weight(30f)
                .background(Color.Blue)
                .fillMaxWidth()
        )
        Text(
            text = "50%",
            color = Color.White,
            modifier = Modifier
                .weight(50f)
                .background(Color.Yellow)
                .fillMaxWidth()
        )
    }
}