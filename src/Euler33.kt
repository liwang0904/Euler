import java.math.BigInteger

fun main(args: Array<String>) {
    println(calculate())
}
private fun calculate(): Any {
    val numerators = mutableListOf<Int>()
    val denominators = mutableListOf<Int>()
    (10..99).forEach { numerator ->
        (10..99).forEach { denominator ->
            if (isCancelling(numerator, denominator)) {
                System.out.println("$numerator / $denominator")
                numerators.add(numerator)
                denominators.add(denominator)
            }
        }
    }
    var numerProducts = BigInteger.ONE
    var denomProducts = BigInteger.ONE
    numerators.forEach { numerProducts = numerProducts.times(BigInteger.valueOf(it.toLong()))}
    denominators.forEach {denomProducts = denomProducts.times(BigInteger.valueOf(it.toLong()))}
    val gcm = getGCM(numerProducts.toInt(), denomProducts.toInt())
    return denomProducts.divide(BigInteger.valueOf(gcm.toLong()))
}

fun isCancelling(numerator: Int, denominator: Int): Boolean {
    if (numerator / denominator.toFloat() > 1f) return false
    var numerString = numerator.toString()
    var denomString = denominator.toString()
    numerString.forEachIndexed {i, c ->
        if (denomString.contains(c)) {
            numerString = numerString.replaceFirst(c.toString(), "")
            denomString = denomString.replaceFirst(c.toString(), "")
        }
    }
    return numerString != numerator.toString() && numerString.isNotBlank() && denomString.isNotBlank() && denomString.toInt() != 0
            && numerString.toInt() != 0 && numerator / denominator.toFloat() == numerString.toInt() / denomString.toFloat() && !numerator.toString().endsWith("0")
}

private fun getGCM(numerProducts: Int, denomProducts: Int): Int {
    return if (denomProducts == 0) numerProducts else getGCM(denomProducts, numerProducts.rem(denomProducts))
}