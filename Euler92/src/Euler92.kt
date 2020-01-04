fun main() {
    println(addSquareDigits(44))
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