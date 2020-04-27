import kotlin.random.Random

fun main() {
//    println(rollDice(6, 6))
    var pyramidalPeteWins = 0
    var cubicColinWins = 0
    var i = 1
    while (i <= 10000000) {
        println(i)
        val peteTotal = rollDice(4, 9)
        val colinTotal = rollDice(6, 6)
        when (peteTotal > colinTotal) {
            true -> pyramidalPeteWins++
            false -> cubicColinWins++
        }
        i++
    }
    println(pyramidalPeteWins)
}

fun rollDice(sides: Int, numOfDice: Int): Int {
    var total = 0
    var dice = 0
    while (dice < numOfDice) {
        val value = Random.nextInt(1, sides + 1)
//        println(value)
        total += value
        dice++
    }
    return total
}