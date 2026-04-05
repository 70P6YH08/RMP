package com.example.labwork23.screens

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
    "WIFI_RKN",
    "Гнойный_Панч",
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
    Tovar("Nokia", R.drawable.nokia),
    Tovar("Kolya Creeper2004", R.drawable.kolyannaumov),
    Tovar("Nukleotydy", R.drawable.nukleotydy),
    Tovar("Lion", R.drawable.lev),
    Tovar("Both are dressed", R.drawable.obaodeti),
    Tovar("S1mple", R.drawable.ega),
)

@Preview
@Composable
fun UserProfile(){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight(2/3f)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1/2f)
                .border(
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.tertiary),
                    shape = RoundedCornerShape(40.dp)
                )
                .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(40.dp))
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
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = numbersPhone.random(),
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                Row(){
                    Column(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        FloatingActionButton(
                            {},
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onTertiary
                        ){
                            Icon(Icons.Filled.AccountCircle, "")
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Text(
                            text = "My data",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        FloatingActionButton(
                            {},
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onTertiary
                        ){
                            Icon(Icons.Filled.Notifications, "")
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Text(
                            text = "Notifications",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .width(80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        FloatingActionButton(
                            {},
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onTertiary
                        ){
                            Icon(Icons.Filled.Settings, "")
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Text(
                            text = "Settings",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(40.dp))
                .fillMaxWidth()
                .border(
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.tertiary),
                    shape = RoundedCornerShape(40.dp)
                )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ){
                Text(
                    text = "Reviews and questions: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                LazyRow(
                    modifier = Modifier.fillMaxSize()
                ){
                    items(products){ item ->
                        Card(
                            border = BorderStroke(5.dp, MaterialTheme.colorScheme.onTertiary),
                            modifier = Modifier
                                .padding(vertical = 5.dp, horizontal = 5.dp)
                                .width(350.dp)
                                .clickable{},
                            shape = RoundedCornerShape(0.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.outline
                            ),
                            elevation = CardDefaults.cardElevation(focusedElevation = 30.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically
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
                                        fontSize = 20.sp,
                                        modifier = Modifier
                                            .padding(bottom = 10.dp),
                                        color = MaterialTheme.colorScheme.primary,
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
