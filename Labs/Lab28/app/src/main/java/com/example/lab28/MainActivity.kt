package com.example.lab28

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
import com.example.lab28.screens.InsertBook
import com.example.lab28.screens.SelectBook
import com.example.lab28.screens.UpdateBook
import com.example.lab28.ui.theme.Lab28Theme

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
    Lab28Theme {
        val navController = rememberNavController()
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                NavHost(navController, startDestination = "selectScreen") {
                    composable("selectScreen") {
                        SelectBook(
                            onInsertScreen = { navController.navigate("insertScreen") },
                            onUpdateScreen = { id, title, author, year, pages ->
                                navController.navigate("updateScreen/$id/$title/$author/$year/$pages") },
                        )
                    }
                    composable("insertScreen") {
                        InsertBook(
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable(
                        "updateScreen/{id}/{title}/{author}/{year}/{pages}",
                        arguments = listOf(
                            navArgument("id") { NavType.IntType },
                            navArgument("title") { NavType.StringType },
                            navArgument("author") { NavType.StringType },
                            navArgument("year") { NavType.IntType },
                            navArgument("pages") { NavType.IntType },
                        )
                    ) { stack ->
                        val id = stack.arguments?.getString("id")!!
                        val title = stack.arguments?.getString("title")!!
                        val author = stack.arguments?.getString("author")!!
                        val year = stack.arguments?.getString("year")!!
                        val pages = stack.arguments?.getString("pages")!!
                        UpdateBook(
                            onBack = { navController.popBackStack() },
                            id = id,
                            title = title,
                            author = author,
                            year = year,
                            pages = pages
                        )
                    }
                }
            }
        }
    }
}

enum class QueryScreens(val route : String){
    SELECT("selectScreen"),
    INSERT("insertScreen"),
    DELETE("deleteScreen"),
    UPDATE("updateScreen")
}