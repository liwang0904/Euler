class Fraction(val numerator: Int, val denominator: Int): Comparable<Fraction> {
    private fun gcd(numerator: Int, denominator: Int): Int {
        if (denominator == 0)
            return numerator
        return gcd(denominator, numerator % denominator)
    }

    fun reduce(): Fraction {
        val gcd = gcd(numerator, denominator)
        return Fraction(numerator / gcd, denominator / gcd)
    }

    override fun compareTo(other: Fraction): Int {
        val reducedFraction = reduce()
        val reducedOtherFraction = other.reduce()
        val a = reducedFraction.numerator
        val b = reducedFraction.denominator
        val c = reducedOtherFraction.numerator
        val d = reducedOtherFraction.denominator
        if (a * d - b * c > 0) {
            return 1
        } else if (a * d - b * c < 0) {
            return -1
        }
        return 0
    }
}

fun main() {
//    val fraction = Fraction(16, 10)
//    val other = Fraction(8, 5)
//    println("numerator: ${fraction.numerator}")
//    println("denominator: ${fraction.denominator}")
//    println(fraction.compareTo(other))
    val fractions = mutableListOf<MutableList<Int>>()
    for (fraction in allFractions(1000000).distinct()) {
        fractions.add(mutableListOf(fraction.numerator, fraction.denominator))
    }
    println(fractions.distinct().size)
}

fun allFractions(max_denominator: Int): List<Fraction> {
    val allFractions = mutableListOf<Fraction>()
    for (denominator in 2..max_denominator) {
        println(denominator)
        for (numerator in 1..denominator - 1) {
            allFractions.add(Fraction(numerator, denominator).reduce())
//            println("n = $numerator")
//            println("d = $denominator")
        }
    }
    return allFractions.sorted()
}

fun get_primes(limit: Int): MutableList<Int> {
    var primes = mutableListOf(2)
    var i = 3
    while (i <= limit) {
        if (is_prime(i)) {
            primes.add(i)
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