package com.example.labwork27

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel(){

    val users = mutableStateListOf(
        User("Kima", "krutoi_paren", "Весит 95 кило"),
        User("Ega", "govno3308", "Весит 62 кило")
    )

    var userLogin by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var userInfo by mutableStateOf("")

    fun addUser(user: User){
        users.add(user)
    }
}