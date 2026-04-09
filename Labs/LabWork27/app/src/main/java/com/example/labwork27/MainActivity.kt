package com.example.labwork27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labwork27.screens.Authorization
import com.example.labwork27.screens.Profile
import com.example.labwork27.screens.Registration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Authorization()
        }
    }
}

//@Composable
//fun NavRoot() {
//    LabWork27Theme {
//        val navController = rememberNavController()
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            Column(Modifier.padding(innerPadding)) {
//                TrueNavBar(navController)
//                NavHost(navController, startDestination = Screens.HOME.route) {
//                    composable(Screens.HOME.route) {
//                        Registration()
//                    }
//                    composable(Screens.SETTINGS.route) {
//                        Authorization()
//                    }
//                    composable(Screens.SETTINGS.route) {
//                        Profile()
//                    }
//                }
//            }
//        }
//    }
//}

@Composable
fun TrueNavBar(navController: NavController){
    Row(Modifier.fillMaxSize()){
        Button({navController.navigate(Screens.HOME.route)}) {
            Text("Главная")
        }
        Button({navController.navigate(Screens.PROFILE.route)}) {
            Text("Профиль")
        }
        Button({navController.navigate(Screens.SETTINGS.route)}) {
            Text("Настройки")
        }
    }
}

enum class Screens(val route: String){
    HOME("home"),
    PROFILE("profile"),
    SETTINGS("settings"),
}