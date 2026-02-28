class Animal(_view : String){

    //Task 1 and 4

    var view : String = _view
        set(value){
            if(value.length > 0)
                field = value
        }
        get() = field

    var age : Int = 0
        set(value){
            if(value > 0)
                field = value
        }
        get() = field

    var mass : Int = 0
        set(value){
            if(value > 0)
                field = value
        }
        get() = field

    var name : String = "хз"
        set(value){
            if(value.length > 0)
                field = value
        }
        get() = field

    //Task 2

    constructor(_view : String, _age : Int, _mass : Int, _name : String) : this(_view) {
        age = _age
        mass = _mass
        name = _name
    }

    //Task 3

    fun printInfo(){
        println("Вид: ${view}, возраст: ${age}, " +
                "вес: ${mass}, кличка: ${name}")
    }

    val onlyName : String
        get() = "Кличка: $name"



}