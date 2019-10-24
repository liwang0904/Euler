import java.util.*
import kotlin.math.*

fun main(args : Array<String>) {
    //val num = 15
    //var continued_fractions = mutableListOf<Int>()
    //println(getApproximateSqrt(num))
    //multiplyByA2MinusB2(mutableListOf(mutableListOf()))
    //var numerator = mutableListOf(23, -3)
    //var denominator = mutableListOf(7)
    //var fraction = mutableListOf(numerator, denominator)
    //println(getApproximateQuotient(multiplyByA2MinusB2(inverseOf(fraction))))
    //println(determinePattern(mutableListOf(1, 1, 6, 2, 2)))
    //println(inverseOf(mutableListOf(numerator, denominator)))
    //println(continued_fractions)
    var num = 1
    var count = 0
    var max = 10000
    while (num <= max) {
        if (isPerfectSquare(num)) {
            count += 0
            num++
        } else {
            var pattern = mutableListOf<Int>()
            getPattern(num, mutableListOf(mutableListOf(num, getApproximateSqrt(num) * -1), mutableListOf(1)), pattern)
            println(pattern)
            if (pattern.size % 2 != 0) {
                count++
            }
            num++
        }
    }
    println(count)
}

fun isPerfectSquare(num: Int): Boolean {
    var sr = sqrt(num.toDouble())
    return ((sr - floor(sr)) == 0.0)
}

fun getPattern(num: Int, fraction: MutableList<MutableList<Int>>, pattern: MutableList<Int>) {
    if (pattern.size > 1 && fraction == mutableListOf(mutableListOf(num, getApproximateSqrt(num) * -1), mutableListOf(1))) {
        if (pattern.distinct().size == 1) {
            var i = 1
            while (i < pattern.size){
                pattern.removeAt(i)
                i++
            }
        }
        return
    }
    var quotient = getApproximateQuotient(multiplyByA2MinusB2(inverseOf(fraction)))
    pattern.add(quotient)
    var new_fraction = multiplyByA2MinusB2(inverseOf(fraction))
    //println(new_fraction)
    var numerator = new_fraction[0]
    var denominator = new_fraction[1]
    var b = numerator[1]
    var c = denominator[0]
    var new_numerator = mutableListOf(num, b - (c * quotient))
    getPattern(num, mutableListOf(new_numerator, denominator), pattern)
}

fun getApproximateSqrt(num: Int): Int {
    return floor(sqrt(num.toDouble())).toInt()
}

fun inverseOf(fraction: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    var numerator = fraction[0]
    var denominator = fraction[1]
    numerator = denominator.also{denominator = numerator}
    return mutableListOf(numerator, denominator)
}

fun multiplyByA2MinusB2(fraction: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    var numerator = fraction[0]
    var denominator = fraction[1]
    var a = denominator[0]
    var b = denominator[1]
    var new_denominator = mutableListOf((a - (b * b)) / numerator[0])
    numerator = mutableListOf(a, -b)
    return mutableListOf(numerator, new_denominator)
}

fun getApproximateQuotient(fraction: MutableList<MutableList<Int>>): Int {
    var numerator = fraction[0]
    var denominator = fraction[1]
    var a = numerator[0]
    var b = numerator[1]
    var c = denominator[0]
    return (getApproximateSqrt(a) + b) / c
}