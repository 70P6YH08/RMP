package com.example.labwork28

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork28.screens.InsertBook
import com.example.labwork28.screens.SelectBook
import com.example.labwork28.screens.UpdateBook
import com.example.labwork28.ui.theme.LabWork28Theme

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
    LabWork28Theme {
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