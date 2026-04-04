package com.example.lab23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.collection.emptyLongSet
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.lab23.screens.Bank
import com.example.lab23.screens.Search
import com.example.lab23.screens.Bank
import com.example.lab23.screens.UserProfile
import com.example.lab23.ui.theme.Lab23Theme
import androidx.compose.material3.*
import com.example.lab23.ui.theme.ColorStyle

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }
            var isUserDarkTheme by remember { mutableStateOf(true) }
            Lab23Theme(darkTheme = isDarkTheme,
                colorStyle = if (isUserDarkTheme)
                    ColorStyle.USER
                else
                    ColorStyle.DEFAULT
            ) {
                var currentScreen by remember { mutableStateOf("bank") }
                var dropDownMenuState by remember { mutableStateOf(false) }
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Магаз")
                            },
                            navigationIcon = {
                                IconButton(
                                    { dropDownMenuState = true }
                                ) {
                                    Icon(
                                        Icons.Filled.Menu,
                                        contentDescription = "",
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = { isDarkTheme = !isDarkTheme }
                                ) {
                                    Icon(
                                        if (isDarkTheme == true)
                                            Icons.Default.Favorite
                                        else
                                            Icons.Default.FavoriteBorder,
                                        contentDescription = "",
                                    )
                                }
                                IconButton(
                                    onClick = { isUserDarkTheme = !isUserDarkTheme }
                                ) {
                                    Icon(
                                        if (isUserDarkTheme == true)
                                            Icons.Default.Person
                                        else
                                            Icons.Default.AccountCircle,
                                        contentDescription = "",
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    DropdownMenu(
                        expanded = dropDownMenuState,
                        onDismissRequest = { dropDownMenuState = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Поиск") },
                            onClick = {
                                currentScreen = "search"
                                dropDownMenuState = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Профиль") },
                            onClick = {
                                currentScreen = "userprofile"
                                dropDownMenuState = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Банк") },
                            onClick = {
                                currentScreen = "bank"
                                dropDownMenuState = false
                            }
                        )
                    }
                    Column(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            "search" -> Search()
                            "userprofile" -> UserProfile()
                            "bank" -> Bank()
                        }
                    }
                }
            }
        }
    }
}