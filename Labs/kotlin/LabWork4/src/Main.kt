import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.sqrt
import kotlin.math.pow
import kotlin.math.round

fun main() {

    //Task 1

    val year = readln().toInt()
    val numberMonth = readln().toInt()
    val leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

    println(leap)

    when (numberMonth) {
        1, 3, 5, 7, 8, 10, 12 -> println("В месяце 31 дней")
        4, 6, 9, 11 -> println("В месяце 30 дней")
        2 -> {
            if (leap)
                println("В месяце 29 дней")
            else
                println("В месяце 28 дней")
        }

        else -> println("Такого месяца не существует ")
    }

    print("Сезон:")
    when (numberMonth) {
        1, 2, 3 -> println("зима")
        4, 5, 6 -> println("весна")
        7, 8, 9 -> println("лето")
        10, 11, 12 -> println("осень")
        else -> println("Такого время года не существует")
    }

    println()

    //Task 2

    val aSize = readln().toInt()
    val bSize = readln().toInt()
    val cSize = readln().toInt()

    if (aSize + bSize > cSize && aSize + cSize > bSize && bSize + cSize > aSize) {
        println("Такой треугольник существует")
        if (aSize == bSize && aSize == cSize)
            println("Этот треугольник равносторонний")
        else if (aSize == bSize || bSize == cSize || cSize == aSize)
            println("Этот треугольник равнобедренный")
        else
            println("Этот треугольник разносторонний")
    } else
        println("Такого треугольника не существует")

    //Task 3

    val eurRate = 90.29
    val usdRate = 76.01

    println("Введите валюту: usd/eur")
    val currency = readln()
    println("Введите сумму в рублях:")
    val rubSum = readln().toDouble()


    when (currency) {
        "eur" -> println("Сумма в евро: ${"%.2f".format(round(rubSum / eurRate))}")
        "usd" -> println("Сумма в долларах: ${"%.2f".format(round(rubSum / usdRate))}")
        else -> println("%.2f".format(rubSum))
    }

    //Task 4

    val a = readln().toDouble()
    val x = readln().toDouble()

    if (x < 0)
        println("a + x.pow(3) = ${"%.3f".format(a + x.pow(3))}")
    else if (x >= 0 && x < 3)
        println("sin(x) + cos(x) = ${"%.3f".format(sin(x) + cos(x))}")
    else if (x >= 3 && x < 5){
        if (a != x)
            println("1 /(a - x) = ${"%.3f".format(1 /(a - x))}")
        else
            println("Делить на 0 нельзя")
    }
    else if (x >= 5){
        if (x >= a)
            println("sqrt(x - a) = ${"%.3f".format(sqrt(x - a))}")
        else
            println("Корень не может быть отрицательным")
    }
    else
        println("Результат вывести невозможно")

    //Task 5

    var amount = readln().toDouble()
    var deposit = readln().toDouble()

    if (amount > 5000)
        amount -= amount * 0.1
    else if (amount > 1000)
        amount -= amount * 0.05
    println("Сумма к оплате: ${"%.2f".format(amount)}")

    if (amount == deposit)
        println("Спасибо")
    else if (amount < deposit)
        println("Возьмите сдачу: ${deposit - amount}")
    else
        println("Требуется доплатить ${amount - deposit}")

}