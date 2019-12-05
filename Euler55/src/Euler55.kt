import java.math.BigInteger

fun main(args: Array<String>) {
    var count = 0
    println(get_iteration_count(349.toBigInteger(), count))
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

//fun get_iteration_count(num: BigInteger, iterationCount: Int): Int {
//    //println(iterationCount)
//    if (is_palindrome(num)) {
//        //println("here! $iterationCount")
//        return iterationCount
//    } else {
//        println(iterationCount)
//        val reversed = reverse_num(num)
//        get_iteration_count(reversed + num, iterationCount + 1)
//    }
//    return iterationCount
//}

fun get_iteration_count(num: BigInteger, iterationCount: Int): Int {
    if (is_palindrome(num)) {
        return iterationCount
    }
    if (iterationCount == 50) {
        return -1
    }
    val reversed = reverse_num(num)
    return get_iteration_count(num + reversed, iterationCount + 1)
}