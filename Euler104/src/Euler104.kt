import java.math.BigInteger
import kotlin.math.log10

fun main() {
/*    var fn2 = 1.toBigInteger()
//    var fn1 = 1.toBigInteger()
//    var fn : BigInteger
//
//    var found = false
//    var i = 2
//
//    while (i < 113) {
//        i++
////        println(i)
//        fn = fn1 + fn2
//        val tail = fn % 1000000000.toBigInteger()
//        println(tail)
//        if (tail.toString().toCharArray().sorted() == listOf(1,2,3,4,5,6,7,8,9)) {
//            println(i)
//            break
////            var digits = 1.0 + log10(fn.toDouble())
////            if (digits > 9) {
////                val head = fn.toDouble() / Math.pow(10.0, digits - 9.0)
////                if (head.toString().toCharArray().sorted() == listOf(1,2,3,4,5,6,7,8,9)) {
////                    found = true
////                }
////            }
//        }
//        fn2 = fn1
//        fn1 = fn
//    }
//    println(i) */
    val list = fibonacci().take(329469).toList()
    println(list)
}

fun fibonacci(): Sequence<BigInteger> {
    return generateSequence(Pair(0.toBigInteger(), 1.toBigInteger()), { Pair(it.second, it.first + it.second) }).map { it.first }
}