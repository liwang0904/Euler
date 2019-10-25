import kotlin.math.floor

fun main(args: Array<String>) {
    var max = 100
    println(produce_pattern(max, Math.E))
}

fun produce_pattern(max: Int, num: Double): MutableList<Int> {
    var pattern = mutableListOf<Int>(floor(num).toInt(), 1, 2)
    var i = 1;
    var j = 2;
    while (i < max - 2) {
        println(i)
        if (i % 3 == 0 && i != 0) {
            println("here")
            pattern.add(j * 2)
            j++
        } else {
            pattern.add(1)
        }
        i++
    }
    return pattern
}

fun inverse_of(fraction: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    var numerator = fraction[0]
    var denominator = fraction[1]
    numerator = denominator.also { denominator = numerator }
    return mutableListOf(numerator, denominator)
}

fun add_num_and_inverse(nums: MutableList<Int>) {
    var fraction1 = mutableListOf(nums.get(0), 1)
    var fraction2 = mutableListOf(inverse_of(nums.get(1)))
}

fun solve(pattern: MutableList<Int>): MutableList<MutableList<Int>> {
    var lastIndex = pattern.size - 1
    while (lastIndex >= 0) {

        lastIndex--
    }
}