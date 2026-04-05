package com.example.labwork23.screens

import androidx.compose.animation.core.withInfiniteAnimationFrameMillis
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.labwork23.R


val list = listOf(
    Product("Bee", 1.99, R.drawable.bee),
    Product("Building", 3252262.87, R.drawable.building),
    Product("Car", 59000.00, R.drawable.car),
    Product("Child", 1234567.99, R.drawable.child),
    Product("Chips", 1.99, R.drawable.chips),
    Product("Coal", 0.69, R.drawable.coal),
    Product("Ear", 4000.00, R.drawable.ear),
    Product("Gorilla", 12000.00, R.drawable.gorilla),
    Product("Helmet", 3.59, R.drawable.helmet),
    Product("Iron", 10.99, R.drawable.iron),
    Product("Kolyan", 2.42, R.drawable.kolyanaumov),
    Product("Lemon", 0.69, R.drawable.lemon),
    Product("Map", 5.29, R.drawable.map),
    Product("Meat", 3.97, R.drawable.meat),
    Product("Money", 0.01, R.drawable.money),
    Product("Plates", 2.01, R.drawable.plates),
    Product("Rose", 9.98, R.drawable.rose),
    Product("Silicone", 5400.95, R.drawable.silicone),
    Product("Zxc", 21.99, R.drawable.zxc)
)

@Composable
fun Search() {
    var searchString by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        TextField(
            value = searchString,
            onValueChange = { searchString = it },
            label = {
                Text(
                    text = "Search",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
                .padding(horizontal = 5.dp)
                .background(color = Color.White, RoundedCornerShape(10.dp))
                .border(
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.tertiary),
                    shape = RoundedCornerShape(10.dp)
                ),
            singleLine = true
        )
        LazyVerticalStaggeredGrid(
            StaggeredGridCells.Adaptive(150.dp),
            Modifier.fillMaxSize()
        ) {
            items(list) { item ->
                val nameItem = item.name.toLowerCase()
                if (nameItem.contains(searchString.toLowerCase())) {
                    Card(
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.tertiary),
                        modifier = Modifier
                            .padding(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
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
                                    modifier = Modifier
                                        .padding(bottom = 5.dp),
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.headlineLarge
                                )
                                Text(
                                    text = item.name,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    style = MaterialTheme.typography.bodyLarge
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