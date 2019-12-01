import java.math.BigInteger

fun main(args: Array<String>) {
    var base: BigInteger
    var power: BigInteger
    var digitSum: Int
    var maxDigitSum = 0
    for (b in 1..99) {
        base = BigInteger(b.toString())
        power = BigInteger("1")
        for (p in 1..99) {
            power = power.multiply(base)
            digitSum = get_digit_sum(power.toString())
            if (digitSum > maxDigitSum) {
                maxDigitSum = digitSum
                println("base = $base")
                println("power = $power")
            }
        }
    }
    println(maxDigitSum)
}
private fun get_digit_sum(number: String): Int {
    var total = 0
    for (loop in 0 until number.length)
        total += number[loop].toInt() - 48
    return total
}