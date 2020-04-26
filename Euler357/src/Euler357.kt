fun main() {
//    println(getDivisors(30))
//    println(meetRequirement(32))
    println(getPossibleNumbers(100000000))
}

fun getDivisors(n: Int): List<Int> {
    val divisors = mutableListOf<Int>()
    var i = 1
    while (i <= Math.sqrt(n.toDouble())) {
        if (n % i == 0) {
            if (n / i == i)
                divisors.add(i)
            else {
                divisors.add(i)
                divisors.add(n / i)
            }
        }
        i++
    }
    return divisors.sorted()
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

fun meetRequirement(num: Int): Boolean {
    if (num % 2 == 0 && isPrime(num + 1) && isPrime((num / 2) + 2)) {
        return true
    }
    return false
}

fun getPossibleNumbers(max: Int): MutableList<Int> {
    val nums = mutableListOf<Int>()
    var i = 2
    while (i <= max) {
        println(i)
        if (meetRequirement(i)) {
            nums.add(i)
        }
        i += 2
    }
    return nums
}