package com.example.files

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.files.ui.theme.FilesTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier){
        val context = LocalContext.current

        //Internal
        context.filesDir?.let{Text(it.path)}
        context.getDir("custom", 0)?.let{Text(it.path)}

        //External
        context.getExternalFilesDir("custom")?.let{Text(it.path)}
        context.getExternalFilesDirs("custom").forEach{
            Text(it.path)
        }

        Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS
        )?.let{Text(text = it.path)}

        val file = File(context.filesDir,
            "example.txt")

        file.writeText(text = "Привет из файла")

        val text = if(file.exists()) file.readText() else ""

        Text(text = text)

        val eula = context.assets.open("sample.txt")
            .bufferedReader().use{
                it.readText()
            }

        Text(text = eula)

        var path by remember { mutableStateOf<Uri?>(null) }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ){ uri ->
            path = uri
        }

        Button(onClick = {launcher.launch("image/*")}){
            Text(text = "Select")
        }

        Text(text = path.toString())
    }
}