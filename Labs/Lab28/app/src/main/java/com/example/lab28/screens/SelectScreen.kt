package com.example.lab28.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab28.BookOpenHelper
import com.example.lab28.ui.theme.Lab28Theme

@Composable
fun SelectBook(
    onInsertScreen : () -> Unit,
    onUpdateScreen : (Int, String, String, Int, Int) -> Unit
){
    val db = BookOpenHelper(LocalContext.current)

    var selectBooks by remember {mutableStateOf(db.selectBook())}

    Lab28Theme{
        Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
            Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(1/10f).padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text="Просмотр книг", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(innerPadding)
                    .padding(horizontal = 10.dp)
                    .padding(top = 5.dp, bottom = 15.dp)
            ){
                items(selectBooks){ book ->
                    Card(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                            .clickable{
                                onUpdateScreen(
                                    book.id,
                                    book.title,
                                    book.author,
                                    book.year,
                                    book.pages
                                )
                            }
                    ){
                        Row(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .verticalScroll(rememberScrollState())
                                    .fillMaxWidth(3/4f),
                                verticalArrangement = Arrangement.Center
                            ){
                                Row(modifier = Modifier.fillMaxWidth()){
                                    Text(text = "id: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                    Text(text = "${book.id}", fontSize = 20.sp)
                                }
                                Row(modifier = Modifier.fillMaxWidth()){
                                    Text(text = "title: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                    Text(text = book.title, fontSize = 20.sp)
                                }
                                Row(modifier = Modifier.fillMaxWidth()){
                                    Text(text = "author: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                    Text(text = book.author, fontSize = 20.sp)
                                }
                                Row(modifier = Modifier.fillMaxWidth()){
                                    Text(text = "year: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                    Text(text = "${book.year}", fontSize = 20.sp)
                                }
                                Row(modifier = Modifier.fillMaxWidth()){
                                    Text(text = "pages: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                                    Text(text = "${book.pages}", fontSize = 20.sp)
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxSize(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                FloatingActionButton(onClick = {db.deleteBook(book.id)}){
                                    Icon(Icons.Default.Delete, "")
                                }
                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ){
                FloatingActionButton(
                    onClick = {onInsertScreen()},
                ){
                    Icon(Icons.Default.Add, "Добавить")
                }
            }
        }
    }
}