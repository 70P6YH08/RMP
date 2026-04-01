package com.example.labwork23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork23.screens.Search
import com.example.labwork23.screens.ShoppingCart
import com.example.labwork23.screens.UserProfile
import com.example.labwork23.ui.theme.LabWork23Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork23Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp),
                    topBar = {
                        Button(
                            onClick = {},
                        ) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = "",
                                modifier = Modifier
                                    .align(Alignment.Top)
                            )
                        }
                    }
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        NavBar()
                    }
                }
            }
        }
    }
}

@Composable
fun NavBar() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.SEARCH.route) {
        composable("search") {
            Search(
                onUserProfileScreen = { navController.navigate("userprofile") },
                onShoppingCartScreen = { navController.navigate("shoppingcart") }
            )
        }
        composable("userprofile") {
            UserProfile(
                onSearchScreen = { navController.navigate("search") },
                onShoppingCartScreen = { navController.navigate("shoppingcart") }
            )
        }

        composable("shoppingcart") {
            ShoppingCart(
                onSearchScreen = {navController.navigate("search")},
                onUserProfileScreen = {navController.navigate("userprofile")}
            )
        }
    }
}

enum class Screens(val route: String){
    SEARCH("search")
}

//Row(Modifier.padding(vertical = 5.dp, horizontal = 5.dp)) {
//    Button(onClick = {}) {
//        Icon(Icons.Filled.Search, "")
//    }
//    Spacer(Modifier.weight(1f))
//    Button(onClick = {}) {
//        Icon(Icons.Filled.ShoppingCart, "")
//    }
//    Spacer(Modifier.weight(1f))
//    Button(onClick = {}) {
//        Icon(Icons.Filled.AccountCircle, "")
//    }
//}