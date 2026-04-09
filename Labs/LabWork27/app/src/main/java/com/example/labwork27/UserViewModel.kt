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

    fun addUser(login : String, password : String){
        users.add(User(login, password, ""))
    }

    fun getUser(login: String, password: String) : User?{
        return users.find { it.login == login && it.password == password}
    }

    fun updateUserInfo(login : String, newInfo : String){
        val loginIndex = users.indexOfFirst{it.login == login}
        users[loginIndex] = users[loginIndex].copy(info = newInfo)
    }
}