import kotlin.math.pow

fun main() {

    //Task4

//    println("Введите название процента: ")
//    val name = readln()
//    val namePercent = count(name)
//    val result = namePercent(10000.0,10.0,10.0)
//    println("%.2f".format(result))

    println("Введите количество продуктов: ")
    var countProducts = readln().toInt()

    val func = addProduct(countProducts)
    func()

}

//4

//val simplePercent = { so: Double, r: Double, n : Double -> so * (1 + r/100 * n)}
//val hardPercent = { so: Double, r: Double, n : Double -> so * (1 + r/100).pow(n)}
//
//fun count (namePercent : String) : (Double, Double, Double) -> Double {
//    return when(namePercent){
//        "простой" -> simplePercent
//        "сложный" -> hardPercent
//        else -> {
//            _, _, _-> 0.0
//        }
//    }
//}

//5

fun addProduct(count: Int) : () -> Unit{

    fun product(name: String = "'творог'", price: Double = 100.0){
        println("В корзину добавлен $name на сумму ${price * count}")
    }
    return ::product
}
