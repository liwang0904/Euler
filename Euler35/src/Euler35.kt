fun main(args: Array<String>) {
    println(calculate())
}
private fun calculate(): Any {
    return 999999.circularPrimesUnder()
}

private fun Int.circularPrimesUnder(): Int {
    var count = 0
    var circularPrimes = mutableListOf<Int>()
}

fun isPrime(num: Int): Boolean {
    var i = 2
    while (i <= num / 2) {
        if (num % i == 0) {
            return false
        }
        ++i
    }
    return true
}

class Permutations {
    fun swap(ch: List<Char>, i: Int, j: Int) {
        var temp = ch.elementAt(i)
        ch.elementAt(i) = (ch.elementAt(j)).also { ch.elementAt(j) = temp }
    }
}