import kotlin.math.PI
import kotlin.math.pow

class Circle(val radius : Double): Figure(){

    override fun figureSquare() : Double {
        return PI* radius.pow(2)
    }

    override fun figurePerimetr(): Double {
        return 2 * PI * radius
    }

    override fun figureInfo() : String {
        return ("Название фигуры: $figureName")
    }

    override val figureName: String
        get() = "Круг"

}