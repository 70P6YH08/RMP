package com.example.labwork27.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Authorization() {

    var userLogin by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(vertical = 50.dp, horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {},
            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, "")
            }
            Spacer(Modifier.fillMaxWidth(3 / 9f))
            Text(
                text = "Вход",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.padding(bottom = 40.dp))
        Text(
            text = "Логин:",
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = userLogin,
            onValueChange = { userLogin = it },
            label = {
                Row {
                    Icon(
                        Icons.Filled.Person,
                        ""
                    )
                    Text(text = "Логин")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.padding(bottom = 10.dp))
        Text(
            text = "Пароль:",
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = userPassword,
            onValueChange = { userPassword = it },
            label = {
                Text(text = "Пароль")
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.padding(bottom = 20.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ){
            Text(
                text = "Войти",
                fontSize = 25.sp
            )
        }
        Spacer(Modifier.padding(bottom = 50.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Нет аккаунта?",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ){
                Text(
                    text = "Перейти к регистрации",
                    fontSize = 25.sp
                )
            }
        }
    }
}