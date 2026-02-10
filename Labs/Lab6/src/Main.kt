import org.w3c.dom.css.Counter
import javax.swing.GroupLayout.Alignment
import kotlin.math.pow
import kotlin.math.PI
import kotlin.math.round

fun main() {
    //Task 1

    println("Искомый член геометрической прогрессии: ${progressMember(5)}")

    //Task 2

    print("Площадь круга: ")
    println(squareCircle(5.2))
    print("Площадь эллипса: ")
    println(squareCircle(5.2, 2.5))

    //Task 3

    print("Размах: ${scope(2,34,5,61,25,26)}")
    println()
    //Task 4

//    print("Сумма по вкладу будет: ${percent(10000, 10, 10, "сложный")}")

    //Task 5

//    println(addProduct("dsd",2.0))
}

//1

fun progressMember(n: Int, a: Int = 1, q: Double = 2.0) : Int{
    return a * (q.pow(n-1)).toInt()
}

//2

fun squareCircle(radius: Double) : String{
    return "%.2f".format(PI * radius.pow(2))
}
fun squareCircle(shortAxis: Double, longAxis: Double) : String{
    return "%.2f".format(PI * shortAxis * longAxis)
}

//3

fun scope(vararg numbers: Int) : Int{
    return numbers.max() - numbers.min()
}

//4

fun percent(name : String): (Double) -> (so : Int, r : Int, n : Int) {
    
}

fun simplePercent(so : Int, r : Int, n : Int): Double{
    return (so * (1 + r/100 * n)).toDouble()
}

fun hardPercent(so : Int, r : Int, n : Int): Double{
    return (so * (1 + r/100)).toDouble().pow(n)
}

//5

//fun addProduct(name: String, price : Double): ()->String{
//    fun printInfo(count : Int){
//        retu
//    }
//}