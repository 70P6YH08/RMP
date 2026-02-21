package com.example.myapplication

import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)
                .verticalScroll(rememberScrollState())) {
                val textSize = 30.sp
                val lang = listOf("Python", "C#", "Kotlin")
                lang.forEach{
                    Text(
                        text = it,
                        fontSize = textSize,
                        textAlign = TextAlign.Center
                                modifier = Modifier
                                .background(Color.Blue)
                            .padding(5.dp)
                            .background(Color.Red, CircleShape)
                            .fillMaxWidth()
//                          .width(300.dp)
                            .height(100.dp)
                    )
                }

//                for (i in 1..10) {
//                    Text(
//                        text = getTime(),
//                        fontSize = 25.sp
//                    )
//                }

                val hours = 10;
                if (hours < 12){
                    Text("Доблого утличка")
                }
                else {
                    Text("Я вас приветствую")
                }
            }
        }
    }
}

fun getTime() : String{
    val calendar = Calendar.getInstance()
    val hours = calendar.get(Calendar.HOUR_OF_DAY)
    val minutes = calendar.get(Calendar.MINUTE)

    return "$hours:$minutes"
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting()
}