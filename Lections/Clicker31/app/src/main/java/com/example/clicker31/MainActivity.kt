package com.example.clicker31

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.mutableDoubleListOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clicker31.ui.theme.Clicker31Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Clicker31Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GameScreen(vm : GameViewModel){
    Box(modifier = Modifier.fillMaxSize()){
        val particles = remember { mutableStateListOf<Particle>() }
        Box(modifier = Modifier
            .size(300.dp)
            .clip(CircleShape)
            .align(Alignment.Center)
            .clickable{
                vm.onTap()
                repeat(5){
                    particles.add(Particle(x = 50f, y = 50f))
                }
            }
        ){
            Image(painterResource(
                R.drawable.cthulhu_star),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize()
            )
            Image(painterResource(
                R.drawable.cthulhu),
                contentDescription = "Cthulhu",
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .align(Alignment.Center)
            )
        }
        ParticleAnimation(particles)
    }
}