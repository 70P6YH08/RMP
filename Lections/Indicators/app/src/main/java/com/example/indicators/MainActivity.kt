package com.example.indicators

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.indicators.ui.theme.IndicatorsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndicatorsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()
//    LaunchedEffect(Unit){
//        while (progress < 0){
//            delay(300)
//        }
//    }

    Column(modifier) {
        CircularProgressIndicator(
            progress = { progress },
            color = ProgressIndicatorDefaults.circularColor,//цвет заполняющегося индикатора
            modifier = Modifier.size(100.dp),
            strokeWidth = 10.dp,
            trackColor = Color.Yellow, //незаполненная полоса
            strokeCap = StrokeCap.Square, // форма разрыва,
            gapSize = 0.dp //длина разрыва
        )
        LinearProgressIndicator(
            progress = { progress },
            color = ProgressIndicatorDefaults.circularColor,//цвет заполняющегося индикатора
            modifier = Modifier.size(100.dp, 10.dp),
            trackColor = Color.Yellow, //незаполненная полоса
            strokeCap = StrokeCap.Square, // форма разрыва,
            gapSize = 0.dp //длина разрыва
        )
        Button({
            scope.launch {
                while (progress < 1f) {
                    delay(30)
                    progress += 0.01f
                }
            }
        }) {
            Text(text = "Далее")
        }

        var messages by remember { mutableStateOf(0) }
        BadgedBox({
            Badge(modifier = Modifier.align(Alignment.BottomEnd)) {
                Text(text = messages.toString())
            }
        }) {
            FloatingActionButton({}) {
                Icon(Icons.Default.Email, "")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IndicatorsTheme {
        Greeting()
    }
}