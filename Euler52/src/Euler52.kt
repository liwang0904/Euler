fun main() {
    var i = 125874
    while (true) {
        i++
        if ((i * 6).toString().length == i.toString().length) {
            if(sameDigits(i, i * 2) &&
                sameDigits(i, i * 3) &&
                sameDigits(i, i * 4) &&
                sameDigits(i, i * 5) &&
                sameDigits(i, i * 6)) {
                println(i)
                break
            }
        }
    }
}

fun sameDigits(num1: Int, num2: Int): Boolean {
    if (num1.toString().length != num2.toString().length) {
        return false
    } else {
        val charArray1 = num1.toString().toCharArray().sorted()
        val charArray2 = num2.toString().toCharArray().sorted()
        if (charArray1 == charArray2) {
            return true
        }
    }
    return false
}