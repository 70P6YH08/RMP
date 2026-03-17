package com.example.labwork14

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
import com.example.labwork14.ui.theme.LabWork14Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork14Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Divide(4.2, 0.0)

                }
            }
        }
    }
}

/**
 * Функция отображает приветствие с указанием имени
 *
 * @param name - параметр функции "имя" (в данном случае Android)
 * @param modifier - параметр модификатор, используемый для стилизации
 * @sample com.example.labwork14.sampleGreeting
 * @since 1.9.8
 * @author Кимасик Studio
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/**
 * Функция вызывает функцию Greeting, в которой указывается параметр в виде строки
 * Функция имеет компонент Preview, который даёт возможность предпросмотра
 * Не имеет параметров
 *
 * @sample com.example.labwork14.sampleGreetingPreview
 * @since 1.12.2
 * @author Android Горбунов
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWork14Theme {
        Greeting("Android")
    }
}

/**
 * Функция делит 2 числа и вычисляет результат
 *
 * @param a - первый параметр функции (делимое)
 * @param b - второй параметр функции (делител)
 * @return возвращает результат деления
 * @throws ArithmeticException - функция выбрасывает исключение, если b = 0
 * @sample com.example.labwork14.sampleDivide
 * @since 1.13.2
 * @author Ега Studio
 */

fun Divide(a: Double, b : Double): Double{
    if (b == 0.0)
        throw ArithmeticException("На 0 делить нельзя")
    return a / b
}

/**
 * Класс, в котором хранится логин и пароль пользователя
 *
 * @param login - логин пользователя
 * @param password - пароль пользователя
 * @sample com.example.labwork14.sampleUserData
 * @since 1.14.3
 * @author Android Денисов
 */

data class UserData(
    var login : String,
    var password : String = "123qwe123",
){
    /**
     * Функция, которая проверяет, совпадает ли введённый пароль с паролем пользователя
     *
     * @param testPassword - проверяемый пароль строкового типа данных
     * @return возвращает true, если пароль совпадает, false в противном случае
     * @sample com.example.labwork14.sampleCheckPassword
     * @since 1.21.4
     * @author КЕГД
     */
    fun CheckPassword(testPassword: String) : Boolean{
        if (testPassword == password)
            return true
        else
            return false
    }
}

@Composable
fun sampleGreeting(){
    Greeting("asdad", Modifier)
}

@Composable
fun sampleGreetingPreview(){
    GreetingPreview()
}

@Composable
fun sampleDivide(){
    Divide(4.2, 3.3)
}

@Composable
fun sampleUserData(){
    val user = UserData("Колян", "Realnii_pacan_1990")
}

@Composable
fun sampleCheckPassword(){
    val password = UserData("Колян")
    password.CheckPassword("123qwe124")
}
