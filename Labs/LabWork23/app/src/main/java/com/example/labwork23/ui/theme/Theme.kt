package com.example.labwork23.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFB08A09),
    onPrimary = Color(0xFF703020),
    secondary = Color(0xFF522222),
    onSecondary = Color(0xFF4F3020),
    tertiary = Color(0xFFA16746),
    onTertiary = Color(0xFF000000),
    background = Color(0xFF321212),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF220212),
    onSurface = Color(0xFFFFFFFF),
    error = Color(0xFFCF6679),
    onError = Color(0xFF000000)
)

private val UserDarkColorScheme = darkColorScheme(
    primary = Color(0xFF20AA09),
    onPrimary = Color(0xFF203080),
    secondary = Color(0xFF1A2A5A),
    onSecondary = Color(0xFF102060),
    tertiary = Color(0xFF3F77AD),
    onTertiary = Color(0xFF000000),
    background = Color(0xFF0A1A4A),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF0A1A2A),
    onSurface = Color(0xFFE0E0E0),
    error = Color(0xFFE57373),
    onError = Color(0xFF000000)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFA700F5),
    onPrimary = Color(0xFFAFAFFF),
    secondary = Color(0xFF8F8FCF),
    onSecondary = Color(0xFF000000),
    tertiary = Color(0xBFAF67F6),
    onTertiary = Color(0xBF6F2786),
    background = Color(0xFFFFD7F9),
    onBackground = Color(0xFF000050),
    surface = Color(0xFFEFB7D9),
    onSurface = Color(0xFF000000),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF)
)

private val UserLightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color(0xDF0AF04A),
    secondary = Color(0xFF0CD04A),
    onSecondary = Color(0xDF0AD04A),
    tertiary = Color(0xFF2FB726),
    onTertiary = Color(0xDF0A602A),
    background = Color(0xFFA0FABA),
    onBackground = Color(0xFF212121),
    surface = Color(0xFF80FA5A),
    onSurface = Color(0xFF212121),
    error = Color(0xFFEF5350),
    onError = Color(0xFFFFFFFF)
)




//enum class ColorStyle {
//    DEFAULT,
//    USER
//}
@Composable
fun LabWork23Theme(
//    colorStyle: ColorStyle,
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorStyle: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
//        darkTheme && colorStyle == ColorStyle.DEFAULT -> DarkColorScheme
//        darkTheme && colorStyle == ColorStyle.USER -> UserDarkColorScheme
//
//        !darkTheme && colorStyle == ColorStyle.DEFAULT -> LightColorScheme
//        else -> UserLightColorScheme

        darkTheme && !colorStyle -> DarkColorScheme
        darkTheme && colorStyle -> UserDarkColorScheme

        !darkTheme && colorStyle -> LightColorScheme
        else -> UserLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}