fun main() {
    val result = 28433.toBigInteger() * 2.toBigInteger().modPow(7830457.toBigInteger(), 10000000000.toBigInteger()) + 1.toBigInteger()
    println(result % 10000000000.toBigInteger())
}