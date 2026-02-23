import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    val downloader : Deferred<Int> = async {
        connectWebServer()
    }
    println("${downloader.await()}")
}

suspend fun connectWebServer() : Int = coroutineScope {
    println("Подключение к веб-серверу")
    delay(1000)
    val codeArr = arrayOf(200, 400, 401, 403, 404, 410, 500)
    val random = codeArr.random()
    return@coroutineScope random
}