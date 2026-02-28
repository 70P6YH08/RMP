package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)){
                        Text(stringResource(R.string.welcome),
                            fontSize = 30.sp,
                            modifier = Modifier.width(
                                dimensionResource(R.dimen.header_width)
                            ).background(
                                colorResource(R.color.purple_200)
                            )
                        )
                        Text(stringResource(R.string.hello,
                            "Roman", 23
                        ))
                        Button({}){
                            Text(stringResource(R.string.login_button))
                        }

                        Text(pluralStringResource(R.plurals.cats,
                            1, 1))
                        Text(pluralStringResource(R.plurals.cats,
                            3, 3))
                        Text(pluralStringResource(R.plurals.cats,
                            15, 15))

                        Image(ImageBitmap.imageResource(R.drawable.bal),
                            "Ноги")
                        Image(
                            ImageVector.vectorResource(R.drawable.picture),
                            "картинка",
                            modifier = Modifier.size(200.dp))
//                        Image(
//                            Icons.Outlined.Home,
//                            "картинка",
//                            modifier = Modifier.size(200.dp))

                        val russoFontFamily = FontFamily(
                            Font(R.font.russoone_regular, FontWeight.Normal)
                        )

                        stringArrayResource(R.array.lang)
                    }
                }
            }
        }
    }
}