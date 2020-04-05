import java.util.*
import kotlin.random.Random

val SQUARES = mutableListOf(
    "GO",
    "A1",
    "CC1",
    "A2",
    "T1",
    "R1",
    "B1",
    "CH1",
    "B2",
    "B3",
    "JAIL",
    "C1",
    "U1",
    "C2",
    "C3",
    "R2",
    "D1",
    "CC2",
    "D2",
    "D3",
    "FP",
    "E1",
    "CH2",
    "E2",
    "E3",
    "R3",
    "F1",
    "F2",
    "U2",
    "F3",
    "G2J",
    "G1",
    "G2",
    "CC3",
    "G3",
    "R4",
    "CH3",
    "H1",
    "T2",
    "H2"
)
val COMMUNITY_CHEST_DECK = mutableListOf(
    "GO",
    "JAIL",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    ""
)
val CHANCE_DECK = mutableListOf(
    "GO",
    "JAIL",
    "C1",
    "E3",
    "H2",
    "R1",
    "R",
    "R",
    "U",
    "3",
    "",
    "",
    "",
    "",
    "",
    ""
)

fun main() {
//    println(CHANCE_DECK.size)
//    println(rollDice(31))
    //println(SQUARES.indexOf("H2"))
//    println(moveCommunityChest(11))
    //println(moveChance(11))
    //println(mostCommonElements(mutableListOf(1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 6)))
    println(simulate(10))
}

fun rollDice(curr_pos: Int): Int {
    val dice1 = Random.nextInt(1, 5)
    val dice2 = Random.nextInt(1, 5)
    println("dice1: $dice1")
    println("dice2: $dice2")
    return curr_pos + dice1 + dice2
}

fun moveCommunityChest(curr_pos: Int, card: String): Int {
//    val card = COMMUNITY_CHEST_DECK.get(Random.nextInt(0, 16))
//    println(card)
    if (card == "") {
        return curr_pos
    }
    return SQUARES.indexOf(card)
}

fun moveChance(curr_pos: Int, card: String): Int {
//    val card = CHANCE_DECK.get(Random.nextInt(0, 16))
//    println(card)
    if (card == "") {
        return curr_pos
    } else if (card.length >= 2) {
        return SQUARES.indexOf(card)
    }
    val curr_square = SQUARES.get(curr_pos)
    var square = SQUARES.indexOf(curr_square)
    while (square <= 39) {
        square++
        if (card == "R" && SQUARES.get(square).toCharArray()[0] == 'R') {
            return square
        } else if (card == "U" && SQUARES.get(square).toCharArray()[0] == 'U') {
            return square
        }
    }
    return curr_pos - 3
}

fun simulate(rolls: Int): MutableList<Int> {
    var most_common_cards = mutableListOf<String>()
    var list = mutableListOf<Int>()
    val community_chest = COMMUNITY_CHEST_DECK.shuffled().toMutableList()
    val chance = CHANCE_DECK.shuffled().toMutableList()
    var i = 0
    var curr_pos = 0
    while (i <= rolls) {
        var next_square = rollDice(curr_pos)
        println(next_square)
        curr_pos = next_square
        i++
    }
    return list
}

fun mostCommonElements(list: MutableList<Int>): MutableList<Int> {
    var list = list
    val most_common = mutableListOf<Int>()
    for (i in 1..3) {
        var max = 0
        var common = 0
        for (element in list.distinct()) {
            if (list.count { it == element } > max) {
                max = list.count { it == element }
                common = element
            }
        }
        most_common.add(common)
        val l = mutableListOf<Int>()
        for (element in list) {
            if (element != common) {
                l.add(element)
            }
        }
        list = l
    }
    return most_common
}