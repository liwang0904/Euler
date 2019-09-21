fun main(args: Array<String>) {
    // Set the target to 500 divisors.
    val target = 500

    // Create a sequence that steps 1 at the time.
    val triangleNumber = generateSequence(1, { it + 1 }).map { getTriangleNumber(it) }.first { getDivisors(it).size > target }
    println(triangleNumber)
}

fun getTriangleNumber(n: Int): Int {
    return (n*(n+1)/2.0).toInt()
}

fun getDivisors(n: Int): List<Int> {
    val limit = kotlin.math.sqrt(n.toDouble()).toInt()
    return (1..limit).filter { n % it == 0 }.flatMap {
        val squaredIsN = it * it == n
        if (squaredIsN) listOf(it) else listOf(it, n / it)
    }
}