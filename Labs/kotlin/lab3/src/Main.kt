import kotlin.math.pow

fun main() {

    //TASK 1
    print("Введите а: ")
    var a = readln().toInt()
    print("Введите а: ")
    var b = readln().toInt()

    println("$a + $b = ${a+b}")
    println("$a - $b = ${a-b}")
    println("$a * $b = ${a*b}")
    println("$a // $b = ${a/b}")
    println("$a % $b = ${a%b}")

    //TASK 2

    print("Введите имя: ")
    val name = readln().toString()

    print("Введите рост в см: ")
    val height = readln().toDouble()

    print("Введите массу тела: ")
    val mass = readln().toInt()

    var imt = mass / (height /100).pow(2)
    println("$name, ваш ИМТ=$imt")

    //TASK 3

    print("Введите целое число (количество секунд): ")
    var seconds = readln().toInt()

    var hours: Int = seconds / 3600
    while (hours >= 24){
        seconds -= 24 * 3600
        hours = seconds / 3600
    }
    val minutes: Int = seconds % 3600 / 60
    seconds %= 60
    val time = format("%02d:%02d:%02d", hours, minutes, seconds)
    println(time)

    //TASK 4

    println("Введите год: ")
    val year = readln().toInt()

    println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)

    //TASK 5

    print("Введите маленький радиус: ")
    val inR = readln().toDouble()
    print("Введите большой радиус: ")
    val exR = readln().toDouble()

    val pi = 3.14
    val sInR = pi * inR.pow(2)
    val sExR = pi * exR.pow(2)
    val sCircle = sExR - sInR
    println("Площадь кольца = $sCircle")
}


