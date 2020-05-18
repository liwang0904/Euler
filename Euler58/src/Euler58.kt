fun main() {
    println(getNums())
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

fun getNums(): Int {
    var nums = mutableListOf(1)
    var side = 3
    var num = 1
    while (true) {
        println(side)
        for (i in 1..4) {
            val difference = side - 1
            num += difference
            nums = nums.add(num)
        }
        var count = 0
        for (num in nums) {
            if (isPrime(num)) {
                count++
            }
        }
        if (count.toDouble() / nums.size.toDouble() < 0.1) {
            println("HERE")
            return side
        }
        side += 2
    }
}