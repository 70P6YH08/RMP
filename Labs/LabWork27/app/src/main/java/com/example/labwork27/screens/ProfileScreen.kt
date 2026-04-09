package com.example.labwork27.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labwork27.UserViewModel

@Composable
fun Profile(
    onAuthorization : () -> Unit,
    onBack: () -> Unit,
    login : String,
    password : String,
    vm : UserViewModel = viewModel()
) {

    var user = vm.getUser(login, password)

    if (user == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 50.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Такого пользователя не существует")
            Button(
                onClick = {
                    onBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ){
                Text(
                    text = "Назад",
                    fontSize = 25.sp
                )
            }
        }
        return
    }

    var userInfo by remember { mutableStateOf(user.info) }

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
            Spacer(Modifier.fillMaxWidth(2 / 9f))
            Text(
                text = "Профиль",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.padding(bottom = 40.dp))
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                Icons.Filled.AccountCircle, "",
                modifier = Modifier
                    .size(80.dp)
            )
            Spacer(Modifier.padding(end = 10.dp))
            Text(
                text = login,
                fontSize = 30.sp
            )
        }

        Spacer(Modifier.padding(bottom = 40.dp))
        Text(
            text = "О себе:",
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = userInfo,
            onValueChange = { userInfo = it },
            minLines = 9,
            maxLines = 12,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.padding(bottom = 20.dp))
        Button(
            onClick = {
                vm.updateUserInfo(
                    login,
                    userInfo
                )
                onAuthorization()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ){
            Text(
                text = "Выйти",
                fontSize = 25.sp
            )
        }
    }
}