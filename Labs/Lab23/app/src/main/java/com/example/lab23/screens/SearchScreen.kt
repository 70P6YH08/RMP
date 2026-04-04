package com.example.lab23.screens

import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab23.R


val list = listOf(
    Product("Пчела", 1.99, R.drawable.bee),
    Product("Здание", 3252262.87, R.drawable.building),
    Product("Автомобиль", 59000.00, R.drawable.car),
    Product("Ребёнок", 1234567.99, R.drawable.child),
    Product("Чипсы", 1.99, R.drawable.chips),
    Product("Уголь", 0.69, R.drawable.coal),
    Product("Ухо", 4000.00, R.drawable.ear),
    Product("Горилла", 12000.00, R.drawable.gorilla),
    Product("Каска", 3.59, R.drawable.helmet),
    Product("Железо", 10.99, R.drawable.iron),
    Product("Колян", 2.42, R.drawable.kolyanaumov),
    Product("Лимон", 0.69, R.drawable.lemon),
    Product("Карта", 5.29, R.drawable.map),
    Product("Мясо", 3.97, R.drawable.meat),
    Product("Деньги", 0.01, R.drawable.money),
    Product("Тарелки", 2.01, R.drawable.plates),
    Product("Роза", 9.98, R.drawable.rose),
    Product("Силикон", 5400.95, R.drawable.silicone),
    Product("Zxc", 21.99, R.drawable.zxc)
)

@Composable
fun Search() {
    var searchString by remember { mutableStateOf("") }
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(horizontal = 5.dp)
        ) {
            TextField(
                value = searchString,
                onValueChange = { searchString = it },
                label = { Text(text = "Поиск") },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true
            )
        }
        LazyVerticalStaggeredGrid(
            StaggeredGridCells.Adaptive(150.dp),
            Modifier.fillMaxSize()
        ) {
            items(list) { item ->
                val nameItem = item.name.toLowerCase()
                if (nameItem.contains(searchString)) {
                    Card(
                        border = BorderStroke(2.dp, Color.DarkGray),
                        modifier = Modifier
                            .padding(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Image(
                            ImageBitmap.imageResource(item.image), "",
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(10.dp))
                                .align(Alignment.CenterHorizontally)
                                .padding(10.dp)
                        )
                        Row {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .width(150.dp)
                                    .padding(top = 10.dp, bottom = 20.dp)
                                    .padding(horizontal = 10.dp)

                            ) {
                                Text(
                                    text = "${item.price} $",
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(bottom = 5.dp),
                                    color = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                                Text(
                                    text = "${item.name}",
                                    color = MaterialTheme.colorScheme.errorContainer
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

class Product(
    val name : String,
    val price : Double,
    val image : Int
)