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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork27.screens.Authorization
import com.example.labwork27.screens.Profile
import com.example.labwork27.screens.Registration
import com.example.labwork27.ui.theme.LabWork27Theme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavRoot()
        }
    }
}

@Composable
fun NavRoot() {
    LabWork27Theme {
        val navController = rememberNavController()
        val viewModel: UserViewModel = viewModel()
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                NavHost(navController, startDestination = "authorization") {
                    composable("registration") {
                        Registration(
                            vm = viewModel,
                            onAuthorization = { navController.navigate("authorization") },
//                            onProfile = { login, password ->
//                                navController.navigate("profile/$login/$password")
//                            },
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable("authorization") {
                        Authorization(
                            vm = viewModel,
                            onRegistration = { navController.navigate("registration") },
                            onProfile = { login, password ->
                                navController.navigate("profile/$login/$password") },
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable("profile/{login}/{password}",
                        arguments = listOf(
                            navArgument("login") { type = NavType.StringType },
                            navArgument("password") { type = NavType.StringType }
                        )
                    ) { stack ->
                        val login = stack.arguments?.getString("login")!!
                        val password = stack.arguments?.getString("password")!!
                        Profile(
                            vm = viewModel,
                            onAuthorization = { navController.navigate("authorization") },
                            onBack = { navController.popBackStack() },
                            password = password,
                            login = login
                        )
                    }
                }
            }
        }
    }
}
