import java.math.BigInteger

//import java.math.BigInteger
//
//fun main() {
//    var numberUnderscore = mutableListOf<String>()
//
//    for(char in "1_2_3_4_5_6_7_8_9_0".toCharArray().toMutableList()) {
//        numberUnderscore.add(char.toString())
//    }
//    val fillIn = 0
//    while (fillIn <= 9) {
//        val number = replaceUnderscores(numberUnderscore, fillIn)
//
//    }
//    println(replaceUnderscores(numberUnderscore, 9))
//}
//
//fun replaceUnderscores(number: MutableList<String>, fillIn: Int): BigInteger {
//    val newNumber = number
//    var i = 0
//    println(fillIn.toString())
//    while (i < number.size) {
//        if (number.get(i) == "_") {
//            newNumber.add(i, fillIn.toString())
//            newNumber.removeAt(i + 1)
//        }
//        i++
//    }
//    println(newNumber)
//    var num = ""
//    for (char in newNumber) {
//        num +=  char
//    }
//    return num.toBigInteger()
//}

fun main() {
    var start = Math.sqrt(19293949596979899.toDouble()).toInt() - 1
//    println(1389019170.toBigInteger() * 1389019170.toBigInteger())
//    println(matches(1929374254627488908.toBigInteger()))
    while (!matches(start.toBigInteger() * start.toBigInteger())) {
        println(start)
        start -= 2
    }
    println(start)
}

fun matches(number: BigInteger): Boolean {
    val numberUnderscores = "1_2_3_4_5_6_7_8_9_".toCharArray()
    val number = number.toString().toCharArray()
    var i = 0
    while (i < numberUnderscores.size) {
        if (number[i] != numberUnderscores[i]) {
            return false
        }
        i += 2
    }
    return true
}