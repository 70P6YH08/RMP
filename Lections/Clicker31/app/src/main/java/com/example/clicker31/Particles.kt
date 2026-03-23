package com.example.clicker31

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.clicker31.ui.theme.cthulhuTextStyle
import kotlinx.coroutines.delay
import java.sql.RowIdLifetime
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

data class Particle(
    var x: Float,
    var y: Float,
    val speed: Float = Random.nextFloat()*5+2,
    val angle: Float = Random.nextFloat()*2*PI.toFloat(),
    val letter: String = ('A'..'Z').random().toString(),
    var alpha: Float = 1f,
    var lifetime: Float = 1f
){
    var speedX = cos(angle)*speed
    var speedY = sin(angle)*speed

    fun update(){
        x+=speedX
        y+=speedY
        alpha -=0.02f
        lifetime -=0.02f
    }
}

@Composable
fun ParticleAnimation(particles: MutableList<Particle>){
    var invalidate by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        while (true){
            delay(16L) //16 милисекунд = 60 кадров в секунду
            particles.removeAll{
                it.update()
                it.lifetime <= 0
            }
            invalidate = !invalidate
        }
    }

    val textMeasurer = rememberTextMeasurer()

    Canvas(modifier = Modifier.fillMaxSize()){
        invalidate.let{
            for(part in particles){
                val text = textMeasurer.measure(
                    text = part.letter,
                    cthulhuTextStyle
                )

                drawText(
                    text,
                    color = Color(
                        0.38f,
                        0.96f,
                        0.86f,
                        part.alpha
                    ),
                    topLeft = Offset(part.x, part.y),
                    shadow = Shadow(Color.Black,
                        Offset(x = 5f, y = 5f), //дальность теней
                        blurRadius = 10f)
                )
            }
        }
    }
}