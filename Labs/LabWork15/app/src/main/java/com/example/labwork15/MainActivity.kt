package com.example.labwork15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.labwork15.ui.theme.LabWork15Theme
import screens.Authorization
import screens.Registration
import screens.UserProfile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var current by remember {mutableStateOf(Screens.AUTHORIZATION)}
            LabWork15Theme {
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


//@Composable
//fun NavRoot() {
//    var current by remember {mutableStateOf("authorization")}
//    LabWork15Theme {
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            Column(Modifier.padding(innerPadding)) {
//                Authorization(
//                    onRegistrationClick = {current = Screen.REGISTRATION.route},
//                    onAuthorizationClick = {current = Screen.AUTHORIZATION.route}
//                )
//                Registration(
//                    onAuthorizationClick = {current = Screen.AUTHORIZATION.route}
//                )
//                UserProfile(
//                    onAuthorizationClick = {current = Screen.AUTHORIZATION.route}
//                )
//
//                when (current){
//                    Screen.AUTHORIZATION.route -> Authorization(
//                        onRegistrationClick = {current = Screen.REGISTRATION.route},
//                        onAuthorizationClick = {current = Screen.AUTHORIZATION.route})
//                    Screen.REGISTRATION.route -> Registration(
//                        onAuthorizationClick = {current = Screen.AUTHORIZATION.route})
//                    Screen.USERPROFILE.route -> UserProfile(
//                        onAuthorizationClick = {current = Screen.AUTHORIZATION.route})
//                }
//            }
//        }
//    }
//}

enum class Screens() {
    AUTHORIZATION,
    REGISTRATION,
    USERPROFILE}
