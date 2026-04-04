package com.example.labwork23.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.labwork23.R

// Set of Material typography styles to start with

val CustomFont = FontFamily(
    Font(R.font.ashleycrawford)
)
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = CustomFont,
        fontSize = 57.sp,
        fontWeight = FontWeight.Normal
    ),
    headlineLarge = TextStyle(
        fontFamily = CustomFont,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = TextStyle(
        fontFamily = CustomFont,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = CustomFont,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = CustomFont,
        fontSize = 11.sp
    )
)