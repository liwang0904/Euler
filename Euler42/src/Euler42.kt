import java.io.File

fun main() {
    val file = "src/words.txt"
    val list = fileToList(file)
    var max_length = 0
    for (word in list) {
        if (word.length > max_length) {
            max_length = word.length
        }
    }
    var count = 0
    val triangle_numbers = generateTriangleNumbers(max_length * 26)
    for (word in list) {
        if (triangle_numbers.contains(wordToNumber(word))) {
            count++
        }
    }
    println(count)
}

fun fileToList(file: String): List<String> {
    var words = listOf<String>()
    File(file).forEachLine { words = it.split(',') }
    return words
}

fun generateTriangleNumbers(max: Int): List<Int> {
    val triangle_numbers = mutableListOf<Int>()
    var n = 1
    while (0.5 * n * (n + 1) <= max) {
        val triangle_num = 0.5 * n * (n + 1)
        triangle_numbers.add(triangle_num.toInt())
        n++
    }
    return triangle_numbers
}

fun wordToNumber(word: String): Int {
    val list = word.toCharArray()
    var sum = 0
    for (char in list) {
        when (char) {
            'A' -> sum += 1
            'B' -> sum += 2
            'C' -> sum += 3
            'D' -> sum += 4
            'E' -> sum += 5
            'F' -> sum += 6
            'G' -> sum += 7
            'H' -> sum += 8
            'I' -> sum += 9
            'J' -> sum += 10
            'K' -> sum += 11
            'L' -> sum += 12
            'M' -> sum += 13
            'N' -> sum += 14
            'O' -> sum += 15
            'P' -> sum += 16
            'Q' -> sum += 17
            'R' -> sum += 18
            'S' -> sum += 19
            'T' -> sum += 20
            'U' -> sum += 21
            'V' -> sum += 22
            'W' -> sum += 23
            'X' -> sum += 24
            'Y' -> sum += 25
            'Z' -> sum += 26
        }
    }
    return sum
}