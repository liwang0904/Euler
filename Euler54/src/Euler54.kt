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

    fun getHighCard(): Card { // if the same...compare second highest
        return sortedCards.last()
    }

    fun getOnePair(): List<Card> { // if the same...highest of remaining three
        val pair = mutableListOf<Card>()
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 2) {
                continue
            } else {
                for (card in sortedCards) {
                    if (card.face == face) {
                        pair.add(card)
                    }
                }
            }
        }
        return pair.distinct() // make sure is not ' '
    }

    fun getTwoPairs(): List<List<Card>> { // highest pair determines winner / if same two pairs...compare 5th card
        val pairs = mutableListOf<MutableList<Card>>()
        val cards = mutableListOf<Card>()
        groupFacesAndSuits()

        for (card in sortedCards) {
            if (faces.count { it == card.face } != 2) {
                continue
            } else {
                cards.add(card)
            }
        }
        cards.sorted()
        if (cards.size == 4) {
            val pair1 = mutableListOf(cards[0], cards[1])
            val pair2 = mutableListOf(cards[2], cards[3])
            pairs.add(pair1)
            pairs.add(pair2)
        }
        return pairs.reversed() // make sure size is two
    }

    fun getThreeOfAKind(): List<Card> { // if the same...compare last two
        val triplet = mutableListOf<Card>()
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 3) {
                continue
            } else {
                for (card in sortedCards) {
                    if (card.face == face) {
                        triplet.add(card)
                    }
                }
            }
        }
        return triplet.distinct() // make sure is not ' '
    }

    fun getStraight(): List<Card> { // no kickers
        groupFacesAndSuits()
        if (FACES.indexOf(faces.last()) - FACES.indexOf(faces.first()) == 4 && faces.distinct().size == 5) {
            return sortedCards
        } else if (faces.last() == 'A' && faces.distinct().size == 5) {
            if (faces.first() == '2' && faces[faces.size - 2] == '5') {
                val cards = mutableListOf(sortedCards[0], sortedCards[1], sortedCards[2], sortedCards[3])
                cards.add(0, sortedCards.last())
                return cards
            }
        }
        return listOf()
    }

    fun getFlush(): List<Card> { // if both have flush...compare highest cards
        groupFacesAndSuits()
        if (suits.distinct().size == 1) {
            return sortedCards
        }
        return listOf()
    }

    fun getFullHouse(): List<List<Card>> { // if both have...compare three of a kind then pair
        val threeOfAKind = Hand(sortedCards).getThreeOfAKind()
        val pair = Hand(sortedCards).getOnePair()
        return listOf(threeOfAKind, pair)
    }

    fun getFourOfAKind(): List<Card> { // if the same...compare last card
        val quad = mutableListOf<Card>()
        groupFacesAndSuits()
        for (face in faces) {
            if (faces.count { it == face } != 4) {
                continue
            } else {
                for (card in sortedCards) {
                    if (card.face == face) {
                        quad.add(card)
                    }
                }
            }
        }
        return quad.distinct() // make sure is not ' '
    }

    fun getStraightFlush(): List<Card> { // same as straight
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
        if (straightFlush.isNotEmpty() && straightFlush[0].face == 'T' && straightFlush[4].face == 'A') {
            return true
        }
        return false
    }

    fun determineHighestHand(): String {
        if (Hand(sortedCards).isRoyalFlush()) {
            return "Royal Flush"
        } else if (Hand(sortedCards).getStraightFlush().isNotEmpty()) {
            return "Straight Flush"
        } else if (Hand(sortedCards).getFourOfAKind().isNotEmpty()) {
            return "Four of a Kind"
        } else if (Hand(sortedCards).getFullHouse()[0].size == 3 && Hand(sortedCards).getFullHouse()[1].size == 2) {
            return "Full House"
        } else if (Hand(sortedCards).getFlush().isNotEmpty()) {
            return "Flush"
        } else if (Hand(sortedCards).getStraight().isNotEmpty()) {
            return "Straight"
        } else if (Hand(sortedCards).getThreeOfAKind().size == 3) {
            return "Three of a Kind"
        } else if (Hand(sortedCards).getTwoPairs().size == 2) {
            return "Two Pairs"
        } else if (Hand(sortedCards).getOnePair().size == 2) {
            return "One Pair"
        }
        return "High Card"
    }
}

fun stringsToCards(strings: MutableList<String>): MutableList<Card> {
    val list = mutableListOf<Card>()
    for (string in strings) {
        val card = Card(string.toCharArray()[0], string.toCharArray()[1])
        list.add(card)
    }
    return list
}

fun stringToCard(string: String): Card {
    return Card(string.toCharArray()[0], string.toCharArray()[1])
}

fun cardsToStrings(cards: List<Card>): MutableList<String> {
    val strings = mutableListOf<String>()
    for (card in cards) {
        val string = card.face.plus("").plus(card.suit)
        strings.add(string)
    }
    return strings
}

