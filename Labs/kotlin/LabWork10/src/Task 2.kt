import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    println("Введите 'cancel' для отмены загрузки:")

    val downloader = launch(Dispatchers.IO) {
        downloadFile()
    }

    val cancel = readln()
    if (cancel == "cancel")
        downloader.cancel()
}

suspend fun downloadFile() = coroutineScope {
    try {
        for (i in 1..30) {
            println("Загрузка файла $i")
            delay(3000)
        }
        println("Все файлы загружены")
    } catch (e: CancellationException) {
        println("Загрузка отменена")
    }
}