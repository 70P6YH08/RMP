package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Greeting
import com.example.myapplication.ui.theme.MyApplicationTheme

@Preview(showBackground = true)
@Composable
fun Authorization() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "АВТОРИЗАЦИЯ", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Column(){
            Text(text = "Логин", fontSize = 20.sp)
            TextField(value = "Логин", onValueChange = {})
        }
        Column(){
            Text(text = "Пароль", fontSize = 20.sp)
            TextField(value = "Пароль", onValueChange = {})
        }
        Button({})
        {
            Text(text = "Авторизоваться")
        }
    }
}