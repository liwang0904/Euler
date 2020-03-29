import java.io.File

val FACES = mutableListOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A')
val SUITS = mutableListOf('S', 'H', 'D', 'C')

val HANDS = mutableListOf(
    "High Card", // Highest value card.
    "One Pair", // Two cards of the same value.
    "Two Pairs", // Two different pairs
    "Three of a Kind", // Three cards of the same value.
    "Straight", // All cards are consecutive values.
    "Flush", // All cards of the same suit.
    "Full House", // Three of a kind and a pair.
    "Four of a Kind", // Four cards of the same value.
    "Straight Flush", // All cards are consecutive values of same suit.
    "Royal Flush" // Ten, Jack, Queen, King, Ace, in same suit.
)

fun main() {
    //println(getHands("src/poker.txt"))
    println(orderHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
    //println(determineHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
}

fun getHands(file: String): MutableList<MutableList<String>> {
    val hands = mutableListOf<MutableList<String>>()
    File(file).forEachLine {
        val line = it.split(" ").toMutableList()
        val player1 = mutableListOf(line[0], line[1], line[2], line[3], line[4])
        val player2 = mutableListOf(line[5], line[6], line[7], line[8], line[9])
        hands.add(player1)
        hands.add(player2)
    }
    return hands
}

fun orderHand(cards: MutableList<String>): MutableList<String> {
    var cards = cards
    val cardsIndexes = mutableListOf<Int>()
    val orderedCards = mutableListOf<String>()
    for (card in cards) {
        val array = card.toCharArray()
        val face = array[0]
        cardsIndexes.add(FACES.indexOf(face))
    }
    cardsIndexes.sort()

    var possibleCardIndexes = mutableListOf<Int>()
    for (card in cards) {
        val array = card.toCharArray()
        val face = array[0]
        possibleCardIndexes.add(FACES.indexOf(face))
    }

    println(cards.shuffle())

    return orderedCards
}

fun determineHand(cards: MutableList<String>): String {
    val orderedHand = orderHand(cards)
    //println(orderedHand)

    val highestCard = orderedHand.get(orderedHand.size - 1)
    var hand = "High Card: $highestCard"

    //println(highestCard)

    val faces = mutableListOf<Char>()
    val suits = mutableListOf<Char>()
    for (card in orderedHand) {
        val array = card.toCharArray()
        faces.add(array[0])
        suits.add(array[1])
    }
//    println(faces)
//    println(suits)

    for (face in faces) {
        val count = faces.count { it == face }
        //println("$count - ${face}")
        if (count == 2) {
            hand = "One Pair: $face"
        }
    }
    return hand
}