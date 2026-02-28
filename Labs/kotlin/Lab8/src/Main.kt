fun main(){
    //Task 2

    val person1 = Human("Колян", 2)
    println(person1.info)
    println(person1.toString())
    person1.humanInfo()

    println()

    val student1 = Student("Володенька", 76,"КГБ-75")
    println(student1.info)
    println(student1.toString())
    student1.humanInfo()

    println()

    //Task 3

    val circle1 = Circle(8.2)
    println(circle1.figureSquare())
    println(circle1.figurePerimetr())
    println(circle1.figureInfo())
    println(circle1.figureName)

    println()

    //Task 4

    val randomElements = RandomDataSource{(0..100).random()}
    val staticElements = StaticDataSource(arrayOf(1,2,3,4,5,6))

    println("Рандомные")
    printElements(randomElements)
    println("Статичные")
    printElements(staticElements)

    //Task 5

    val serviceName = FoodService("Додо пицца")
    val order = DeliveryApplication(serviceName)

    order.deliver(2)
    order.orderCreate(3)
}

fun <T> printElements(element : DataSource<T>){
    repeat(10){
        println(element.getNext())
    }
}
