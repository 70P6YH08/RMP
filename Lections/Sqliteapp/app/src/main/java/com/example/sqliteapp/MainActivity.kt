package com.example.sqliteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sqliteapp.ui.theme.SqliteappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main() {
    val db = DbHandler(LocalContext.current)

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userList by remember { mutableStateOf(db.getUsers()) }



    SqliteappTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.fillMaxSize().padding(innerPadding)){
                OutlinedTextField(
                    value = login,
                    onValueChange = {login = it}
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it}
                )
                Button(onClick = {
                    db.addUser(login, password)
                    userList = db.getUsers()
                }){
                    Text(text = "Добавить")
                }
                LazyColumn() {
                    items(userList){ user ->
                        Row(){
                            Text(user.login)
                            Spacer(Modifier.width(10.dp))
                            Text(user.password)
                        }
                    }
                }
            }
        }
    }
}