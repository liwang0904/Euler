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

private class Card (val face: Char, val suit: Char): Comparable<Card> {
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

class Hand{
    //private sorted_cards()
    //private is_flush() 
    //private is_royal_flush()
    //calculate_worth()     
    //compareTo()
}

List<Card>  strs2cards(List<String> strs){
    //List<Card>  call sort() on the list   
}
    
fun main() {
    //println(getHands("src/poker.txt"))
    //println(orderHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
    //println(determineHand(mutableListOf("8C", "KS", "KC", "9H", "4S")))
    //val card1 = Card('3', 'C')
    //val card2 = Card('8', 'H')
    //println(card1 > card2) // -1

    println(orderHand(mutableListOf("7S", "TH", "4H", "QS", "TD")))
    
    
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
    println(cards)
    val orderedCards = mutableListOf<String>()
    var other = ""
    for (card in cards) {
        if (cards.indexOf(card) == 0) {
            orderedCards.add(0, card)
            continue
        } else if (cards.indexOf(card) == cards.size - 1) {
            other = cards[0]
        } else {
            other = cards[(cards.indexOf(card) - 1)]
        }
        println("comparing $card and $other")

        val array = card.toCharArray()
        val face = array[0]
        val suit = array[1]

        val otherArray = other.toCharArray()
        val otherFace = otherArray[0]
        val otherSuit = otherArray[1]

        val card1 = Card(face, suit)
        val card2 = Card(otherFace, otherSuit)

        val otherIndex = orderedCards.indexOf(other)

        if (card1 < card2) {
            println("$card < $other")
            
            //orderedCards.add(otherIndex, card)
            println(orderedCards)
        } else {
            println("$card >= $other")
            orderedCards.add(otherIndex + 1, card)
            println(orderedCards)
        }

        /*if (card1.compareTo(card2) == -1) { // card < other
            println("$card < $other")
            if (otherIndex == 0) {
                orderedCards.add(otherIndex, card)
            } else {
                var possibleOther = orderedCards[otherIndex - 1]
                var possibleOtherArray = possibleOther.toCharArray()
                var possibleFace = possibleOtherArray[0]
                var possibleSuit = possibleOtherArray[1]
                var possibleCard = Card(possibleFace, possibleSuit)
                println(orderedCards.indexOf(possibleOther))
                while (possibleCard >= card1 && orderedCards.indexOf(possibleOther) != 0) {
                    println("$possibleOther > $card")
                    possibleOther = orderedCards[orderedCards.indexOf(possibleOther) - 1]
                    println("card: $card and possible: $possibleOther")
                    possibleOtherArray = possibleOther.toCharArray()
                    possibleFace = possibleOtherArray[0]
                    possibleSuit = possibleOtherArray[1]
                    possibleCard = Card(possibleFace, possibleSuit)
                }
                orderedCards.add(orderedCards.indexOf(possibleOther), card)
            }
        } else { // card >= other
            println("$card >= $other")
            if (otherIndex == orderedCards.size - 1) {
                orderedCards.add(otherIndex + 1, card)
            } else {
                var possibleOther = orderedCards[otherIndex + 1]
                var possibleOtherArray = possibleOther.toCharArray()
                var possibleFace = possibleOtherArray[0]
                var possibleSuit = possibleOtherArray[1]
                var possibleCard = Card(possibleFace, possibleSuit)
                //println(orderedCards.indexOf(possibleOther) == orderedCards.size - 1)
                while (possibleCard <= card1 && orderedCards.indexOf(possibleOther) != orderedCards.size - 1) {
                    possibleOther = orderedCards[orderedCards.indexOf(possibleOther) + 1]
                    println("card: $card and possible: $possibleOther")
                    possibleOtherArray = possibleOther.toCharArray()
                    possibleFace = possibleOtherArray[0]
                    possibleSuit = possibleOtherArray[1]
                    possibleCard = Card(possibleFace, possibleSuit)
                }
                println("last: $possibleOther")
                orderedCards.add(orderedCards.indexOf(possibleOther), card)
            }
        }
        println(orderedCards)
    }*/
    }

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
