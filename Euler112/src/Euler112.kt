fun isBouncy(num: Int): Boolean {
    var num = num
    var increasing = false
    var decreasing = false
    var last = num % 10
    num /= 10
    while (num > 0) {
        val next = num % 10
        num /= 10
        if (next < last) {
            increasing = true
        } else if (next > last) {
            decreasing = true
        }
        last = next
        if (decreasing && increasing) {
            return true
        }
    }
    return decreasing && increasing
}

fun main() {
//    println(isBouncy(156))
    var i = 99
    var bouncies = 0
    while (100 * bouncies < 99 * i) {
        i++
        if (isBouncy(i)) {
            bouncies++
        }
    }
    println(i)
}