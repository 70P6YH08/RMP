package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab14.ui.theme.Lab14Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab14Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    divide(50.0,2.0)
                }

            }
        }
    }
}

/**
 * Функция отображает текст приветствия
 * @param name - это имя пользователя, которое должно вставится в текст функции
 * @param modifier - это модификатор для настройки внешнего вида текста
 * @sample com.example.lab14.GreetingPreview
 * @since 1.2.3
 * @author Ega Denisov
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


/**
 * Отображает приветствие с именем.
 * @sample com.example.lab14.MainActivity.onCreate
 * @since 1.2.3
 * @author Ega Denisov
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab14Theme {
        Greeting("Android")
    }
}


/**
 * Делит одно число на другое.
 *
 * @param x делимое.
 * @param y  делитель.
 * @return частное от деления.
 * @throws ArithmeticException если y (делитель) = 0.
 * @sample com.example.lab14.MainActivity.onCreate
 * @since 1.2.3
 * @author Kima Gorbunov
 */
fun divide (x: Double, y: Double) : Double{
    if (y == 0.0)
        throw ArithmeticException("Деление на 0!!!!!")
    return x / y
}

/**
 * Хранит учётные данные пользователя.
 *
 * @param login    логин пользователя.
 * @param password пароль пользователя.
 * @sample com.example.lab14.BD
 * @since 1.2.3
 * @author Kolyan Naumov
 */
data class BD(val login : String, val password : String){
    /**
     * Проверяет совпадение пароля.
     *
     * @param userPassword пароль для проверки.
     * @return true, если пароль совпадает. False в противном случае
     * @sample com.example.app.UsageExamples.checkExample
     * @since 1.2.3
     * @author Kolyan Naumov
     */
    fun check(userPassword: String) : Boolean{
        if (userPassword == password)
            return true
        else
            return false
    }
}