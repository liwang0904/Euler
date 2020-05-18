import java.math.BigInteger

fun main() {
    println(findPrimePatterns(1000000))
//    println(nextPrime(101))
}

fun isPrime(num: BigInteger): Boolean {
    var i = 2
    while (i <= Math.sqrt(num.toDouble())) {
        if (num % i.toBigInteger() == 0.toBigInteger()) {
            return false
        }
        ++i
    }
    return true
}

fun findPrimePatterns(max: Int): Long {
    var count = 0.toLong()
    var num = 0
    while (num <= max) {
        val square = (num * num).toBigInteger()
        println(square)
        println(num)
        if (isPrime(square + 1.toBigInteger())) {
            if (isPrime(square + 3.toBigInteger()) && nextPrime(square + 1.toBigInteger()) == square + 3.toBigInteger()) {
                if (isPrime(square + 7.toBigInteger()) && nextPrime(square + 3.toBigInteger()) == square + 7.toBigInteger()) {
                    if (isPrime(square + 9.toBigInteger()) && nextPrime(square + 7.toBigInteger()) == square + 9.toBigInteger()) {
                        println("HERERERER")
                        count += num
//                        if (isPrime(square + 13.toBigInteger()) && nextPrime(square + 9.toBigInteger()) == square + 13.toBigInteger()) {
//                            if (isPrime(square + 27.toBigInteger()) && nextPrime(square + 13.toBigInteger()) == square + 27.toBigInteger()) {
//
////                                println("HERERERER")
//                            }
//                        }
                    }
                }
            }
        }
        num += 10
    }
    return count
}

fun nextPrime(start: BigInteger): BigInteger {
    var next = start + 1.toBigInteger()
    while (!isPrime(next)) {
        next ++
    }
    return next
}