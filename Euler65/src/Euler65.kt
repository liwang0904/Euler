import java.math.BigInteger
import kotlin.math.floor

fun main(args: Array<String>) {
    var max = 100
    //println(add_num_and_inverse(mutableListOf(mutableListOf(3, 2), mutableListOf(7, 5))))
    var pattern = produce_pattern(max, Math.E)
    //println(pattern)
    println(sum_digits(get_sum(pattern.asReversed(), mutableListOf(0.toBigInteger(), 0.toBigInteger())).get(0).toString()))
    //println(add_three_levels(mutableListOf(1, 1), mutableListOf(2, 1), mutableListOf(2, 1)))
    //println(get_sums(pattern))
    //println(add_num_and_inverse(mutableListOf(2, 1), mutableListOf(3, 1)))
    //println(solve(pattern))
}

fun sum_digits(num: String): Int {
    val arr = num.toList()
    val arrOfInt = arr.map{ it.toString().toInt() }
    return arrOfInt.sum()
}

fun produce_pattern(max: Int, num: Double): MutableList<MutableList<BigInteger>> {
    var pattern = mutableListOf((mutableListOf(floor(num).toInt().toBigInteger(), 1.toBigInteger())), mutableListOf(1.toBigInteger(), 1.toBigInteger()), mutableListOf(2.toBigInteger(), 1.toBigInteger()))
    var i = 1;
    var j = 2;
    while (i < max - 2) {
        //println(i)
        if (i % 3 == 0 && i != 0) {
            //println("here")
            pattern.add(mutableListOf(2.toBigInteger().multiply(j.toBigInteger()), 1.toBigInteger()))
            j++
        } else {
            pattern.add(mutableListOf(1.toBigInteger(), 1.toBigInteger()))
        }
        i++
    }
    return pattern
}

fun inverse_of(fraction: MutableList<BigInteger>): MutableList<BigInteger> {
    var numerator = fraction[0]
    var denominator = fraction[1]
    numerator = denominator.also { denominator = numerator }
    return mutableListOf(numerator, denominator)
}

fun add_fractions(fraction1: MutableList<BigInteger>, fraction2: MutableList<BigInteger>): MutableList<BigInteger> {
    var numerator1 = fraction1.get(0)
    var inverse = inverse_of(fraction2)
    var numerator2 = inverse.get(0)
    var denominator2 = inverse.get(1)
    var sumNumerator = (numerator1 * denominator2) + numerator2
    var sumDenominator = denominator2
    return mutableListOf(sumNumerator, sumDenominator)
}

fun get_sum(reversedPattern: MutableList<MutableList<BigInteger>>, sum: MutableList<BigInteger>): MutableList<BigInteger> {
    //println(reversedPattern)
    if (reversedPattern.size == 1) {
        return reversedPattern.get(0)
    }
    //if (reversedPattern.size() == )
    //var sum1 = sum
    while (reversedPattern.size > 2) {
        var fraction2 = reversedPattern.get(0)
        var fraction1 = reversedPattern.get(1)
        var partSum = add_fractions(fraction1, fraction2)
        //println("added $fraction2 and $fraction1 and got $partSum")
        reversedPattern.removeAt(0)
        reversedPattern.removeAt(0)
        reversedPattern.add(0, partSum)
        get_sum(reversedPattern, add_fractions(sum, partSum))
    }
    return add_fractions(reversedPattern.get(1), reversedPattern.get(0))
}