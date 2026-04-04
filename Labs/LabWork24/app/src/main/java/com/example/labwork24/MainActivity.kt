package com.example.labwork24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring.StiffnessHigh
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
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
//            Task2_1()
//            Task3()
//            Task4()
            BasicAnimatedVisibility()
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

    var colorState by remember { mutableStateOf(false)}
    val boxColor = remember { Animatable(Color.Green) }

    var sizeState by remember { mutableStateOf(false)}
    val imageSize = remember { Animatable(100f) }

    var angleState by remember {mutableStateOf(false)}
    val rotated = remember { Animatable(0f) }

    LaunchedEffect(colorState, sizeState, angleState) {
        launch {
            boxColor.animateTo(
                targetValue = (if (colorState == true) Color.Red else Color.Green),
                animationSpec = tween(5000)
            )
        }
        launch {
            imageSize.animateTo(
                targetValue = (if (sizeState == true) 200f else 100f),
                animationSpec = repeatable(
                    iterations = 3,
                    animation = tween(1000),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
        launch {
            rotated.animateTo(
                targetValue = (if (angleState == true) 360f else 0f),
                animationSpec = tween(2000)
            )
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(boxColor.value)
                .clickable{
                    colorState = !colorState
                }
        )
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Image(
            ImageBitmap.imageResource(R.drawable.girl),
            contentDescription = "",
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(imageSize.value.dp)
                .rotate(rotated.value)
                .clickable{
                    angleState = !angleState
                    sizeState = !sizeState
                }
        )
    }
}

@Composable
fun Task3() {
    var isExpanded by remember { mutableStateOf(false) }

    var transition = updateTransition(targetState = isExpanded)

    val imageWidth by transition.animateDp { state ->
        if (state) 100.dp else 300.dp
    }

    val imageHeight by transition.animateDp { state ->
        if (state) 200.dp else 600.dp
    }

    val rotated by transition.animateFloat{ state ->
        if(state) 360f else 0f
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            ImageBitmap.imageResource(R.drawable.banana),
            "banana",
            modifier = Modifier
                .width(imageWidth)
                .rotate(rotated)
                .height(imageHeight)
                .clickable{
                    isExpanded=!isExpanded
                }
        )
    }
}

@Composable
fun Task4() {
    var infiniteTransition = rememberInfiniteTransition()

    val imageSize by infiniteTransition.animateFloat(
        initialValue = 2f,
        targetValue = 2.5f,
        animationSpec = infiniteRepeatable(
            animation =  tween(500),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .graphicsLayer(
                    scaleX = imageSize,
                    scaleY = imageSize
                )
        ) {
            Icon(Icons.Filled.Call, "Звонок")
        }
    }
}

@Composable
fun BasicAnimatedVisibility() {
    var menuState by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FloatingActionButton(
            onClick = { menuState = !menuState }
        ) {
            Icon(Icons.Filled.Menu, "")
        }
        AnimatedVisibility(
            visible = menuState,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                "Настройки",
                fontSize = 30.sp
            )
        }

        AnimatedVisibility(
            visible = menuState,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight }
            ),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight }
            )
        ) {
            Text(
                "Контакты",
                fontSize = 30.sp
            )
        }

        AnimatedVisibility(
            visible = menuState,
            enter = expandIn(expandFrom = Alignment.Center),
            exit = shrinkOut(shrinkTowards = Alignment.Center)
        ) {
            Text(
                "О программе",
                fontSize = 30.sp
            )
        }
    }
}