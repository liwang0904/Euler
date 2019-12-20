import java.math.BigInteger

fun main(args: Array<String>) {
    var list = calculateCubes(10000.toBigInteger())
    var target = 3
    for (num in list) {
        var count = countRepetitions(list, num)
        if (count == target) {
            println(num)
        }
    }
}

fun calculateCubes(max: BigInteger): MutableList<BigInteger> {
    var list = mutableListOf<BigInteger>()
    var num = 1.toBigInteger()
    while (num < max) {
        val cube = sortDigits(num * num * num)
        list.add(cube)
        list.sort()
        num++
    }
    return list
}

fun sortDigits(num: BigInteger): BigInteger {
    var sorted = 0.toBigInteger()
    var digits = 10.toBigInteger()
    var sortedDigits = 1
    var first = true
    var num = num

    while (num > 0.toBigInteger()) {
        val digit = num % 10.toBigInteger()

        if (!first) {

            var tmp = sorted
            var toDivide = 1
            for (i in 0 until sortedDigits) {
                val tmpDigit = tmp % 10.toBigInteger()
                if (digit >= tmpDigit) {
                    sorted = sorted / toDivide.toBigInteger() * toDivide.toBigInteger() * 10.toBigInteger() + digit * toDivide.toBigInteger() + sorted % toDivide.toBigInteger()
                    break
                } else if (i == sortedDigits.minus(1)) {
                    sorted = digit * digits + sorted
                }
                tmp /= 10.toBigInteger()
                toDivide *= 10
            }
            digits *= 10.toBigInteger()
            sortedDigits += 1
        } else {
            sorted = digit
        }

        first = false
        num = num / 10.toBigInteger()
    }
    return sorted
}

fun countRepetitions(list: MutableList<BigInteger>, num: BigInteger): Int {
    return list.count { it == num }
}