fun main() {
    //println(orderHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
    //println(determineHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
//    val card1 = Card('3', 'C')
//    val card2 = Card('8', 'H')
//    println(card1 > card2) // -1

    //    val strings = mutableListOf<String>()
//    for (card in orderedCards) {
//        val cardString = card.face.plus("").plus(card.suit)
//        strings.add(cardString)
//    }
//    println(strings)

    val cards = stringsToCards(mutableListOf("AS", "KS", "QS", "JS", "TS"))
    //println(cardsToStrings(cards))
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

//    println(cardsToStrings(twoPairs[0]))
//    println(cardsToStrings(twoPairs[1]))
    //println(Hand(cards).determineHighestHand())
    //println((cardsToStrings(threeOfAKind)))

    //println(highCardCheck(mutableListOf(stringsToCards(mutableListOf("3C", "AD", "QS")), stringsToCards(mutableListOf("AS", "KC", "3D")))))

    //println(determineWinner(mutableListOf(stringsToCards(mutableListOf("5H", "7D", "9C", "9H", "KS")), stringsToCards(mutableListOf("3S", "5C", "5D", "8D", "AH")))))
    //println(highCardCheck(mutableListOf(stringsToCards(mutableListOf("AC")), stringsToCards(mutableListOf("KC")))))

    val allRounds = getHands("src/poker.txt")
    var player1Score = 0
    var player2Score = 0
    for (round in allRounds) {
        val winner = determineWinner(round)
        //println(winner)
        if (winner == 1) {
            player1Score++
        } else if (winner == 2) {
            player2Score++
        }
    }
    println(player1Score)
    println(player2Score)
}

fun getHands(file: String): MutableList<MutableList<MutableList<Card>>> {
    val hands = mutableListOf<MutableList<MutableList<Card>>>()
    File(file).forEachLine {
        val line = it.split(" ").toMutableList()
        val player1 = stringsToCards(mutableListOf(line[0], line[1], line[2], line[3], line[4]))
        val player2 = stringsToCards(mutableListOf(line[5], line[6], line[7], line[8], line[9]))
        hands.add(mutableListOf(player1, player2))
    }
    return hands
}

fun highCardCheck(round: MutableList<MutableList<Card>>): Int {
    if (round[0].size == 0 || round[1].size == 0) {
        //println(round[0].size)
        return 0
    }
    val highCard1 = Hand(round[0]).getHighCard()
    val highCard2 = Hand(round[1]).getHighCard()
    if (highCard1 > highCard2) {
        return 1
    } else if (highCard1 < highCard2) {
        return 2
    }
    val newHand1 = mutableListOf<Card>()
    for (card in round[0]) {
        if (card == highCard1) {
            continue
        }
        newHand1.add(card)
    }
    val newHand2 = mutableListOf<Card>()
    for (card in round[1]) {
        if (card == highCard2) {
            continue
        }
        newHand2.add(card)
    }
    return highCardCheck(mutableListOf(newHand1, newHand2))
}

fun onePairCheck(round: MutableList<MutableList<Card>>): Int {
    val pair1 = Hand(round[0]).getOnePair()
    val pair2 = Hand(round[1]).getOnePair()
    println(cardsToStrings(pair1))
    println(cardsToStrings(pair2))
    if (pair1[0] > pair2[0]) {
        return 1
    } else if (pair1[0] < pair2[0]) {
        return 2
    }
    val newHand1 = mutableListOf<Card>()
    for (card in round[0]) {
        if (pair1.contains(card)) {
            continue
        }
        newHand1.add(card)
    }
    val newHand2 = mutableListOf<Card>()
    for (card in round[1]) {
        if (pair2.contains(card)) {
            continue
        }
        newHand2.add(card)
    }
    return highCardCheck(mutableListOf(newHand1, newHand2))
}

fun twoPairsCheck(round: MutableList<MutableList<Card>>): Int {
    val pairs1 = Hand(round[0]).getTwoPairs()
    val pairs2 = Hand(round[1]).getTwoPairs()
    var i = 0
    while (i <= 1) {
        val pair1 = pairs1[i]
        val pair2 = pairs2[i]
        if (pair1[0] > pair2[0]) {
            return 1
        } else if (pair1[0] < pair2[0]) {
            return 2
        }
        i++
        continue
    }
    var kicker1 = pairs1[0][0]
    for (card in round[0]) {
        for (pair in pairs1) {
            if (card.face == pair[0].face) {
                continue
            }
            kicker1 = card
            break
        }
    }
    var kicker2 = pairs2[0][0]
    for (card in round[1]) {
        for (pair in pairs2) {
            if (card.face == pair[0].face) {
                continue
            }
            kicker2 = card
            break
        }
    }
    println(cardsToStrings(mutableListOf(kicker1)))
    println(cardsToStrings(mutableListOf(kicker2)))
    return highCardCheck(mutableListOf(mutableListOf(kicker1), mutableListOf(kicker2)))
}

