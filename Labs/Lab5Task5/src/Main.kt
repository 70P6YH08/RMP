import kotlin.random.Random
import kotlin.math.abs

var board = Array(8){ Array(8) {"[ ]"} }

fun main() {

    val queens = mutableListOf<Pair<Int, Int>>()

    for (i in 0..7) {

        var queenRow = 0
        var queenColumn = 0

        do {
            queenRow = Random.nextInt(8)
            queenColumn = Random.nextInt(8)
        } while (board[queenRow][queenColumn] == "[!]")

        board[queenRow][queenColumn] = "[!]"

        queens.add(queenRow to queenColumn)
    }

    board.forEach { rows ->
        rows.forEach{ cell ->
            print(cell)
        }
        println()
    }

    for (i in 0..7){
        for (j in 1..7){

            val queen1 = queens[i]
            val queen2 = queens[j]

            val queenRow1 = queen1.component1()
            val queenRow2 = queen2.component1()
            val queenColumn1 = queen1.component2()
            val queenColumn2 = queen2.component2()

            if(queenRow1 == queenRow2 ||
                queenColumn1 == queenColumn2 ||
                abs(queenRow1 - queenRow2) == abs(queen1.component2() - queen2.component2()) ){
                if(!(queen1.first == queen2.first && queen1.second == queen2.second))
                    println("Пара ферзей, бьющих друг друга: ${queen1.first + 1},${queen1.second + 1} и ${queen2.first + 1},${queen2.second + 1}")
            }
        }
    }
}