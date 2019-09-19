fun main(args: Array<String>) {
    println(calculate7())
}

fun calculate7(): Any {
    var prime = 1
    for (x in 1..10001) prime = getNextPrime(prime)
    return prime
}

private fun getNextPrime(prime: Int): Int {
    var current = prime + 1
    t@while (true) {
        for (x in 2..(current/2)) if (current % x == 0) {
            current++
            continue@t
        }
        return current
    }
}