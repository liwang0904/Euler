import java.io.File

fun main() {
    val list = fileToList("src/words.txt")
//    var maxLength = 0
//    for (word in list) {
//        if (word.length > maxLength) {
//            maxLength = word.length
//            println(word)
//        }
//    }
//    println(maxLength)
//    println(squaresList(8))
//    println(isAnagram("hello", "olhle"))
//    println(removeElement(4, mutableListOf(1, 4, 9, 16)))
//    println(anagramicSquares(squaresList(5)).size)
//    println(isAnagramicSquare("RACE", 18769))
//    println(anagramicWords(list).size)
//    println(getAnagramPairSquares(mutableListOf("CARE", "RACE"), anagramicSquares(squaresList(4))))
//    println(anagramicWords(list))
    println(getLargestAnagramicSquareNumber(anagramicWords(list), anagramicSquares(squaresList(7))))
}

fun fileToList(fileName: String): List<String> {
    var list = listOf<String>()
    File(fileName).forEachLine {
        list = it.split(",").map { it }
    }
    return list
}

fun squaresList(maxLength: Int): List<Long> {
    var i = 1
    val squares = mutableListOf<Long>()
    while ((i * i).toString().length <= maxLength) {
        squares.add((i * i).toLong())
//        println(i)
        i++
    }
    return squares
}

fun isAnagram(string1: String, string2: String): Boolean {
    if (string1.length == string2.length) {
        return (string1.toCharArray().sorted() == string2.toCharArray().sorted())
    }
    return false
}

fun removeElement(string: String, strings: MutableList<String>): MutableList<String> {
    val newElements = mutableListOf<String>()
    for (element in strings) {
        if (string != element) {
            newElements.add(element)
        }
    }
    return newElements
}

fun stringsToLongs(strings: MutableList<String>): MutableList<Long> {
    val longs = mutableListOf<Long>()
    for (element in strings) {
        longs.add(element.toLong())
    }
    return longs
}

fun longsToStrings(longs: MutableList<Long>): MutableList<String> {
    val strings = mutableListOf<String>()
    for (element in longs) {
        strings.add(element.toString())
    }
    return strings
}

fun anagramicSquares(squares: List<Long>): List<Long> {
    val anagramicSquares = squares.toMutableList()
    val anagrams = mutableListOf<Long>()
    for (square1 in squares) {
        val squaresNoSquare = stringsToLongs(removeElement(square1.toString(), longsToStrings(anagramicSquares)))
        for (square2 in squaresNoSquare) {
            if (square2.toString().length == square1.toString().length) {
                if (square1.toString().toCharArray().sorted() == square2.toString().toCharArray().sorted()) {
//                    println("ANAGRAMS!!!!!: $square1 and $square2")
                    anagrams.add(square1)
                    anagrams.add(square2)
                }
            }
        }
//        println(squaresNoSquare)
    }
    return anagrams.distinct()
}

fun anagramicWords(words: List<String>): List<String> {
    val anagrams = mutableListOf<String>()
    for (word1 in words) {
        val wordsNoWord = removeElement(word1, words.toMutableList())
        for (word2 in wordsNoWord) {
            if (word1.length == word2.length) {
                if (word1.toCharArray().sorted() == word2.toCharArray().sorted()) {
                    anagrams.add(word1)
                    anagrams.add(word2)
                }
            }
        }
    }
    return anagrams.distinct()
}

fun isAnagramicSquare(word: String, squareNumber: Long): Boolean {
    if (word.length == squareNumber.toString().length) {
        if (word.toCharArray().distinct().size == squareNumber.toString().toCharArray().distinct().size) {
            return true
        }
    }
    return false
}

fun charArrayToString(charArray: MutableList<Char>): String {
    var string = ""
    for (char in charArray) {
        string += char.toString()
    }
    return string
}

fun getAnagramPairSquares(anagramPair: MutableList<String>, anagramicSquares: List<Long>): MutableList<Long> {
    val word1 = anagramPair[0]
    val word2 = anagramPair[1]
    val squaresToCheck = mutableListOf<Long>()
    for (square in anagramicSquares) {
        if (square.toString().length == word1.length) {
            squaresToCheck.add(square)
        }
    }
    for (square in squaresToCheck) {
        if (isAnagramicSquare(word1, square)) {
            val word1Array = word1.toCharArray().toMutableList()
            val square1Array = square.toString().toCharArray().toMutableList()
            val word2Array = word2.toCharArray().toMutableList()
            val square2Array = mutableListOf<Char>()
            for (char in word2Array) {
                val index = word1Array.indexOf(char)
                square2Array.add(square1Array[index])
            }
//            println("SQUARE 1 = $square1Array ++++++ WORD1 = $word1Array")
//            println("SQUARE 2 = $square2Array ++++++ WORD2 = $word2Array")
            if (squaresToCheck.contains(charArrayToString(square2Array).toLong())) {
                return mutableListOf(square, charArrayToString(square2Array).toLong())
            }
        }
    }
    return mutableListOf()
}

fun getLargestAnagramicSquareNumber(anagramicWords: List<String>, anagramicSquares: List<Long>): Long {
    var largestAnagramicSquareNumber = 0L
    for (square in anagramicSquares) {
        for (word in anagramicWords) {
            if (anagramicWords.indexOf(word) % 2 == 0) {
                val anagramPair = mutableListOf(word, anagramicWords.get(anagramicWords.indexOf(word) + 1))
                if (anagramPair[0].length == anagramPair[1].length) {
//                    println(anagramPair)
                    val anagramPairSquares = getAnagramPairSquares(anagramPair, anagramicSquares)
                    if (anagramPairSquares.size == 2) {
                        val max = anagramPairSquares.max() ?: 0
                        if (max > largestAnagramicSquareNumber) {
                            largestAnagramicSquareNumber = max
//                            println(largestAnagramicSquareNumber)
                        }
                    }
                }
            }
        }
    }
    return largestAnagramicSquareNumber
}