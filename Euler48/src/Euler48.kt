import java.math.BigInteger

fun main() {
    var bi = BigInteger("0")
    for (i in 1..1000)
        bi = bi.add(BigInteger("" + i).pow(i))
    println(bi)
}