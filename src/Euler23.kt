fun main(args: Array<String>) {
    println(calculate23())
}
fun calculate23(): Any {
    val numbers = Array(28123, { true })
    val abundant = (1..28123).filter { it.isAbundant() }
    abundant.forEach { first ->
        abundant.forEach { second -> if (first + second - 1 < 28123) numbers[first + second - 1] = false }
    }
    var sum = 0
    numbers.forEachIndexed { i, a -> if (a) sum += i + 1 }
    return sum
}

private fun Int.isAbundant(): Boolean = divisorsSum(this) > this

private fun divisorsSum(i: Int): Int {
    var sum = 0
    for (x in (1..(i - 1)) step 1) if (i % x == 0) sum += x
    return sum
}