fun threeOfAKindCheck(round: MutableList<MutableList<Card>>): Int {
    val threeOfAKind1 = Hand(round[0]).getThreeOfAKind()
    val threeOfAKind2 = Hand(round[1]).getThreeOfAKind()
    if (threeOfAKind1[0] > threeOfAKind2[0]) {
        return 1
    } else if (threeOfAKind1[0] < threeOfAKind2[0]) {
        return 2
    }
    val kickers1 = mutableListOf<Card>()
    for (card in round[0]) {
        if (card.face != threeOfAKind1[0].face) {
            kickers1.add(card)
        }
    }
    val kickers2 = mutableListOf<Card>()
    for (card in round[1]) {
        if (card.face != threeOfAKind1[1].face) {
            kickers2.add(card)
        }
    }
    println(kickers1)
    println(kickers2)
    return highCardCheck(mutableListOf(kickers1, kickers2))
}

fun straightCheck(round: MutableList<MutableList<Card>>): Int {
    val straight1 = Hand(round[0]).getStraight()
    val straight2 = Hand(round[1]).getStraight()
    println(cardsToStrings(straight1))
    println(cardsToStrings(straight2))
    if (straight1[0].face == 'A') {
        return 2
    } else if (straight1[1].face == 'A') {
        return 1
    } else if (straight1[0] > straight2[0]) {
        return 1
    } else if (straight1[0] < straight2[0]) {
        return 2
    }
    return 0
}

fun flushCheck(round: MutableList<MutableList<Card>>): Int {
    return highCardCheck(round)
}

fun fullHouseCheck(round: MutableList<MutableList<Card>>): Int {
    val fullHouse1 = Hand(round[0]).getFullHouse()
    val threeOfAKind1 = fullHouse1[0]
    val pair1 = fullHouse1[1]
    val fullHouse2 = Hand(round[1]).getFullHouse()
    val threeOfAKind2 = fullHouse2[0]
    val pair2 = fullHouse2[1]
    if (threeOfAKind1[0] > threeOfAKind2[0]) {
        return 1
    } else if (threeOfAKind1[0] < threeOfAKind2[0]) {
        return 2
    } else if (pair1[0] > pair2[0]) {
        return 1
    } else if (pair1[0] > pair2[0]) {
        return 2
    }
    return 0
}

fun fourOfAKindCheck(round: MutableList<MutableList<Card>>): Int {
    val fourOfAKind1 = Hand(round[0]).getFourOfAKind()
    val fourOfAKind2 = Hand(round[1]).getFourOfAKind()
    if (fourOfAKind1[0] > fourOfAKind2[0]) {
        return 1
    } else if (fourOfAKind1[0] < fourOfAKind2[0]) {
        return 2
    }
    val kicker1 = mutableListOf<Card>()
    for (card in round[0]) {
        if (card.face != fourOfAKind1[0].face) {
            kicker1.add(card)
            break
        }
    }
    val kicker2 = mutableListOf<Card>()
    for (card in round[1]) {
        if (card.face != fourOfAKind2[0].face) {
            kicker2.add(card)
            break
        }
    }
    return highCardCheck(mutableListOf(kicker1, kicker2))
}

fun straightFlushCheck(round: MutableList<MutableList<Card>>): Int {
    val straightFlush1 = Hand(round[0]).getStraightFlush()
    val straightFlush2 = Hand(round[1]).getStraightFlush()
    if (straightFlush1[0] > straightFlush2[0]) {
        return 1
    } else if (straightFlush1[0] < straightFlush2[0]) {
        return 2
    }
    return 0
}

fun determineWinner(round: MutableList<MutableList<Card>>): Int {
    println("Player 1: ${cardsToStrings(round[0]).sorted()}")
    println("Player 2: ${cardsToStrings(round[1]).sorted()}")
    val hand1 = Hand(round[0]).determineHighestHand()
    val hand2 = Hand(round[1]).determineHighestHand()
    println(hand1)
    println(hand2)
    if (hand1 == hand2) {
        if (hand1 == "Royal Flush") {
            return 0
        } else if (hand1 == "Straight Flush") {
            return straightFlushCheck(round)
        } else if (hand1 == "Four of a Kind") {
            return fourOfAKindCheck(round)
        } else if (hand1 == "Full House") {
            return fullHouseCheck(round)
        } else if (hand1 == "Flush") {
            return flushCheck(round)
        } else if (hand1 == "Straight") {
            return straightCheck(round)
        } else if (hand1 == "Three of a Kind") {
            return threeOfAKindCheck(round)
        } else if (hand1 == "Two Pairs") {
            return twoPairsCheck(round)
        } else if (hand1 == "One Pair") {
            return onePairCheck(round)
        } else if (hand1 == "High Card") {
            return highCardCheck(round)
        }
    }
    if (HANDS.indexOf(hand1) > HANDS.indexOf(hand2)) {
        return 1
    } else if (HANDS.indexOf(hand1) < HANDS.indexOf(hand2)) {
        return 2
    }
    return 0
}