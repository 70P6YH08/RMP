package com.example.containers

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.containers.ui.theme.ContainersTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.leanback.widget.Row
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import kotlin.random.Random
import kotlin.random.nextInt
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Button
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            Box(Modifier.size(200.dp)
//                .aspectRatio(3/5f, true)
//                .background(Color.Red))
            LazyColumnContainer()


        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxContainer(){
    Box(Modifier.size(200.dp),
        contentAlignment = Alignment.Center){
        Text("1", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.TopStart))
        Text("2", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.TopCenter))
        Text("3", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center))
        Text("4", fontSize = 30.sp,
            modifier = Modifier.align(Alignment.BottomEnd))
    }

}

@Preview(showBackground = true)
@Composable
fun ColumnContainer(){
    Column(Modifier.size(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween){
        Text("1", fontSize = 30.sp)
        Text("2", fontSize = 30.sp)
        Text("3", fontSize = 30.sp)
        Text("4", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun RowContainer(){
    Row(Modifier.size(200.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text("1", fontSize = 30.sp)
        Text("2", fontSize = 30.sp)
        Text("3", fontSize = 30.sp)
        Text("4", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnWeightContainer(){
    Column(Modifier.size(200.dp)){
        Text("1", fontSize = 30.sp,
            modifier = Modifier
                .weight(4f)
                .background(Color.Red))
        Text("2", fontSize = 30.sp,modifier = Modifier
            .weight(3f)
            .background(Color.Blue))
        Text("3", fontSize = 30.sp,
            modifier = Modifier
                .weight(2f)
                .background(Color.Green))
        Text("4", fontSize = 30.sp,
            modifier = Modifier
                .weight(1f)
                .background(Color.Yellow))
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnContainer(){
    val list = List(50,{it})
    val state = rememberLazyListState()
    val corutineScope = rememberCoroutineScope()
    LazyColumn(Modifier.fillMaxSize(), state = state){
        stickyHeader {  Text("Циферки",
            fontSize = 30.sp,
            modifier = Modifier.background(Color.Cyan)
                .clickable{
                    corutineScope.launch{
                        state.animateScrollToItem(33)
                    }
                })}
        itemsIndexed(list){ i, v ->
            Text(v.toString(), fontSize = 30.sp,
                modifier = Modifier.background(
                    if(i%2==0) Color.LightGray
                        else Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyGridContainer(){
    LazyVerticalGrid(GridCells.Fixed(3),
        Modifier.fillMaxSize()){
        items(100){
            Box(Modifier
                .size(100.dp)
                .background(Color(Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                )))
            {
                Text(it.toString(), fontSize = 28.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyStaggeredGridContainer(){
    LazyVerticalStaggeredGrid(StaggeredGridCells.Adaptive(100.dp),
        Modifier.fillMaxSize()){
        items(100){
            Box(Modifier
                .width(100.dp)
                .height(
                    Random.nextInt(50, 100).dp
                )
                .background(Color(
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                )))
            {
                Text(it.toString(), fontSize = 28.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowColumnContainer() {
    val list = List(50, { it })
    FlowColumn(Modifier.fillMaxSize()) {
        list.forEach {
            Text(
                it.toString(), fontSize = 30.sp,
                modifier = Modifier
                    .padding(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurfaceContainer() {
    val list = List(50, { it })
    Surface(color = Color.DarkGray,
        contentColor = Color.Yellow,
        border = BorderStroke(2.dp, Color.Red)
    ){
            Text("123", fontSize = 50.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CardContainer() {
    val list = List(50, { it })
    FlowColumn(Modifier.fillMaxSize()) {
        list.forEach {
            Card(elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .size(200.dp)
                    .padding(5.dp)) {
                Text(it.toString())
            }
        }
    }
}