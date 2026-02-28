import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    try {
        withTimeout(10000){
            connectDB()
        }
    }
    catch (e : TimeoutCancellationException){
        println("Превышено время ожидания")
    }
}

suspend fun connectDB() = coroutineScope {
    repeat(5) {
        println("Попытка подключения к БД")
        delay(3000)
    }
}