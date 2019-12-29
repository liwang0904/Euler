import java.math.BigInteger

fun main(args: Array<String>) {
    //println(get_primes(83))
    var count = 0

    var primes = get_primes(7000)
    //println(primes)

    var squares = mutableListOf<BigInteger>()
    var cubes = mutableListOf<BigInteger>()
    var fourths = mutableListOf<BigInteger>()

    for (prime in primes) {
        squares.add(prime * prime)
        cubes.add(prime * prime * prime)
        fourths.add(prime * prime * prime * prime)
    }

    for (square in squares) {
        for (cube in cubes) {
            for (fourth in fourths) {
                //println("square: $square     cube: $cube     fourth: $fourth")
                if (square + cube + fourth <= 50000000.toBigInteger()) {
                    count++
                }
            }
        }
    }
    println(count)
}

fun get_primes(limit: Int): MutableList<BigInteger> {
    var primes = mutableListOf(2.toBigInteger())
    var i = 3
    while (i <= limit) {
        if (is_prime(i)) {
            primes.add(i.toBigInteger())
        }
        i += 2
    }
    return primes
}

fun is_prime(num: Int): Boolean {
    for (i in 2..num / 2) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}