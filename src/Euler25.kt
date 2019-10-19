import java.math.BigInteger

fun main(args: Array<String>) {
    println(calculate25())
}
fun calculate25(): Any {
    val fibs = mutableListOf<BigInteger>(BigInteger.ONE, BigInteger.ONE)
    while (true) {
        if (fibs.last().toString().length >= 1000) {
            return fibs.size
        }
        else fibs.add(fibs.last().plus(fibs[fibs.size - 2]))
    }
}

private fun fib(i: Long): BigInteger {
    if (i < 3) return BigInteger.ONE
    return fib(i - 1) + fib(i - 2)
}