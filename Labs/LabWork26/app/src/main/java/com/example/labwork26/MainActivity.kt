package com.example.labwork26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labwork26.ui.theme.LabWork26Theme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork26Theme {
                PrintUserInfo()
            }
        }
    }
}

@Composable
fun PrintUserInfo(viewModel: ListUsersViewModel = viewModel()) {
    var userLogin by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(top = 40.dp, bottom = 10.dp)
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Не все поля заполнены",
            modifier = Modifier
                .alpha(
                    if (userLogin.isEmpty() ||
                        userPassword.isEmpty() ||
                        userEmail.isEmpty()
                    )
                        1f
                    else
                        0f
                )
        )
        TextField(
            value = userLogin,
            onValueChange = { userLogin = it },
            maxLines = 1,
            label = { Text(text = "Login") },
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = userPassword,
            onValueChange = { userPassword = it },
            maxLines = 1,
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = userEmail,
            onValueChange = { userEmail = it },
            maxLines = 1,
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Button(
            onClick = {
                viewModel.addUser(
                    userLogin,
                    userPassword,
                    userEmail
                )
            },
            enabled =
                if (userLogin.isEmpty() ||
                    userPassword.isEmpty() ||
                    userEmail.isEmpty()
                )
                    false
                else
                    true
        ) {
            Text(text = "Добавить")
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 300.dp, bottom = 40.dp)
            .border(border = BorderStroke(1.dp, Color.Green))
    ) {
        items(viewModel.users) { item ->
            Text(
                text = item.login,
                fontSize = 40.sp,
                modifier = Modifier
                    .clickable {
                    }
            )
        }
    }
}