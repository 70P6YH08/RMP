package com.example.lab15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab15.ui.theme.Lab15Theme
import screens.Authorization
import screens.Registration
import screens.UserProfile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab15Theme {
                var current by remember {mutableStateOf(Screens.AUTHORIZATION)}
                    when (current){
                        Screens.AUTHORIZATION -> Authorization(
                            onRegistrationClick = {current = Screens.REGISTRATION},
                            onUserProfileClick = {current = Screens.USERPROFILE})
                        Screens.REGISTRATION -> Registration(
                            onAuthorizationClick = {current = Screens.AUTHORIZATION})
                        Screens.USERPROFILE -> UserProfile(
                            onAuthorizationClick = {current = Screens.AUTHORIZATION})
                }
            }
        }
    }
}
enum class Screens() {
    AUTHORIZATION,
    REGISTRATION,
    USERPROFILE}