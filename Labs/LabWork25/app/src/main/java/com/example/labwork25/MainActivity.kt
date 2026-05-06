package com.example.labwork25

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labwork25.ui.theme.LabWork25Theme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LicenseAgreementScreen()
        }
    }
}

@Composable
fun LicenseAgreementScreen(){
    var state by remember { mutableStateOf(false) }
    val text = File("eula.txt").readText()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        Text(text = text)
        Column(
            modifier = Modifier.padding(5.dp)
        ){
            Row(){
                Checkbox(
                    onCheckedChange = {state = it},
                    checked = state
                )
                Text(text = "Я прочитал условия лицензионного соглашения")
            }

            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Button({},
                enabled = state
            ){
                Text(text = "Принять")
            }
        }
    }
}