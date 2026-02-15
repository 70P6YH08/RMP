import kotlin.math.round

//Task 1.1
val fruits = mutableListOf("арбузы", "виноград", "яблоки", "сливы", "бананы")

//Task 2.1
val numbers = mutableListOf(1,-2,51,-82,-4,21,72,4,-63,-100, 100, 126,1741,-123,-26,12,-15)

//Task 3.1
val countries
    = mutableMapOf("GE" to "Грузия",
    "AU" to "Австралия",
    "JM" to "Ямайка",
    "AT" to "Австрия",
    "GL" to "Гренландия",
    "GR" to "Греция",
    "GE" to "Грузия",
    "DJ" to "Джибути",
    "JP" to "Япония",
    "DM" to "Доминика",
    "GR" to "Греция",
    "JP" to "Япония",
    "EG" to "Египет",
    "AT" to "Австрия",
    "DM" to "Доминика",
    "GR" to "Греция",
    "JP" to "Япония",
    "ZW" to "Зимбабве",
    "JM" to "Ямайка",
    "JP" to "Япония")

//Task 5.1

val group = listOf(
    setOf("Иванов Иван Иванович",
        "Петров Петр Петрович",
        "Соколов Максим Денисович",
        "Фёдорова Наталья Павловна",
        "Морозов Игорь Валерьевич",
        "Павлов Кирилл Геннадьевич",
        "Козлова Юлия Борисовна",
        "Семёнов Павел Эдуардович",
        "Степанов Андрей Фёдорович",
        "Борисов Владислав Олегович",
        "Савельева Дарья Александровна"),
    setOf("Петров Петр Петрович",
        "Сидорова Анна Сергеевна",
        "Кузнецов Дмитрий Алексеевич",
        "Смирнова Елена Владимировна",
        "Фёдорова Наталья Павловна",
        "Морозов Игорь Валерьевич",
        "Волкова Мария Ильинична",
        "Алексеев Сергей Николаевич",
        "Семёнов Павел Эдуардович",
        "Матвеев Роман Владимирович",
        "Савельева Дарья Александровна",
        "Громов Виктор Сергеевич")
)

fun main() {

//    //Task 1.2
//    fruits.add("дыня")
//    fruits.add("персик")
//    fruits.add("мандарин")
//
//    //Task 1.3
//    fruits.forEach {
//        println("${fruits.indexOf(it) + 1} - $it")
//    }
//
//    println()
//
//    //Task 1.2
//    print("Введите количество фруктов, которые хотите добавить: ")
//    val fruitCount = readln().toInt()
//
//    var fruit : String
//    repeat(fruitCount) {
//        fruit = readln()
//        fruits.add(fruit)
//    }
//
//    println()
//
//    //Task 1.3
//    fruits.forEach { fruit ->
//        println("${fruits.indexOf(fruit) + 1} - $fruit")
//    }
//
//    println()
//
//    //Task 2.2
//
//    print("Введите количество чисел, которые хотите добавить: ")
//    val numbersCount = readln().toInt()
//
//    var number : Int
//    repeat(numbersCount) {
//        number = readln().toInt()
//        numbers.add(number)
//    }
//
//    println(numbers.indexOf(100))
//    println(numbers.sum())
//    println(round(numbers.average() * 100) / 100)
//
//    numbers.filter { it < 0 }.forEach {
//        println("$it < 0!")
//    }
//    println("${numbers.count({num -> num < 0 })} чисел меньше нуля!")
//
//    println("Все нечётные числа: ")
//    numbers.filter{num -> num % 2 != 0}.forEach { num ->
//        println(num)
//    }
//
//    println()
//
//    //Task 3.2
//    countries.put("IL","Израиль")
//    countries.put("IN","Индия")
//    countries.put("ID","Индонезия")
//
//    print("Введите количество стран, которые хотите добавить в словарь: ")
//    val countryCount = readln().toInt()
//    var country : String
//    var countryCode : String
//    repeat(countryCount){
//        country = readln()
//        countryCode = readln()
//        countries.put(countryCode,country)
//    }
//
//    //Task 3.3
//    countries.forEach {(countryCode, countryName) ->
//        println("${countryCode} - ${countryName}")
//    }
//
//    println()
//
//    //Task 4.1
//    print("Укажите двухбуквенный код страны, который хотите найти: ")
//    countryCode = readln()
//    println(countries.getOrElse(countryCode){"Указанный ключ в словаре отсутствует!"})
//
//    //Task 4.2
//    print("Введите название страны: ")
//    country = readln()
//    println(countries.values.count({name -> name == country}))
//
//    //Task 4.3
//    print("Укажите ключ элемента, который хотите удалить: ")
//    countryCode = readln()
//    countries.remove(countryCode)
//    countries.forEach { (code,country) ->
//        println("$code - $country")
//    }

    println()

    //Task 5.2.1
    val retakeGroup = group[0].union(group[1])
    println("${retakeGroup.size} студентов было отправлено на пересдачу: ")
    //  println((group[0] + group[1]).distinct().size)
    retakeGroup.forEach {
        println(it)
    }

    println()

    //Task 5.2.2
    val bothFailedStudents = group[0].intersect(group[1])
    println("${bothFailedStudents.size} студентов не сдали оба зачёта: ")
    bothFailedStudents.forEach {
        println(it)
    }

    println()

    //Task 5.2.3
    val oneFailedStudents = retakeGroup - bothFailedStudents
    println("${oneFailedStudents.size} студентов не сдали только 1 зачёт: ")
    oneFailedStudents.forEach {
        println(it)
    }
}