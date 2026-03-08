package com.example.navigation

import android.os.Bundle
import android.provider.ContactsContract
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun NavRoot(){
    var current by remember { mutableStateOf("home") }
    NavigationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                NavBar(
                    onClickHome = {current = "home"},
                    onClickProfile = {current = "profile"},
                    onClickSettings = {current = "settings"}
                )
                when(current){
                    "home" -> Home()
                    "profile" -> Profile()
                    "settings" -> Settings()
                }
            }
        }
//        Screens.HOME.route
//        Screens1.Home.route
    }
}

//@Composable
//fun TrueNavRoot(){
//    val navController = rememberNavController()
//    NavigationTheme {
//        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            Column(Modifier.padding(innerPadding)) {
//                TrueNavBar(navController)
//                NavHost(navController, startDestination = Screens.HOME.route){
//                    composable(Screens.HOME.route){
//                        Home()
//                    }
//                    composable("profile/{id}",
//                        arguments = listOf(
//                            navArgument("id"){type = NavType.IntType}
//                        )
//                    ){ stack ->
//                        Profile(stack.arguments?.getInt("id")!!)
//                    }
//                    composable(Screens.SETTINGS.route){
//                        Settings()
//                    }
//                }
//            }
//        }
//    }
//}

//@Composable
//fun TrueNavBar(navController: NavController){
//    Row(Modifier.fillMaxSize()){
//        Button({navController.navigate(Screens.HOME.route)}) {
//            Text("Главная")
//        }
//        Button({navController.navigate(Screens.PROFILE.route)}) {
//            Text("Профиль")
//        }
//        Button({navController.navigate(Screens.SETTINGS.route)}) {
//            Text("Настройки")
//        }
//    }
//}

enum class Screens(val route: String){
    HOME("home"),
    PROFILE("profile"),
    SETTINGS("settings"),
}

//sealed class Screens1(val route: String){
//    object Home : Screens1("home")
//    object Profile : Screens1("profile")
//    object Settings : Screens1("settings")
//}

@Composable
fun NavBar(onClickHome: () -> Unit,
            onClickProfile: () -> Unit,
           onClickSettings: () -> Unit){
    Row(Modifier.fillMaxSize()){
        Button({onClickHome}) {
            Text("Главная")
        }
        Button({onClickProfile}) {
            Text("Профиль")
        }
        Button({onClickSettings}) {
            Text("Настройки")
        }
    }
}



@Composable
fun Home(){
    Text("Главная")
}

@Composable
fun Profile(id:Int = 0){
    Text("Профиль: $id")
}

@Composable
fun Settings(){
    Text("Настройки")
}