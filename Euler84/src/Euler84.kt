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
    println(simulate(1000000))
}

fun rollDice(): MutableList<Int> {
    val dice1 = Random.nextInt(1, 5)
    val dice2 = Random.nextInt(1, 5)
    return mutableListOf(dice1, dice2)
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
    if (SQUARES.get(square) == "CH3") {
        if (card == "R") {
            return 5
        } else if (card == "U") {
            return 12
        }
    }
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
    var list = mutableListOf<Int>()
    var community_chest = COMMUNITY_CHEST_DECK.shuffled().toMutableList()
    //println("COMMUNITY CHEST: $community_chest")
    val chance = CHANCE_DECK.shuffled().toMutableList()
    //println("CHANCE: $chance")
    var i = 0
    var curr_pos = 0
    var doubles_count = 0
    while (i <= rolls) {
        val dice = rollDice()
        val dice1 = dice[0]
        val dice2 = dice[1]
        //println("DICE 1: $dice1")
        //println("DICE 2: $dice2")
        val next_square = curr_pos + dice1 + dice2
        curr_pos = next_square
        if (curr_pos >= 40) {
            curr_pos = curr_pos - 40
            //println("CURRENT POSITION: $curr_pos")
        }
        if (curr_pos == 30) {
            curr_pos = 10
        }
        if (dice1 == dice2) {
            doubles_count++
            //println("DOUBLES COUNT: $doubles_count")
            if (doubles_count == 3) {
                curr_pos = SQUARES.indexOf("JAIL")
                doubles_count = 0
            }
        } else if (SQUARES[curr_pos].toCharArray()[1] == 'C') { // community chest
            //println("COMMUNITY CHEST")
            curr_pos = moveCommunityChest(curr_pos, community_chest[0])
            community_chest.add(community_chest.size, community_chest[0])
            community_chest.removeAt(0)
            //println(community_chest)
        } else if (SQUARES[(curr_pos)].toCharArray()[1] == 'H') { // chance
            //println("CHANCE")
            curr_pos = moveChance(curr_pos, chance[0])
//            if (chance[0] == "E3") {
//                println("***********************E3***********************")
//            }
            chance.add(chance.size, chance[0])
            chance.removeAt(0)
            //println(chance)
        }
        list.add(curr_pos)
        println(curr_pos)
        i++
    }
    //println(list)
    println(list.count { it == 34 })
    println(list.count { it == 16 })
    return mostCommonElements(list)
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