package com.example.labwork19

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork19.ui.theme.LabWork19Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork19Theme {
//                ProductInfoCardHorizontal(
//                    product = products[0]
//                )

//                ProductInfoCardVertical(
//                    product = products[0]
//                )

                ProductInfoLazyColumn()
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

val products = List(20){ index ->
    Product(
        article = "art${21 - index}",
        name = "Товар №${index + 1}",
        price = 2.1 + index * 1.01,
        imageResId = R.drawable.man
    )
}


@Composable
fun ProductInfoCardHorizontal(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
            .padding(
                top = 40.dp,
                bottom = 40.dp
            )
    ) {
        products.forEach { product ->
            Card(
                border = BorderStroke(5.dp, Color.Red),
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(),
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
                            .size(100.dp)
                            .padding(10.dp),
                        painter = painterResource(R.drawable.man),
                        contentDescription = ""
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = product.name,
                            fontSize = 30.sp
                        )
                        Text(
                            text = "%.2f"
                                .format(product.price),
                            fontSize = 30.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductInfoCardVertical(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = rememberScrollState())
            .padding(
                top = 40.dp,
                bottom = 40.dp
            ),
    ) {
        products.forEach { product ->
            Card(
                border = BorderStroke(2.dp, Color.DarkGray),
                modifier = Modifier
                    .padding(vertical = 5.dp)
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
                        .padding(top = 20.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(R.drawable.man),
                    contentDescription = "",
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .width(150.dp)
                        .height(200.dp)
                        .padding(bottom = 20.dp)
                ){
                    Text(
                        text = product.name,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "%.2f"
                            .format(product.price),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductInfoLazyColumn() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 40.dp,
                bottom = 40.dp
            ),
    ) {
        items(products) { product ->
            Card(
                border = BorderStroke(5.dp, Color.Red),
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .width(110.dp),
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
                            .size(60.dp)
                            .padding(10.dp),
                        painter = painterResource(R.drawable.man),
                        contentDescription = ""
                    )
                    Column(
                        modifier = Modifier
                            .padding(1.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = product.name,
                            fontSize = 9.sp
                        )
                        Text(
                            text = "%.2f"
                                .format(product.price),
                            fontSize = 9.sp
                        )
                    }
                }
            }
        }
    }
}
