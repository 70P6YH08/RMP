package com.example.labwork20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork20.ui.theme.LabWork20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork20Theme {
                NavBar()
//                Authorization()
//                Registration()
//                ListProduct()
//                PrintProduct("творог", 209)
            }
        }
    }
}

@Composable
fun NavBar() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.AUTHORIZATION.route) {
        composable("authorization") {
            Authorization(
                onListProduct = { navController.navigate("products") },
                onRegistration = { navController.navigate("registration") }
            )
        }
        composable("registration") {
            Registration(
                onAuthorization = { navController.navigate("authorization") },
            )
        }

        composable("products") {
            ListProduct(
                onPrintProduct = {navController.navigate("product/{id}")}
            )
        }
        composable("product/{id}") {
            PrintProduct("Егор", 120)
        }
    }
}

enum class Screens(val route: String){
    AUTHORIZATION("authorization"),
}