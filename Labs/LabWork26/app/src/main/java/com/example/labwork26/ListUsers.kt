package com.example.labwork26

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ListUsersViewModel : ViewModel(){
    val users = mutableStateListOf<UserInfo>(
        UserInfo("KOLYA", "naumov", "kn@gmail.com"),
        UserInfo("SEMEN", "neveyaMen", "semagey@gmail.com"),
        UserInfo("asd", "fgh", "hgfdsa@gmail.com"),
        UserInfo("QWE", "RTY", "vladKuertov@gmail.com"),
        UserInfo("123", "ERROR", "warning@gmail.com"),
        UserInfo("ELEPHANT", "SLON", "slon@gmail.com"),
        UserInfo("KOVRIK", "palaci", "csgo2@gmail.com"),
        UserInfo("MOUSE", "ROT", "cheese@gmail.com"),
        UserInfo("EAR", "uho", "bikycle@gmail.com"),
        UserInfo("WORD", "microsoft", "fourRectangle@gmail.com"),
        UserInfo("HELLOWOWOW", "gggggg", "ggwppepshneleWTF@gmail.com"),
        UserInfo("KEYBOARD31", "sosiskasexbomba", "sane4kaAreYouRecordMe@gmail.com"),
        UserInfo("RomanGeneral", "frej", "laboratory221@gmail.com"),
        UserInfo("Ivan", "RMP_SP_PROGRAMMIST", "ha4@gmail.com"),
    )

    var userLogin by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var userEmail by mutableStateOf("")

    fun addUser(){
        users.add(UserInfo(userLogin, userPassword, userEmail))
    }
}