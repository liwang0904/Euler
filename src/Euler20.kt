import java.math.BigInteger

fun main(args: Array<String>) {
    println(calculate20())
}
fun calculate20(): Any {
    return factorial(100).toString().map {  it.toString().toInt() }.sum()
}

private fun factorial(i: Int): BigInteger {
    var product = BigInteger.ONE
    for (x in i downTo 1) product = product.times(BigInteger.valueOf(x.toLong()))
    return product
}