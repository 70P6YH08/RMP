package com.example.lab28.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.lab28.BookOpenHelper
import com.example.lab28.ui.theme.Lab28Theme

@Composable
fun InsertBook(
    onBack : () -> Unit
) {
    val db = BookOpenHelper(LocalContext.current)

    var title by remember{ mutableStateOf("") }
    var author by remember{ mutableStateOf("") }
    var year by remember{ mutableStateOf("") }
    var pages by remember{ mutableStateOf("") }

    val bnoe = title.isNullOrEmpty()
    val bign = title.isDigitsOnly()
    val anoe = author.isNullOrEmpty()
    val acr = author.contains(regex = Regex("\\d+$"))
    val ynoe = year.isNullOrEmpty()
    val ynid = !year.isDigitsOnly()
    val pnoe = pages.isNullOrEmpty()
    val pnid = !pages.isDigitsOnly()

    Lab28Theme{
        Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
            FloatingActionButton(onClick = {onBack()}){
                Icon(Icons.Default.ArrowBack,"Выход")
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = if(bnoe)
                            "Книга не может быть без названия"
                        else "Не могут использоваться только цифры",
                        Modifier
                            .alpha(
                                if(bnoe || bign)
                                    1f
                                else
                                    0f
                            )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Title: ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp))
                        OutlinedTextField(
                            value = title,
                            onValueChange = { title = it },
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = if(anoe)
                            "Автор пуст"
                        else "В авторе не может быть цифр",
                        Modifier
                            .alpha(
                                if(anoe || acr)
                                    1f
                                else
                                    0f
                            )
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Author:", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp))
                        OutlinedTextField(
                            value = author,
                            onValueChange = {author = it},
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = if(ynoe)
                            "Год пуст"
                        else "Можно использовать только цифры!",
                        Modifier
                            .alpha(
                                if(ynoe || ynid)
                                    1f
                                else
                                    0f
                            )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Public year:", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp))
                        OutlinedTextField(
                            value = year,
                            onValueChange = {year = it},
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text = if(pnoe)
                            "Страницы пусты"
                        else "Можно использовать только цифры!",
                        Modifier
                            .alpha(
                                if(pnoe || pnid)
                                    1f
                                else
                                    0f
                            )
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Count pages:", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp))
                        OutlinedTextField(
                            value = pages,
                            onValueChange = {pages = it},
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Button(
                    onClick = {
                        db.insertBook(
                            title,
                            author,
                            year.toInt(),
                            pages.toInt()
                        )
                    },
                    enabled = if(bnoe || bign || anoe || acr || ynoe || ynid || pnoe || pnid) false else true
                ){
                    Text(text = "Добавить")
                }
            }
        }
    }
}