import java.math.BigInteger

fun main(args: Array<String>) {
    println(calculate17())
}
fun calculate17(): Any {
    var sum = 0
    (1..1000).forEach {sum += intToString(it).length}
    return sum
}

private fun getName(i: Int): String {
    return when (i) {
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        11 -> "eleven"
        12 -> "twelve"
        13 -> "thirteen"
        14 -> "fourteen"
        15 -> "fifteen"
        16 -> "sixteen"
        17 -> "seventeen"
        18 -> "eighteen"
        19 -> "nineteen"
        else -> ""
    }
}

fun intToString(i: Int): String {
    val tens = arrayOf("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
    var temp = i
    val words = mutableListOf<String>()
    if (temp == 1000) return "onethousand"
    if (temp / 100 > 0) {
        words.add(getName(temp / 100))
        words.add("hundred")
        temp -= 100 * (temp / 100)
        if (temp != 0) words.add("and")
    }
    if (temp > 19) {
        val tensAmount = (temp / 10) * 10
        words.add(tens[(tensAmount / 10) - 2])
        temp -= tensAmount
    }
    words.add(getName(temp))
    return words.joinToString("")
}
