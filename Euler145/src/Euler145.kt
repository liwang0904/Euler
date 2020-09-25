fun main(){
    var count = 0
    for (i in 1..9) {
        when (i % 4) {
            0, 2 -> count += 20 * Math.pow(30.0, (i / 2 - 1).toDouble()).toInt()
            1 -> count += 100 * Math.pow(500.0, (i / 4 - 1).toDouble()).toInt()
            3 -> {
            }
        }

    }
}

private fun isReversible(n: Long): Boolean {

    var number = n

    //Check 0 in the end
    if (n % 10 == 0L) return false

    //Reverse the number
    var reversed: Long = 0
    while (number > 0) {
        reversed = 10 * reversed + number % 10
        number /= 10
    }

    //Add the original and reversed
    reversed += n

    //Check if all digits are odd
    while (reversed > 0) {
        if (reversed % 10 % 2 == 0L) return false
        reversed /= 10
    }

    return true
}