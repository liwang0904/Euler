fun main() {
    val MAX_SUM = 1000000
    var currentSum = 0
    var currentNumber = 6

    while (currentSum + currentNumber < MAX_SUM) {
        if (isPrime(currentNumber)) {
            currentSum += currentNumber
        }
        currentNumber++
    }
    println(currentSum)
}

fun isPrime(n: Int): Boolean {
    var i = 2
    while (i <= Math.sqrt(n.toDouble())) {
        if (n % i == 0 && n != i) {
            return false
        }
        i++
    }
    return true
}