package com.example.labwork26

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ListUsersViewModel : ViewModel(){
    val users = mutableStateListOf(
        User("KOLYA", "naumov", "kn@gmail.com"),
        User("SEMEN", "neveyaMen", "semagey@gmail.com"),
        User("asd", "fgh", "hgfdsa@gmail.com"),
        User("QWE", "RTY", "vladKuertov@gmail.com"),
        User("123", "ERROR", "warning@gmail.com"),
        User("ELEPHANT", "SLON", "slon@gmail.com"),
        User("KOVRIK", "palaci", "csgo2@gmail.com"),
        User("MOUSE", "ROT", "cheese@gmail.com"),
        User("EAR", "uho", "bikycle@gmail.com"),
        User("WORD", "microsoft", "fourRectangle@gmail.com"),
        User("HELLOWOWOW", "gggggg", "ggwppepshneleWTF@gmail.com"),
        User("KEYBOARD31", "sosiskasexbomba", "sane4kaAreYouRecordMe@gmail.com"),
        User("RomanGeneral", "frej", "laboratory221@gmail.com"),
        User("Wendy", "Dipper", "truefalse@gmail.com"),
        User("CJ", "GTA", "tenpeny@gmail.com"),
        User("Gul", "anime1000_7", "atakatitanov@gmail.com"),
        User("Arslanov", "FingalNabili", "deepseeker@gmail.com"),
        User("AlexisTexas", "StarOf2000", "studentki@gmail.com"),
        User("Kim", "Kim5WithPlus", "multfilm@gmail.com"),
        User("Shon", "Barashek", "trava@gmail.com"),
        User("Steve", "MinecraftBestGame", "cubic1_21_5@gmail.com"),
        User("Alex", "Steve6edG1rl", "readyForA11@gmail.com"),
    )

    fun addUser(userLogin : String, userPassword : String, userEmail : String){
        users.add(User(userLogin, userPassword, userEmail))
    }

    fun getInfoByLogin(userLogin: String) : User?{
        return users.find { it.login == userLogin }
    }

    fun updateUserByLogin(userLogin : String, newUserPassword : String, newUserEmail : String){
        val loginIndex = users.indexOfFirst{it.login == userLogin}
        users[loginIndex] = users[loginIndex].copy(password = newUserPassword, email = newUserEmail)
    }

//    fun deleteUserByLogin(userLogin : String){
//        val loginIndex = users.indexOfFirst{it.login == userLogin}
//        if (loginIndex != -1) users.removeAt(loginIndex)
//    }
    fun deleteUserByLogin(userLogin : String){
        users.removeAll{it.login == userLogin}
    }


}