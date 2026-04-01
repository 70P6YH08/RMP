package com.example.labwork19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork19.ui.theme.LabWork19Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork19Theme {
//                ProductInfoCardHorizontal(product = products) //1
//                ProductInfoCardVertical(product = products) //1
//                ProductInfoLazyColumn(product = products) //2, 4
//                ProductInfoLazyRow(product = products) //3
                ProductVerticalGrid(product = products) //5
//                ProductHorizontalGrid(product = products) //5
            }
        }
    }
}

data class Product(
    val article : String,
    val name: String,
    val price: Double,
    val imageResId: Int
)

val products = listOf(
    Product("apple1", "Яблоко", 232.99, R.drawable.apple),
    Product("banana2", "Банан", 159.99, R.drawable.banana),
    Product("bread3", "Хлеб", 49.99, R.drawable.bread),
    Product("cabbage4", "Капуста", 123.45, R.drawable.cabbage),
    Product("coffee5", "Кофе", 400.00, R.drawable.coffe),
    Product("cookies6", "Печенье", 96.99, R.drawable.cookies),
    Product("cucumber7", "Огурец", 249.99, R.drawable.cucumber),
    Product("eggs8", "Яйца", 120.99, R.drawable.eggs),
    Product("flour9", "Мука", 50.99, R.drawable.flour),
    Product("gingerbread10", "Пряники", 149.99, R.drawable.gingerbread),
    Product("juice11", "Сок", 120.99, R.drawable.juice),
    Product("meat12", "Мясо", 297.99, R.drawable.meat),
    Product("milk13", "Молоко", 134.99, R.drawable.milk),
    Product("oil14", "Масло", 120.99, R.drawable.oil),
    Product("porridge15", "Каша", 34.99, R.drawable.porridge),
    Product("sausage16", "Колбаса", 230.99, R.drawable.sausage),
    Product("shrimp17", "Креветки", 123.99, R.drawable.shrimp),
    Product("tea18", "Чай", 59.99, R.drawable.tea),
    Product("tomato19", "Помидор", 220.99, R.drawable.tomato),
    Product("water20", "Вода", 79.99, R.drawable.water)
)


@Composable
fun ProductInfoCardHorizontal(product: List<Product>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
            .padding(
                top = 40.dp,
                bottom = 40.dp
            )
    ) {
        product.forEach { item ->
            Card(
                border = BorderStroke(5.dp, Color.Green),
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(focusedElevation = 30.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(10.dp),
                        painter = painterResource(item.imageResId),
                        contentDescription = ""
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = item.name,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                        )
                        Text(
                            text = item.price.toString(),
                            fontSize = 30.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductInfoCardVertical(product: List<Product>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
            .padding(
                top = 40.dp,
                bottom = 40.dp
            ),
    ) {
        product.forEach { item ->
            Card(
                border = BorderStroke(2.dp, Color.DarkGray),
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
                    .width(150.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Magenta
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(item.imageResId),
                    contentDescription = "",
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp,bottom = 20.dp)

                ){
                    Text(
                        text = item.name,
                        fontSize = 25.sp
                    )
                    Text(
                        text = item.price.toString(),
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProductInfoLazyColumn(product: List<Product>) {
    var nameProduct by remember { mutableStateOf("Пока ничего не выбрано") }
    val listState = rememberLazyListState()
    val showButton = remember { derivedStateOf { listState.firstVisibleItemIndex > 1 } }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            if (showButton.value) {
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.scrollToItem(index = 0)
                        }
                    }
                ) {
                    Text(text = "Наверх")
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 40.dp
                ),
            state = listState
        ) {
            item { Text(text = nameProduct, fontSize = 25.sp) }
            items(product) { item ->
                Card(
                    border = BorderStroke(5.dp, Color.Green),
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 5.dp)
                        .width(300.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(focusedElevation = 30.dp)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { nameProduct = item.name },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier
                                .size(150.dp)
                                .padding(10.dp),
                            painter = painterResource(item.imageResId),
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = item.name,
                                fontSize = 30.sp,
                                modifier = Modifier
                                    .padding(bottom = 10.dp),
                            )
                            Text(
                                text = item.price.toString(),
                                fontSize = 30.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductInfoLazyRow(product: List<Product>) {
    val state = rememberLazyListState()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 40.dp,
                bottom = 40.dp
            ),
        state = state
    ) {
        items(product){ item ->
            Card(
                border = BorderStroke(2.dp, Color.DarkGray),
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
                    .width(150.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Magenta
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(item.imageResId),
                    contentDescription = "",
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp)
                ){
                    Text(
                        text = item.name,
                        fontSize = 25.sp
                    )
                    Text(
                        text = item.price.toString(),
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProductVerticalGrid(product: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 40.dp,
                bottom = 40.dp
            ),
    ) {
        items(product){ item ->
            Card(
                border = BorderStroke(2.dp, Color.DarkGray),
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
                    .width(150.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Magenta
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(item.imageResId),
                    contentDescription = "",
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp)
                ){
                    Text(
                        text = item.name,
                        fontSize = 25.sp
                    )
                    Text(
                        text = item.price.toString(),
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ProductHorizontalGrid(product: List<Product>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 40.dp,
                bottom = 40.dp
            ),
    ) {
        items(product){ item ->
            Card(
                border = BorderStroke(2.dp, Color.DarkGray),
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
                    .width(150.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Magenta
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(item.imageResId),
                    contentDescription = "",
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp)
                ){
                    Text(
                        text = item.name,
                        fontSize = 25.sp
                    )
                    Text(
                        text = item.price.toString(),
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun a1(){
    ProductInfoCardHorizontal(product = products)
}
@Preview
@Composable
fun a2(){
    ProductInfoCardVertical(product = products)
}
@Preview
@Composable
fun a3(){
    ProductInfoLazyColumn(product = products)
}
@Preview
@Composable
fun a4(){
    ProductInfoLazyRow(product = products)
}
@Preview
@Composable
fun a5(){
    ProductVerticalGrid(product = products)
}
@Preview
@Composable
fun a6(){
    ProductHorizontalGrid(product = products)
}