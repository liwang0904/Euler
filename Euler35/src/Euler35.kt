import java.util.ArrayList

fun main() {
    val list = primesList(1000000)
    var circResult = 0
    for (i in list.indices) {
        val circ = circular(list[i])
        if (containAllPrimes(circ, list))
            circResult++
    }

    println(circResult)
}

fun primesList(n: Int): List<Int> {
    val isP = BooleanArray(n + 1)
    val res = ArrayList<Int>()
    for (i in 2..n) {
        isP[i] = true
    }
    var factor = 2
    while (factor * factor <= n) {
        if (isP[factor]) {
            var j = factor
            while (factor * j <= n) {
                isP[factor * j] = false
                j++
            }
        }
        factor++
    }
    for (k in 2..n)
        if (isP[k])
            res.add(k)
    return res

}

fun circular(x: Int): IntArray {
    val rev = x.toString()
    val result = IntArray(rev.length)
    result[0] = x
    for (i in 1 until rev.length) {
        result[i] = Integer.parseInt(rev.substring(i) + rev.substring(0, i))
    }
    return result
}

fun containAllPrimes(a: IntArray, lista: List<Int>): Boolean {
    for (i in a.indices) {
        if (!lista.contains(a[i]))
            return false
    }
    return true
}