import java.math.BigInteger

fun main() {
    var count = 0
    var n = 23.toBigInteger()
    while (n <= 100.toBigInteger()) {
        var r = 1.toBigInteger()
        while (r < n) {
            if (calculateCombinatoric(n, r) > 1000000.toBigInteger()) {
                count++
            }
            r++
        }
        n++
    }
    println(count)
}

fun calculateCombinatoric(n: BigInteger, r: BigInteger): BigInteger {
    //println(factorial(r) * factorial(n - r))
    return factorial(n) / (factorial(r) * factorial(n - r))
}

fun factorial(num: BigInteger): BigInteger {
    var factorial = 1.toBigInteger()
    var i = 1.toBigInteger()
    while(i <= num) {
        factorial *= i
        i++
    }
    return factorial
}
