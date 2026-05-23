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
import com.example.lab28.Book
import com.example.lab28.BookOpenHelper
import com.example.lab28.ui.theme.Lab28Theme


@Composable
fun UpdateBook(
    onBack : () -> Unit,
    id : String,
    title : String,
    author : String,
    year : String,
    pages : String
) {
    val db = BookOpenHelper(LocalContext.current)

    var bookTitle by remember { mutableStateOf(title) }
    var bookAuthor by remember { mutableStateOf(author) }
    var publicYear by remember { mutableStateOf(year) }
    var countPages by remember { mutableStateOf(pages) }

    val bnoe = bookTitle.isNullOrEmpty()
    val bign = bookTitle.isDigitsOnly()
    val anoe = bookAuthor.isNullOrEmpty()
    val acr = bookAuthor.contains(regex = Regex("\\d+$"))
    val ynoe = publicYear.isNullOrEmpty()
    val ynid = !publicYear.isDigitsOnly()
    val pnoe = countPages.isNullOrEmpty()
    val pnid = !countPages.isDigitsOnly()

    Lab28Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            FloatingActionButton(onClick = { onBack() }) {
                Icon(Icons.Default.ArrowBack, "Выход")
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Id: ", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Text(text = id, fontSize = 20.sp)
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (bnoe)
                                "Книга не может быть без названия"
                            else "Не могут использоваться только цифры",
                            Modifier
                                .alpha(
                                    if (bnoe || bign)
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
                        ) {
                            Text(
                                text = "Title: ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            OutlinedTextField(
                                value = bookTitle,
                                onValueChange = { bookTitle = it },
                                shape = RoundedCornerShape(40.dp),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (anoe)
                            "Автор пуст"
                        else "В авторе не может быть цифр",
                        Modifier
                            .alpha(
                                if (anoe || acr)
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
                    ) {
                        Text(
                            text = "Author: ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        OutlinedTextField(
                            value = bookAuthor,
                            onValueChange = { bookAuthor = it },
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (ynoe)
                            "Год пуст"
                        else "Можно использовать только цифры!",
                        Modifier
                            .alpha(
                                if (ynoe || ynid)
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
                    ) {
                        Text(
                            text = "Public year: ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        OutlinedTextField(
                            value = publicYear,
                            onValueChange = { publicYear = it },
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (pnoe)
                            "Страницы пусты"
                        else "Можно использовать только цифры!",
                        Modifier
                            .alpha(
                                if (pnoe || pnid)
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
                    ) {
                        Text(
                            text = "Count pages: ", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        OutlinedTextField(
                            value = countPages,
                            onValueChange = { countPages = it },
                            shape = RoundedCornerShape(40.dp),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Button(
                    onClick = {
                        db.updateBook(
                            Book(
                                id.toInt(),
                                bookTitle,
                                bookAuthor,
                                publicYear.toInt(),
                                countPages.toInt()
                            )
                        )
                    },
                    enabled = if (bnoe || bign || anoe || acr || ynoe || ynid || pnoe || pnid) false else true
                ) {
                    Text(text = "Сохранить изменения")
                }
            }
        }
    }
}