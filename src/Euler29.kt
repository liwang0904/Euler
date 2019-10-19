import java.math.BigInteger

fun main(args: Array<String>) {
    println(calculate29())
}

fun calculate29(): Any {
    return getPermutations(100, 100).size
}

private fun getPermutations(a: Int, b: Int): Set<BigInteger> {
    val permutations = mutableSetOf<BigInteger>()
    (2..a).forEach { base ->
        (2..b).forEach { power -> permutations.add(BigInteger.valueOf(base.toLong()).pow(power)) }
    }
    return permutations
}