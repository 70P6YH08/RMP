open class Human(val name : String, val age : Int){

    open val info : String
        get() = "имя: $name, лет: $age"

    override fun toString(): String {
        return "Имя: $name, лет: $age"
    }

    open fun humanInfo(){
        println("Имя: $name\nВозраст: $age")
    }
}