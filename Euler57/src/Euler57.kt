fun main(args: Array<String>) {
    println(get_count(100))
}

fun reduce(fraction: MutableList<Long>): MutableList<Long> {
    var gcd = 1
    var numerator = fraction.get(0)
    var denominator = fraction.get(1)
    var i = 1
    while (i <= numerator && i <= denominator) {
        if (numerator % i == 0L && denominator % i == 0L) {
            gcd = i
        }
        ++i
    }
    return mutableListOf(numerator / gcd, denominator / gcd)
}

fun inverse_of(fraction: MutableList<Long>): MutableList<Long> {
    var numerator = fraction[0]
    var denominator = fraction[1]
    numerator = denominator.also { denominator = numerator }
    return mutableListOf(numerator, denominator)
}

fun get_convergent(expansionNum: Int): MutableList<Long> {
    var i = 1
    var fraction = mutableListOf(2L, 1L)
    if (expansionNum == 1) {
        fraction = inverse_of(fraction)
    } else {
        while (i < expansionNum) {
            fraction = inverse_of(fraction) // (1, 2)
            fraction = mutableListOf(fraction.get(0) + (2 * fraction.get(1)), fraction.get(1)) // (5, 2)
            //println(fraction)
            i++
        }
        //println(fraction)
        fraction = inverse_of(fraction) // (2, 5)
    }
    return reduce(mutableListOf(fraction.get(0) + fraction.get(1), fraction.get(1)))
}

fun get_count(max: Int): Int {
    var count = 0
    var i = 0
    while (i <= max) {
        var fraction = get_convergent(i)
        if (fraction.get(0).toString().length > fraction.get(1).toString().length) {
            count += 1
        }
        i++
    }
    return count
}