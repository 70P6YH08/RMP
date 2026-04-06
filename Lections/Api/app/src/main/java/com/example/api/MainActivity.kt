package com.example.api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.api.data.MarsRepository
import com.example.api.ui.theme.ApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(vm : MainViewModel = viewModel()){
    ApiTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            if (vm.list.isNotEmpty()){
                LazyColumn(
                    modifier = Modifier.padding(innerPadding)
                ){
                    items(vm.list){
                        Text(it.imgSrc)
                    }
                }
            }

        }
    }
}