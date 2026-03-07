package com.example.labwork15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork15.ui.theme.LabWork15Theme
import screens.Authorization
import screens.Registration
import screens.UserProfile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork15Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            var current = remember {mutableStateOf(Screen.Authorization)}

            when (current.value){
                Screen.Authorization -> Authorization(
                    onAuthorizationClick = { current.value = Screen.UserProfile},
                    onRegistrationClick = { current.value = Screen.Registration})
                Screen.Registration -> Registration(
                    { current.value = Screen.Authorization}
                )
                Screen.UserProfile -> UserProfile(
                { current.value = Screen.Authorization}
                )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork15Theme {
        Greeting("Android")
    }
}

enum class Screen { Authorization, Registration, UserProfile }
