import kotlin.system.exitProcess

fun main(){
    println()

    //Task 1

    var animal1 = Animal("дворовая")
    println("Вид: ${animal1.view}, " +
            "возраст: ${animal1.age}, " +
            "масса: ${animal1.mass}, " +
            "кличка: ${animal1.name}")
    animal1.view = "мейн-кун"
    animal1.age = 1
    animal1.mass = 2
    animal1.name = "Муся"
    println("Вид: ${animal1.view}, " +
            "возраст: ${animal1.age}, " +
            "масса: ${animal1.mass}, " +
            "кличка: ${animal1.name}")

    println()

    //Task 2

    var cat = Animal("манчкин", 2, 4, "Колян")
    println("Вид: ${cat.view}, " +
            "возраст: ${cat.age}, " +
            "масса: ${cat.mass}, " +
            "кличка: ${cat.name}")

    var dog = Animal("гончая")
    println("Вид: ${dog.view}, " +
            "возраст: ${dog.age}, " +
            "масса: ${dog.mass}, " +
            "кличка: ${dog.name}")

    println()

    //Task 3

    var angryDog = Animal("бультерьер", 3, 4, "Серёга")
    angryDog.printInfo()

    println(angryDog.onlyName)

    println()

    //Task 4

    val elephant1 = Animal("индийский", 6, 5000, "Тоха")
    val elephant2 = Animal("индийский", -2, -6, "")
    elephant1.printInfo()
    elephant2.printInfo()

    println()

    //Task 5

    val animals = arrayOf(
        Animal("египетская", 2, 3, "Сара"),
        Animal("дворовая", 7, 4, "Вадик"),
        Animal("дикая", 5, 2, "Кирюха Про")
    )

    val findAnimal = animals.find{it.mass == 2}
    if (findAnimal != null) {
        findAnimal.printInfo()
    }
}