package com.example.labwork23.screens

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labwork23.R
import com.example.labwork23.screens.Tovar

val nickname = listOf(
    "xX_Sniper_God_Xx",
    "KILLER_228",
    "ProNoob2004",
    "I_M_Frag",
    "JustHeadshot",
    "S1mple_Blya",
    "PUBG_Chiken_Dinner",
    "300_Bucks",
    "DeAtH_NoTe",
    "Xx_ВоЛкОдАв_Xx",
    "4ypKa_228",
    "[KoT_B_MeIIIKe]",
    "Kuca_Няша",
    "He_B3a6yLLlka",
    "M4Tb_FaK",
    "Demon_Destroyer",
    "Nightmare_Slayer",
    "Shadow_Killer_666",
    "Devil_From_Hell",
    "Dark_Angel_666",
    "Nyan_Nyan_Cat",
    "Kakashi_4_Life",
    "Lelouch_Vi_Brittania",
    "Saitama_OP",
    "Tyan_Chan_Kawaii",
    "Семён_Слепаков_офигеть",
    "Джигурда_777",
    "Борода_Кек",
    "ВайФай_Роскомнадзор",
    "Гнойный_Панч",
    "Мой_Ник_Забанен_НаХуй",
    "Liska_Lubov",
    "Мур_Мяу_Кисунька",
    "Сладкая_Вата",
    "Кусь_За_Щёчку",
    "★NeZhnO★",
    "Bratan_1337",
    "ReaL_BoY",
    "Gopota_228",
    "Kolyan_Na_Konte",
    "TarZan_96_rus",
    "xX_SlaDkAyA_NyAsHa_228_Xx"
)

val numbersPhone = listOf(
    "+7 903 123 45 67",
    "+7 912 345 67 89",
    "+7 921 555 23 11",
    "+7 999 876 54 32",
    "+7 916 777 88 99",
    "+7 925 444 33 22",
    "+7 909 111 22 33",
    "+7 951 666 77 44",
    "+7 962 888 99 00",
    "+7 977 333 55 77"
)

class Tovar(
    val name : String,
    val image : Int
)
val products = listOf(
    Tovar("Нокиа", R.drawable.nokia),
    Tovar("Коленька Наумов", R.drawable.kolyannaumov),
    Tovar("Нуклеотиды", R.drawable.nukleotydy),
    Tovar("Лев", R.drawable.lev),
    Tovar("Оба одеты", R.drawable.obaodeti),
    Tovar("Ега", R.drawable.ega),
)

@Preview
@Composable
fun UserProfile(){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.4f)
                .border(
                    BorderStroke(2.dp, color = Color.DarkGray),
                    shape = RoundedCornerShape(40.dp)
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 70.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    ImageBitmap.imageResource(R.drawable.nagiev),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 30.dp, bottom = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .clickable {}
                )
                Text(
                    text = nickname.random(),
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = numbersPhone.random(),
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.bodyLarge
                )
                Row(){
                    Column(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        FloatingActionButton({}
                        ){
                            Icon(Icons.Filled.AccountCircle, "")
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Text(
                            text = "Ваши данные",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onTertiary,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        FloatingActionButton({}
                        ){
                            Icon(Icons.Filled.Notifications, "")
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Text(
                            text = "Уведомления",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onTertiary,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        FloatingActionButton({}
                        ){
                            Icon(Icons.Filled.Settings, "")
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Text(
                            text = "Настройки",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onTertiary,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.5f)
                .border(
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.onError),
                    shape = RoundedCornerShape(40.dp)
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ){
                Text(
                    text = "Отзывы и вопросы: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyLarge
                )
                LazyRow(
                    modifier = Modifier.fillMaxSize()
                ){
                    items(products){ item ->
                        Card(
                            border = BorderStroke(5.dp, Color.Green),
                            modifier = Modifier
                                .padding(vertical = 5.dp, horizontal = 5.dp)
                                .width(350.dp)
                                .clickable{},
                            shape = RoundedCornerShape(0.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.onTertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.outline
                            ),
                            elevation = CardDefaults.cardElevation(focusedElevation = 30.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(200.dp)
                                        .padding(start = 10.dp),
                                    painter = painterResource(item.image),
                                    contentDescription = ""
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = item.name,
                                        fontSize = 25.sp,
                                        modifier = Modifier
                                            .padding(bottom = 10.dp),
                                        color = MaterialTheme.colorScheme.inversePrimary,
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
}
