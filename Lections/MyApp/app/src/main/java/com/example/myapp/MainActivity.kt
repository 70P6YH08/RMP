package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme
import java.util.Calendar

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
    MyAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())) {
                val textSize = 30.sp
                val lang = listOf("Python", "C#", "Kotlin")
                lang.forEach {
                    Text(
                        text = it,
                        fontSize = textSize,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .background(Color.Blue)
                            .padding(5.dp)
                            .background(Color.Red, CircleShape)
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .fillMaxSize()

                            .fillMaxWidth()
                            //.width(300.dp)
                            .height(100.dp)
                            .offset(10.dp, 10.dp)


                    )
                }

                for (l in lang){
                    Text(
                        text = l,
                        fontSize = textSize,
                    )
                }
                val hours = 18
                if (hours < 12){
                    Text("Доблого утличка")
                }
                else{
                    Text("Я вас категорически приветствую")
                }
                Box(modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .shadow(
                        10.dp,
                        RoundedCornerShape(30),
                        spotColor = Color.Blue)
                    .clip(RoundedCornerShape(30))
                    .background(Color.Cyan)
                    .border(
                        2.dp, Color.Red,
                        RoundedCornerShape(30))
                    .clickable{ }
                )
                ModifiedText(modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
fun ModifiedText(modifier: Modifier = Modifier){
    Text("Привет",
        modifier = modifier
            .background(Color.Red)
            .then(modifier))
}



fun getTime(): String{
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