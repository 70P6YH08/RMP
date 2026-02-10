class Student(name: String, age: Int, open val group: String) : Human(name, age) {

    override val info: String
        get() = super.info + " группа: $group"

    override fun toString(): String {
        return super.toString() + " группа: $group"
    }

    override fun humanInfo() {
        super.humanInfo()
        println("Группа: $group")
    }
}