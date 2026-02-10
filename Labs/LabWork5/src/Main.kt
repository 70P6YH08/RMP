import kotlin.math.roundToInt
import kotlin.random.Random

fun main(){
    //Task 1

    println("y(x)=a*x+b")

    print("Введите x1: ")
    val x1 = readln().toInt()
    print("Введите x2: ")
    val x2 = readln().toInt()
    print("Введите a: ")
    val a = readln().toDouble()
    print("Введите b: ")
    val b = readln().toDouble()

    for (x in x1 .. x2) {
        println(a*x+b)
    }

    //Task 2

    for (m in 1 .. 9){
        var counter = 1
        while(counter < 10){
            print("${m * counter} \t")
            counter+=1
        }
        println()
    }

    //Task 3

    print("Введите сумму вклада: ")
    var deposit = readln().toDouble()

    print("Процент годовых: ")
    val precent = readln().toDouble()

    var year = 0
    while (deposit < 1000000){
        deposit += deposit * (precent/100)
        year+=1
        println("Сумма вклада на $year год: ${"%.2f".format(deposit)}")
    }
    println("Пользователь станет миллионером через $year лет")

    //Task 4

    val random = Random.nextInt(1, 10)

    do {
        print("Введите число:")
        val number = readln().toInt()
        when{
            (random > number) -> println("Требуется ввести большее число")
            (random < number) -> println("Требуется ввести меньшее число")
            else -> println("Вы молодец")
        }
    }while(random != number)
}