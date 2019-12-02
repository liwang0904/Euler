import java.math.BigInteger

class Counter {
    count
}

fun main(args: Array<String>) {
    var count = 0
    get_iteration_count(349.toBigInteger(), Cou)
    println(count)
}

fun is_palindrome(num: BigInteger): Boolean {
    var reversed = 0.toBigInteger()
    var remainder: BigInteger
    var num1 = num
    while (num1 != 0.toBigInteger()) {
        remainder = num1 % 10.toBigInteger()
        reversed = reversed * 10.toBigInteger() + remainder
        num1 /= 10.toBigInteger()
    }
    return num == reversed
}

fun reverse_num(num: BigInteger): BigInteger {
    var reversed = 0.toBigInteger()
    var remainder: BigInteger
    var num1 = num
    while (num1 != 0.toBigInteger()) {
        remainder = num1 % 10.toBigInteger()
        reversed = reversed * 10.toBigInteger() + remainder
        num1 /= 10.toBigInteger()
    }
    return reversed
}

fun get_iteration_count(num: BigInteger, iterationCount: Int) {
    if (is_palindrome(num)) {
        println(iterationCount)
        return
    } else {
        var reversed = reverse_num(num)
        get_iteration_count(reversed + num, iterationCount + 1)
    }
}