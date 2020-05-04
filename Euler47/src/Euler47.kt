fun primeFactors(n: Int): Int {
    val factors = mutableListOf<Int>()
    var n = n
    while (n % 2 == 0) {
//        println(2.toString())
        factors.add(2)
        n /= 2
    }
    var i = 3
    while (i <= Math.sqrt(n.toDouble())) {
        while (n % i == 0) {
//            println("$i ")
            factors.add(i)
            n /= i
        }
        i += 2
    }

    if (n > 2) {
        factors.add(n)
//        println(n)
    }
//    println()
    return factors.distinct().size
}

fun main() {
    var n = 2 * 3 * 5 * 7
    while (true) {
        println(n)
        if (primeFactors(n) == 4) {
            if (primeFactors(n + 1) == 4 && primeFactors(n + 2) == 4 && primeFactors(n + 3) == 4) {
                println("hereerere")
                break
            }
        }
        n += 1
    }
//    println(primeFactors(134043))
//    println(primeFactors(134044))
//    println(primeFactors(134045))
//    println(primeFactors(134046))
}

