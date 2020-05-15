fun main() {
    println(getNums(7))
}

fun isPrime(num: Int): Boolean {
    var i = 2
    while (i <= num / 2) {
        if (num % i == 0) {
            return false
        }
        ++i
    }
    return true
}

fun ratio()

fun getNums(side_length: Int): MutableList<Int> {
    val nums = mutableListOf(1)
    var side = 3
    var num = 1
    while (side <= side_length) {
        for (i in 1..4) {
            val difference = side - 1
            num += difference
            nums.add(num)
        }
        side += 2
    }
    return nums
}