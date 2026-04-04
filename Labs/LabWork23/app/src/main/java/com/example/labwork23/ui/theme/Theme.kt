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
    primary = Color(0xFF96C4EC),
    onPrimary = Color(0xFF003355),
    secondary = Color(0xFF5E6C91),
    onSecondary = Color(0xFF1A2C4A),
    tertiary = Color(0xFF7B6898),
    onTertiary = Color(0xFF2F1B4D),
    background = Color(0xFF121212),
    onBackground = Color(0xFF9B7A7A),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE3E3E3),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00639B),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF536DFF),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF7C4DFF),
    onTertiary = Color(0xFFFFFFFF),
    background = Color(0xFFF5F9FF),
    onBackground = Color(0xAF82CAFF),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF499CFF),
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF)
)

private val UserLightColorScheme = lightColorScheme(
    primary = Color(0xFFB0F3AC),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF53FF6A),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFFFCA55A),
    onTertiary = Color(0xFFE3C9C9),
    background = Color(0xFFC6D6F6),
    onBackground = Color(0xAF82CAFF),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF499CFF),
    error = Color(0xFFF8632A),
    onError = Color(0xFFE1A9A9)
)

private val UserDarkColorScheme = darkColorScheme(
    primary = Color(0xFF5B7C9A),
    onPrimary = Color(0xFF001E2F),
    secondary = Color(0xFF5E6D98),
    onSecondary = Color(0xFF232E49),
    tertiary = Color(0xFF68A186),
    onTertiary = Color(0xFF4C6250),
    background = Color(0xFF312E2E),
    onBackground = Color(0xFF7A90A1),
    surface = Color(0xFF262121),
    onSurface = Color(0xFFE3E3E3),
    error = Color(0xFFCE6D33),
    onError = Color(0xFFEAD847)
)


enum class ColorStyle {
    DEFAULT,
    USER
}
@Composable
fun LabWork23Theme(
    colorStyle: ColorStyle,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme && colorStyle == ColorStyle.DEFAULT -> DarkColorScheme
        darkTheme && colorStyle == ColorStyle.USER -> UserDarkColorScheme

        !darkTheme && colorStyle == ColorStyle.DEFAULT -> LightColorScheme
        else -> UserLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}