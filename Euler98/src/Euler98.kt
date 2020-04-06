import java.io.File

fun main() {
//    val list = fileToList("src/words.txt")
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
    return (string1.toCharArray().sorted() == string2.toCharArray().sorted())
}