fun main(args: Array<String>) {
    println(calculate21())
}
fun calculate21(): Any {
    var sum = 0
    (1..10000).forEach { num ->
        if (divisorsSum(divisorsSum(num)) == num && divisorsSum(num) != num) {
            sum += num
        }
    }
    return sum
}

private fun divisorsSum(i: Int): Int {
    var sum = 0
    for (x in (1..(i - 1)) step 1) if (i % x == 0) sum += x
    return sum
}