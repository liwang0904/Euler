fun main(args: Array<String>) {
    val max = 10000000
    val maxSqrt = Math.sqrt(max.toDouble()).toInt()
    val primes = computePrimes(max / 1009)
    val numPrimes = primes.size

    var minRatio = 100000.0
    var minRatioN = 0
    for (a in 1 until numPrimes)
        for (b in 0 until a) {
            val product = primes[a] * primes[b]
            if (product >= max)
                break

            val totient = (primes[a] - 1) * (primes[b] - 1)
            val ratio = product.toDouble() / totient.toDouble()
            if (ratio < minRatio) {
                if (isPermutation(product, totient)) {
                    minRatio = ratio
                    minRatioN = product
                }
            }
        }

    println(minRatioN)
}

fun computePrimes(num: Int): MutableList<Int> {
    var primes = mutableListOf<Int>()
    for (i in 2..num) {
        if(isPrime(i)) {
            primes.add(i)
        }
    }
    return primes
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

fun isPermutation(num1: Int, num2: Int): Boolean {
    if (num1.toString().length != num2.toString().length)
        return false
    var chars1 = num1.toString().toCharArray().sort()
    var chars2 = num2.toString().toCharArray().sort()
    if (chars1 != chars2) {
        return false
    }
    return true
}