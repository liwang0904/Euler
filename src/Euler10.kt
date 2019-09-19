fun main() {
    println(calculate10())
}

fun calculate10(): Any {
    var sum = 2L
    var lastPrime = 1
    while (true) {
        val next = getNextPrime(lastPrime)
        if (next < 2000000) {
            lastPrime = next

            sum += next
        } else break
    }
    return sum
}

private fun getNextPrime(lastPrime: Int): Int {
    var current = lastPrime + 1
    while (true) {
        if (current % 2 == 0) {
            current++
            continue
        }
        for (x in IntProgression.fromClosedRange(3, current / 2, 2)) {
            if (current % x == 0) {
                current += 2
                continue
            }
        }
        return current
    }
}