package com.example.labwork27.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labwork27.User
import com.example.labwork27.UserViewModel

@Composable
fun Registration(
    onAuthorization : () -> Unit,
    onBack: () -> Unit,
    vm : UserViewModel = viewModel()
) {

    var userLogin by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(vertical = 50.dp, horizontal = 30.dp),
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    onBack()
                },
            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, "")
            }
            Spacer(Modifier.fillMaxWidth(1 / 8f))
            Text(
                text = "Регистрация",
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
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (userLogin.isNullOrEmpty()) {
                    Color.Red
                } else {
                    Color.Green
                }
            )
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
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (userPassword.isNullOrEmpty()) {
                    Color.Red
                } else {
                    Color.Green
                }
            )
        )
        Spacer(Modifier.padding(bottom = 20.dp))
            Button(
                onClick = {
                    vm.addUser(
                        userLogin,
                        userPassword
                    )
                    onBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                enabled =
                    if (
                        userLogin.isNullOrEmpty() ||
                        userPassword.isNullOrEmpty()
                    ) {
                        false
                    } else {
                        true
                    }
            ){
                Text(
                    text = "Зарегистрироваться",
                    fontSize = 25.sp
                )
            }
        Spacer(Modifier.padding(bottom = 50.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Уже есть аккаунт?",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Button(
                onClick = {
                    onAuthorization()
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ){
                Text(
                    text = "Перейти к авторизации",
                    fontSize = 25.sp
                )
            }
        }
    }
}