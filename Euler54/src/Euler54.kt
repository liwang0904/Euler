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

class Card (val face: Char, val suit: Char): Comparable<Card> {
    override fun compareTo(other: Card): Int {
        val faceIndex = FACES.indexOf(face)
        val otherIndex = FACES.indexOf(other.face)
        if (faceIndex == otherIndex) {
            return 0
        } else if (faceIndex > otherIndex) {
            return 1
        }
        return -1
    }
}

class Hand(cards: List<Card>) {
    private val sortedCards = cards.sorted()

    private val faces = mutableListOf<Char>()
    private val suits = mutableListOf<Char>()

    private fun groupFacesAndSuits() {
        for (card in sortedCards) {
            faces.add(card.face)
            suits.add(card.suit)
        }
    }

    fun getHighCard(): Char { // if the same...compare second highest
        return sortedCards.last().face
    }

    fun getOnePair(): Char { // if the same...highest of remaining three
        var pairValue = ' '
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 2) {
                continue
            } else {
                pairValue = face
            }
        }
        return pairValue // make sure is not ' '
    }

    fun getTwoPairs(): List<Char> { // highest pair determines winner / if same two pairs...compare 5th card
        var pairsValue = mutableListOf<Char>()
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 2) {
                continue
            } else {
                pairsValue.add(face)
            }
        }
        return pairsValue.distinct().sortedDescending() // make sure size is two
    }

    fun getThreeOfAKind(): Char { // if the same...compare last two
        var tripletValue = ' '
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 3) {
                continue
            } else {
                tripletValue = face
            }
        }
        return tripletValue // make sure is not ' '
    }

    fun getStraight(): List<Char> { // no kickers
        groupFacesAndSuits()
        if (FACES.indexOf(faces.last()) - FACES.indexOf(faces.first()) == 4 && faces.distinct().size == 5) {
            return faces
        } else if (faces.last() == 'A' && faces.distinct().size == 5) {
            if (faces.first() == '2' && faces[faces.size - 2] == '5') {
                return faces
            }
        }
        return listOf()
    }

    fun getFlush(): Char { // if both have flush...compare highest cards
        groupFacesAndSuits()
        if (suits.distinct().size == 1) {
            return suits.distinct()[0]
        }
        return ' '
    }

    fun getFullHouse(): List<Char> { // if both have...compare three of a kind then pair
        val threeOfAKind = Hand(sortedCards).getThreeOfAKind()
        val pair = Hand(sortedCards).getOnePair()
        return listOf(threeOfAKind, pair)
    }

    fun getFourOfAKind(): Char { // if the same...compare last card
        var quadValue = ' '
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 4) {
                continue
            } else {
                quadValue = face
            }
        }
        return quadValue // make sure is not ' '
    }

    fun getStraightFlush(): List<Char> { // same as straight
        groupFacesAndSuits()
        if (suits.distinct().size == 1) {
            val straight = Hand(sortedCards).getStraight()
            if (straight.size == 5) {
                return straight
            }
        }
        return listOf()
    }

    fun isRoyalFlush(): Boolean {
        val straightFlush = Hand(sortedCards).getStraightFlush()
        if (straightFlush.isNotEmpty() && straightFlush[0] == 'T' && straightFlush[4] == 'A') {
            return true
        }
        return false
    }

    fun determineHighestHand(): String {
        val highestCard = Hand(sortedCards).getHighCard()
        if (Hand(sortedCards).isRoyalFlush()) {
            return "Royal Flush"
        } else if (Hand(sortedCards).getStraightFlush().isNotEmpty()) {
            return "Straight Flush-${Hand(sortedCards).getStraightFlush()}"
        } else if (Hand(sortedCards).getFourOfAKind() != ' ') {
            return "Four of a Kind-${Hand(sortedCards).getFourOfAKind()}"
        } else if (Hand(sortedCards).getFullHouse()[0].isLetterOrDigit() && Hand(sortedCards).getFullHouse()[1].isLetterOrDigit()) {
            return "Full House-${Hand(sortedCards).getFullHouse()}"
        } else if (Hand(sortedCards).getFlush() != ' ') {
            return "Flush-${Hand(sortedCards).getFlush()}"
        } else if (Hand(sortedCards).getStraight().isNotEmpty()) {
            return "Straight-${Hand(sortedCards).getStraight()}"
        } else if (Hand(sortedCards).getThreeOfAKind() != ' ') {
            return "Three of a Kind-${Hand(sortedCards).getThreeOfAKind()}"
        } else if (Hand(sortedCards).getTwoPairs().size == 2) {
            return "Two Pairs-${Hand(sortedCards).getTwoPairs()}"
        } else if (Hand(sortedCards).getOnePair() != ' ') {
            return "One Pair-${Hand(sortedCards).getOnePair()}"
        }
        return "High Card-$highestCard"
    }
}

fun stringToCard(strings: MutableList<String>): MutableList<Card> {
    var list = mutableListOf<Card>()
    for (string in strings) {
        val card = Card(string.toCharArray()[0], string.toCharArray()[1])
        list.add(card)
    }
    return list
}

fun main() {
    //println(getHands("src/poker.txt"))
    //println(orderHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
    //println(determineHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
    //val card1 = Card('3', 'C')
    //val card2 = Card('8', 'H')
    //println(card1 > card2) // -1

    //    val strings = mutableListOf<String>()
//    for (card in orderedCards) {
//        val cardString = card.face.plus("").plus(card.suit)
//        strings.add(cardString)
//    }
//    println(strings)

    val cards = stringToCard(mutableListOf("QH", "QC", "JS", "3D", "3C"))
    val highCard = Hand(cards).getHighCard()
    val onePair = Hand(cards).getOnePair()
    val twoPairs = Hand(cards).getTwoPairs()
    val threeOfAKind = Hand(cards).getThreeOfAKind()
    val straight = Hand(cards).getStraight()
    val flush = Hand(cards).getFlush()
    val fullHouse = Hand(cards).getFullHouse()
    val fourOfAKind = Hand(cards).getFourOfAKind()
    val straightFlush = Hand(cards).getStraightFlush()
    val isRoyalFlush = Hand(cards).isRoyalFlush()

    println(Hand(cards).determineHighestHand())
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
