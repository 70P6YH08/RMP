package com.example.labwork16

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labwork16.ui.theme.LabWork16Theme
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.TextStyle
import java.util.Calendar

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork()
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LabWork16Theme {
//        Greeting("Android")
//    }
//}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun LabWork() {
    LabWork16Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                val russoFontFamily = FontFamily(
                    Font(R.font.russoone_regular, FontWeight.Normal)
                )
                var text by remember { mutableStateOf("") }
                Text(
                    text = stringResource(R.string.app_name),
                    Modifier.background(colorResource(R.color.gray)),
                    color = colorResource(R.color.yellow),
                    fontFamily = russoFontFamily
                )
                TextField(
                    text,
                    { text = it },
                    label = { Text(stringResource(R.string.search),
                        fontFamily = russoFontFamily)},
                    modifier = Modifier.height(
                        dimensionResource(
                            R.dimen.search_field_height
                        )
                    )
                )
                Button(onClick = {},
                    modifier = Modifier
                        .height(
                        dimensionResource(
                            R.dimen.button_menu_height
                        )
                    )
                        .width(
                        dimensionResource(
                            R.dimen.button_menu_width
                        )
                    )
                ){ Text(
                        text = stringResource(R.string.menu),
                        color = colorResource(R.color.yellow),
                        fontFamily = russoFontFamily
                    )
                }
                var creatorAList = listOf("Ега", "Пряник")
                creatorAList.forEach { creator ->
                    Text(
                        stringResource(
                            R.string.message,
                            creator, 2026
                        ),
                        Modifier.background(
                            colorResource(R.color.gray)
                        ),
                        color = colorResource(R.color.pink),
                        fontFamily = russoFontFamily
                    )
                }
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                Text(pluralStringResource(R.plurals.hours, R.plurals.hours, hour),
                    Modifier.background(colorResource(R.color.yellow)),
                    color = colorResource(R.color.brown),
                    fontFamily = russoFontFamily)

                Text(pluralStringResource(R.plurals.minutes, R.plurals.minutes, minute),
                    Modifier.background(colorResource(R.color.yellow)),
                    color = colorResource(R.color.brown),
                    fontFamily = russoFontFamily)

                Image(ImageBitmap.imageResource(R.drawable.cat1), "Кот Растр",

                    modifier = Modifier
                        .height(dimensionResource(R.dimen.picture_height))
                        .width(dimensionResource(R.dimen.picture_width))
                        .clip(CircleShape))

                Image(ImageVector.vectorResource(R.drawable.cat), "Кот Вектор",
                    modifier = Modifier
                        .height(dimensionResource(R.dimen.picture_height))
                        .width(dimensionResource(R.dimen.picture_width))
                        .background(colorResource(R.color.cyan)))


            }
        }
    }
}