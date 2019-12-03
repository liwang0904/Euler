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

fun get_iteration_count(num: BigInteger, iterationCount: Int): Int {
    var count = iterationCount
    //println(iterationCount)
    if (is_palindrome(num)) {
        //println("here! $iterationCount")
        return count
    } else {
        val reversed = reverse_num(num)
        get_iteration_count(reversed + num, iterationCount + 1)
    }
    println(count)
    return count
}

//fun get_iteration_count(num: BigInteger, iterationCount: Int): Int {
//    while(true) {
//        val reversed = reverse_num(num)
//        println(num)
//        if (is_palindrome(num)) {
//            //println("here!!!!!")
//            break
//        } else {
//            get_iteration_count(reversed + num, iterationCount + 1)
//        }
//    }
//    println("out!!!!!    $iterationCount")
//    return iterationCount
//}