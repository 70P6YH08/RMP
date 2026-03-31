package com.example.labwork24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring.StiffnessHigh
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Task1_1()
//            Task1_2()
//            Task1_3()
//            Task1_4()
//            Task1_5()
            Task2_1()
        }
    }
}

@Composable
fun Task1_1() {

    var boxColor by remember { mutableStateOf(Color.Gray) }
    val animateColor: Color by animateColorAsState(
        targetValue = boxColor,
        animationSpec = tween(3000)
    )

    var count by remember { mutableStateOf(0) }

    Column(
        Modifier
            .padding(top = 300.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(200.dp)
                .background(animateColor)
                .clickable {
                    if (count % 2 == 0) {
                        boxColor = Color.Green
                    }
                    if (count % 2 == 1) {
                        boxColor = Color.Red
                    }
                    count++
                }
        )
    }
}

@Composable
fun Task1_2() {

    var boxColor by remember { mutableStateOf(Color.Green) }
    val animateColor: Color by animateColorAsState(
        targetValue = boxColor,
        animationSpec = keyframes {
            Color.Black at 10000 / 4
            Color.Magenta at 10000 / 2
            Color.Yellow at 10000 / (4 / 3)
            durationMillis = 10000
        }
    )

    Column(
        Modifier
            .padding(top = 300.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .size(200.dp)
                .background(animateColor)
                .clickable {
                    boxColor = Color.Red
                }
        )
    }
}

@Composable
fun Task1_3() {

    var imageSize by remember {mutableStateOf(200.dp)}
    val animateImage by animateDpAsState(
        targetValue = imageSize,
        animationSpec = repeatable(
            iterations = 3,
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        Modifier
            .padding(top = 300.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            ImageBitmap.imageResource(R.drawable.banana),
            "banana",
            modifier = Modifier
                .size(animateImage)
                .clickable{
                    imageSize = Random.nextInt(50..500).dp
                }
        )
    }
}

@Composable
fun Task1_4() {

    var imageSize by remember {mutableStateOf(200.dp)}
    val animateImage by animateDpAsState(
        targetValue = imageSize,
        animationSpec = spring(
            dampingRatio = 0.2f,
            stiffness = StiffnessHigh
        )
    )

    Column(
        Modifier
            .padding(top = 300.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            ImageBitmap.imageResource(R.drawable.banana),
            "banana",
            modifier = Modifier
                .size(animateImage)
                .clickable{
                    imageSize = Random.nextInt(50..500).dp
                }
        )
    }
}

@Composable
fun Task1_5() {

    var boxColor by remember {mutableStateOf(Color.Green)}
    val animateColor : Color by animateColorAsState(
        targetValue = boxColor,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        Modifier
            .padding(top = 300.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(animateColor)
                .clickable {
                    boxColor = Color.Red
                }
        )
    }
}

@Composable
fun Task2_1() {

    var boxColor = remember { Animatable(Color(0f,0f,0f))}
    LaunchedEffect(Unit) {
        boxColor.animateTo(targetValue = 100f, animationSpec = tween(2000))
    }

    Column(
        Modifier
            .padding(top = 300.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    boxColor = Color.Red
                }
        )
    }
}
