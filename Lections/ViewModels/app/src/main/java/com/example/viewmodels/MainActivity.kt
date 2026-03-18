package com.example.viewmodels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodels.ui.theme.ViewModelsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
                        CounterView()
                        Main()
                    }
                }
            }
        }
    }
}

@Composable
fun CounterView(vm: CounterViewModel = viewModel()){
    Button({vm.increment()}){
        Text(vm.count.toString())
    }
}

@Composable
fun Main(vm: UserListViewModel = viewModel()){
    Column{
        UserInput(
            vm.userName,
            vm.userAge,
            changeName = {vm.changeName(it)},
            changeAge = {vm.changeAge(it)},
            add = {vm.addUser()}
        )
        UserList(
            vm.users,
            delete = {vm.deleteUser(it)}
        )
    }
}

@Composable
fun UserInput(userName : String,
              userAge : Int,
              changeName : (String) -> Unit,
              changeAge : (String) -> Unit,
              add : () -> Unit
){
    Column{
        OutlinedTextField(value = userName,
            onValueChange = {changeName(it)})
        OutlinedTextField(value = userAge.toString(),
            onValueChange = {changeAge(it)})
        Button(onClick = {add()}){
            Text("Добавить")
        }
    }
}

@Composable
fun UserList(users : List<User>, delete:(User) -> Unit){
    LazyColumn(Modifier.fillMaxWidth()){
        items(users){ u ->
            Text(text = u.name)
            Text(text = u.age.toString())
            TextButton(onClick = {delete(u)}){
                Text(text = "Удалить")
            }
        }
    }
}