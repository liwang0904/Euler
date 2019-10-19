import java.math.BigInteger

fun main(args: Array<String>) {
    println(calculate16())
}
fun calculate16(): Any {
    var result = BigInteger.ONE
    for (i in 1..1000 step 1) result = result.times(BigInteger.valueOf(2))
    val string = result.toString()
    var sum = 0L
    string.forEach {
        sum += it.toString().toLong()
    }
    return sum
}