package com.example.animation2

import android.R
import android.opengl.Visibility
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animation2.ui.theme.Animation2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Animation2Theme {
                Scaffold(modifier = Modifier.fillMaxSize().padding(top=50.dp)) {
                    Column()
                    {
//                        VisibilityAnimationExample()
//                        UpdateTransitionExample()
                        InfiniteTransitionExample()
                    }
                }
            }
        }
    }
}

@Composable
fun VisibilityAnimationExample() {
    var isVisible by remember { mutableStateOf(true) }

    Button({isVisible = !isVisible}){
        Text(text = "Click")
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(tween(1000)) + scaleIn(),
        exit = fadeOut(tween(1000)) + scaleOut()
    ) {
        Box(
            Modifier
                .size(200.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun UpdateTransitionExample() {
    var isExpanded by remember { mutableStateOf(false) }

    var transition = updateTransition(targetState = isExpanded)

    val size by transition.animateDp { state ->
        if (state) 150.dp else 100.dp
    }

    val color by transition.animateColor { state ->
        if (state) Color.Yellow else Color.LightGray
    }

    Box(
        Modifier
            .size(size)
            .background(color)
            .clickable{isExpanded=!isExpanded}
    )
}

@Composable
fun InfiniteTransitionExample(){
    val transition = rememberInfiniteTransition()

    val scale by transition.animateFloat(
        initialValue = 10f,
        targetValue = 11f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(Modifier.fillMaxSize()){
        Icon(Icons.Filled.Favorite,
            "",
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale
                ),
            tint = Color.Red
        )
    }
}