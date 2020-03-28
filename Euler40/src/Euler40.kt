fun main() {
    val result = StringBuffer()
    result.append(".")
    for (i in 1..999999) {
        result.append(i)
    }
    val d1 = Integer.parseInt("" + result[1])
    val d10 = Integer.parseInt("" + result[10])
    val d100 = Integer.parseInt("" + result[100])
    val d1000 = Integer.parseInt("" + result[1000])
    val d10000 = Integer.parseInt("" + result[10000])
    val d100000 = Integer.parseInt("" + result[100000])
    val d1000000 = Integer.parseInt("" + result[1000000])

    val answer = d1 * d10 * d100 * d1000 * d10000 *
            d100000 * d1000000
    println(answer)
}