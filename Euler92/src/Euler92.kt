fun main() {
//    println(addSquareDigits(44))
    println(test(10000000, 1, 1, 0))
}

fun test(max: Int, startingNum: Int, currNum: Int, count: Int): Int {
    val newCount = count
    if (startingNum == max)
        return count
    if (currNum == 10) {
        newCount + 1
        println(startingNum)
    } else {
        return test(max, startingNum + 1, addSquareDigits(startingNum + 1), newCount)
    }
    return 0
}

fun addSquareDigits(num: Int): Int {
    var num = num
    var sum = 0
    while (num > 0) {
        sum += (num % 10) * (num % 10)
        num /= 10
    }
    return sum
}