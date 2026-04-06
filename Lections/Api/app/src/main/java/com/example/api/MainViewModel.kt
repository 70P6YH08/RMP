package com.example.api

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.data.MarsPhoto
import com.example.api.data.MarsRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    var list by mutableStateOf(listOf<MarsPhoto>())
    val repository = MarsRepository()

    init{
        getMarsPhoto()
    }

    fun getMarsPhoto(){
        viewModelScope.launch {
            list = repository.getMarsPhotos()
        }
    }
}