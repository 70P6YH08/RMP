import kotlin.math.pow

fun main() {

    //Task4

    println("Введите название процента: ")
    val name = readln()
    val namePercent = count(name)
    val result = namePercent(10000.0,10.0,10.0)
    println("%.2f".format(result))

    //Task 5

    println("Введите название продукта: ")
    var nameProduct = readln()
    println("Введите цену продукта: ")
    var priceProduct = readln().toDouble()
    val addProduct = addProduct(nameProduct,priceProduct)

    addProduct(3)
}

//4

val simplePercent = { so: Double, r: Double, n : Double -> so * (1 + r/100 * n)}
val hardPercent = { so: Double, r: Double, n : Double -> so * (1 + r/100).pow(n)}

fun count (namePercent : String) : (Double, Double, Double) -> Double {
    return when(namePercent){
        "простой" -> simplePercent
        "сложный" -> hardPercent
        else -> {
            _, _, _-> 0.0
        }
    }
}

//5

fun addProduct(nameProduct: String, price: Double) : (Int) -> Unit {
    return { count ->
        val totalPrice = price * count
        println("В корзину добавлен $nameProduct на сумму ${price * count}")
    }
}

