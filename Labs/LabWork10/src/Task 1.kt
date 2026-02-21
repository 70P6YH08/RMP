import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    launch (Dispatchers.Default)
    { sheep() }
    launch { cat() }
    Unit;
}

suspend fun sheep() {
    for (i in 1..500) {
        println("$i овечка")
    }

    delay(1000)

    for (i in 501..1000) {
        println("$i овечка")
    }
}

suspend fun cat() {
    for (i in 1..500) {
        println("$i котик")
        delay(10)
    }
}