package com.example.lab23.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun Bank() {
    val randNum = remember { mutableStateOf(Random.nextInt(1, 100)) }
    val randSum = remember { mutableStateOf(Random.nextInt(1, 1000)) }
    val randBalance = remember { mutableStateOf(Random.nextInt(1, 100)) }
    val settingsHide by remember { mutableStateOf(false) }
    val randSavings = remember { mutableStateOf(Random.nextInt(1, 100))}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.6f)
                .border(
                    BorderStroke(2.dp, color = Color.DarkGray),
                    shape = RoundedCornerShape(40.dp)
                )
                .clickable {}
        ) {
            Box(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Магаз-банк",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    BadgedBox(
                        badge = {
                            Badge(
                                contentColor = MaterialTheme.colorScheme.inverseSurface,
                                containerColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ) {
                                Text(
                                    text = randNum.value.toString(),
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }
                        }
                    ) {
                        Icon(
                            Icons.Filled.Notifications,
                            "",
                            modifier = Modifier
                                .clickable {}

                        )
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    BadgedBox(
                        badge = {
                            if (settingsHide == true) {
                                Badge {
                                    Text(
                                        text = randNum.value.toString(),
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                }
                            }
                        }
                    ) {
                        Icon(
                            Icons.Filled.Settings,
                            "",
                            modifier = Modifier
                                .clickable {}

                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxHeight(0.6f)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth(0.5f)
                            .fillMaxHeight()
                            .border(
                                BorderStroke(2.dp, color = Color.DarkGray),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable {}
                    ) {
                        Text(
                            text = "Скидка в магазе!!!",
                            modifier = Modifier
                                .padding(start = 20.dp, top = 15.dp),
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                        Row(
                            modifier = Modifier
                                .clickable {}
                                .fillMaxSize(),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.77f),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "20",
                                    fontSize = 100.sp,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "%",
                                    fontSize = 30.sp,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Column(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.322f)
                                .border(
                                    BorderStroke(2.dp, color = Color.DarkGray),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {},
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Траты за месяц",
                                fontSize = 10.sp,
                                modifier = Modifier
                                    .padding(start = 10.dp),
                                color = MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = "${randSum.value.toString()} $",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(start = 10.dp),
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.49f)
                                    .fillMaxHeight(0.5f)
                                    .border(
                                        BorderStroke(2.dp, color = Color.DarkGray),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .clickable {},
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Оплатить QR-кодом",
                                    fontSize = 10.sp,
                                    modifier = Modifier
                                        .padding(10.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.5f)
                                    .border(
                                        BorderStroke(2.dp, color = Color.DarkGray),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .clickable {},
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Переводы\nи платежи",
                                    fontSize = 10.sp,
                                    modifier = Modifier
                                        .padding(10.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(1f)
                                .border(
                                    BorderStroke(2.dp, color = Color.DarkGray),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {},
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = ""
                            )
                            Text(
                                text = "Пополнить кошелёк",
                                fontSize = 10.sp,
                                color = MaterialTheme.colorScheme.inverseOnSurface
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                Column(
                    modifier = Modifier
                        .padding(top = 250.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .border(
                            BorderStroke(2.dp, color = Color.DarkGray),
                            shape = RoundedCornerShape(40.dp)
                        )
                        .clickable {}
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "${randBalance.value} $",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Баланс кошелька",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 10.dp)
                                .border(
                                    BorderStroke(2.dp, color = Color.DarkGray),
                                    shape = RoundedCornerShape(40.dp)
                                )
                                .clickable {},
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(start = 10.dp)
                            ) {
                                Text(
                                    text = "Откройте карту банка",
                                    color = MaterialTheme.colorScheme.onSecondary
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                horizontalAlignment = Alignment.End
                            ) {
                                Icon(Icons.Filled.Add, "")
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    BorderStroke(2.dp, color = Color.DarkGray),
                    shape = RoundedCornerShape(40.dp)
                )
                .clickable {}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, color = Color.DarkGray),
                        shape = RoundedCornerShape(40.dp)
                    )
                    .clickable {}
            ) {
                Box(
                    modifier = Modifier
                        .padding(20.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.475f)
                            .border(
                                BorderStroke(2.dp, color = Color.DarkGray),
                                shape = RoundedCornerShape(40.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Накопления",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                            Text(
                                text = "${randSavings.value} $",
                                fontSize = 35.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .padding(top = 125.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .border(
                                BorderStroke(2.dp, color = Color.DarkGray),
                                shape = RoundedCornerShape(40.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Сертификаты",
                                fontSize = 35.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "и другое",
                                fontSize = 35.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}