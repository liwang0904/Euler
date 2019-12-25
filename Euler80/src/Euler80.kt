import java.math.BigInteger

fun main(args: Array<String>) {
//    var sum = 0
//    var i = 2
//    while (i < 100) {
//        var sqrt = Math.sqrt(i.toDouble())
//        if (sqrt / sqrt.toInt() == 1.toDouble()) continue
//        var afterDecimalString = ""
//        var charIndex = 0
//        while (charIndex < sqrt.toString().length) {
//            if (sqrt.toString().get(charIndex) == '.')
//                afterDecimalString = sqrt.toString().substring(charIndex + 1, charIndex + 101)
//        charIndex++
//        }
//        var afterDecimalInt = afterDecimalString.toBigInteger()
//
//        i++
//    }
//    println()
    var total = 0
    for (j in 2..100) {
        var sqrt = Math.sqrt(j.toDouble())
        if (sqrt / sqrt.toInt() == 1.toDouble()) continue
        var tmp = j.toString()
        for (i in 0..100) tmp += "00"
        var n = BigInteger(tmp, 10)
        var s = Math.sqrt(n.toDouble()).toString()
        s = s.replace(".", "")
        println(s)
        var sum = 0
        for (i in 0..100) {
            sum += s.substring(0, 1).toInt()
            s = s.substring(1)
        }
        println("num: $j          sum of digits: $sum")
        total += sum
    }
    println(total)
}

fun sum_digits(num: BigInteger) {

}