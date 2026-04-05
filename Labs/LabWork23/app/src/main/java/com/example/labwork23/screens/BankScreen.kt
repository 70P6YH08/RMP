package com.example.labwork23.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.CacheDrawModifierNode
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.concurrent.timer
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
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.background)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(6/10f)
                .border(
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                    shape = RoundedCornerShape(40.dp)
                )
                .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(40.dp))
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
                        text = "Magaz-bank",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    BadgedBox(
                        badge = {
                            Badge(
                                contentColor = MaterialTheme.colorScheme.primary,
                                containerColor = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier
                                    .border(
                                        BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                        shape = CircleShape
                                    )
                                    .background(MaterialTheme.colorScheme.onPrimary, CircleShape)
                            ) {
                                Text(
                                    text = randNum.value.toString(),
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.labelSmall
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
                                BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp))

                    ) {
                        Text(
                            text = "Discount in Magaz!!!",
                            modifier = Modifier
                                .padding(start = 20.dp, top = 15.dp),
                            style = MaterialTheme.typography.headlineLarge

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
                                    color = MaterialTheme.colorScheme.error,
                                    style = MaterialTheme.typography.displayLarge
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
                                    color = MaterialTheme.colorScheme.error,
                                    style = MaterialTheme.typography.headlineLarge
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
                                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {}
                                .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp)),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Monthly expenses",
                                modifier = Modifier
                                    .padding(start = 10.dp),
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "${randSum.value} $",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(start = 10.dp),
                                style = MaterialTheme.typography.labelMedium
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
                                        BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .clickable {}
                                    .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp)),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Pay with\na QR code",
                                    fontSize = 10.sp,
                                    modifier = Modifier
                                        .padding(10.dp),
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                            Spacer(modifier = Modifier.padding(start = 5.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.5f)
                                    .border(
                                        BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .clickable {}
                                    .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp)),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Transfers\nand payments",
                                    modifier = Modifier
                                        .padding(10.dp),
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(bottom = 5.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(1f)
                                .border(
                                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {}
                                .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = "Top up wallet",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
                Column(
                    modifier = Modifier
                        .padding(top = 300.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .border(
                            BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp)),
                    ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "${randBalance.value} $",
                            fontSize = 30.sp,
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Text(
                            text = "Wallet balance",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 20.dp)
                                .border(
                                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .clickable {}
                                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20.dp)),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(start = 10.dp)
                            ) {
                                Text(
                                    text = "Open a bank card",
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                horizontalAlignment = Alignment.End
                            ) {
                                Icon(
                                    Icons.Filled.Add,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.error
                                )
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
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                    shape = RoundedCornerShape(40.dp)
                )
                .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(40.dp)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
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
                                BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable {}
                            .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Savings",
                                style = MaterialTheme.typography.headlineLarge
                            )
                            Text(
                                text = "${randSavings.value} $",
                                fontSize = 35.sp,
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(bottom = 10.dp))
                    Column(
                        modifier = Modifier
                            .padding(top = 145.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .border(
                                BorderStroke(2.dp, color = MaterialTheme.colorScheme.onTertiary),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable {}
                            .background(MaterialTheme.colorScheme.onPrimary, RoundedCornerShape(20.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Certificates\nand more",
                                fontSize = 28.sp,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    }
                }
            }
        }
    }
}