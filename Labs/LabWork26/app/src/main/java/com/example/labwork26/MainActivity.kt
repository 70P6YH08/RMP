package com.example.labwork26

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork26.ui.theme.LabWork26Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrueNavRoot()
        }
    }
}

@Composable
fun Users(
    viewModel: ListUsersViewModel = viewModel(),
    onUserInfo : (String) -> Unit
) {
    var userLogin by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }

    var checkUser by remember {mutableStateOf(true)}

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    viewModel.addUser(
                        userLogin,
                        userPassword,
                        "${userEmail} + @gmail.com"
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
            Button(
                onClick = {
                    viewModel.deleteUserByLogin(
                        userLogin
                    )
                }
            ) {
                Icon(Icons.Filled.Delete, "")
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 300.dp, bottom = 40.dp)
            .border(border = BorderStroke(1.dp, Color.Green))
    ) {
        items(viewModel.users) { user ->
            Text(
                text = user.login,
                fontSize = 40.sp,
                modifier = Modifier
                    .clickable{
                        onUserInfo(user.login)
                    }
            )
        }
    }
}

@Composable
fun UserInfo(
    onBack: () -> Unit,
    login: String,
    viewModel: ListUsersViewModel = viewModel()
) {
    var user = viewModel.getInfoByLogin(login)

    if (user == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Такого пользователя не существует")
            Button(
                onClick = {
                    onBack()
                }
            ){
                Text(text = "Назад")
            }
        }
        return
    }

    var password by remember {mutableStateOf(user.password)}
    var email by remember {mutableStateOf(user.email)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
            .padding(horizontal = 10.dp)
    ) {
        Button(
            onClick = { onBack() }
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Вернуться назад"
            )
        }
        Column(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(3/5f)
                ) {
                    Text(
                        text = "Пользователь:",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .padding(bottom = 10.dp)
                    )
                    Text(
                        text = "Пароль:",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(vertical = 15.dp)
                    )
                    Text(
                        text = "Email:",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(vertical = 10.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = user.login,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                    )
                }
            }
            Button(
                onClick = {
                    viewModel.updateUserByLogin(login, password, email)
                }
            ){
                Icon(Icons.Filled.Done, "")
            }
        }
    }
}


@Composable
fun TrueNavRoot(){
    LabWork26Theme {
    val navController = rememberNavController()
        val viewModel : ListUsersViewModel = viewModel()
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                NavHost(navController, startDestination = Screens.USERS.route) {
                    composable("users") {
                        Users(
                            onUserInfo = {login ->
                                navController.navigate("userinfo/$login")}
                        )
                    }
                    composable("userinfo/{login}",
                        arguments = listOf(
                            navArgument("login"){type = NavType.StringType}
                        )
                    ) { stack ->
                        val login = stack.arguments?.getString("login")!!
                        UserInfo(
                            viewModel = viewModel,
                            onBack = {navController.popBackStack()},
                            login = login
                        )
                    }
                }
            }
        }
    }
}

enum class Screens(val route: String){
    USERS("users"),
}