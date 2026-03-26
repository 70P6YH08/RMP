package com.example.clicker31.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clicker31.GameViewModel
import kotlin.collections.component1
import kotlin.collections.component2

@Composable
fun ShopScreen(vm: GameViewModel){
    Column(modifier = Modifier.fillMaxSize()){
        vm.upgrades.forEach { (type, upgrade) ->
            Card(Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable{vm.onUpgrade(upgrade)}
            ){
                Text(text = type.title,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(text = "${upgrade.level} lv. Значение %.2f"
                    .format(upgrade.currentValue()),
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(text = "Стоимость: %.2f"
                    .format(upgrade.currentCost()),
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    }
}