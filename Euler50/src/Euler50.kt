fun main() {
    println(is_prime(58))
    val list = get_primes(100000)
    println(list)
    var sum = 0
    var max = 0
    for (num in list) {
        sum += num
        println(sum)
        println(sum < 1000000)
        if (is_prime(sum) && sum < 1000000 && sum + list.get(list.indexOf(num) + 1) > 1000000) {
            println(sum)
            break
        }
        max = sum
    }
}

fun is_prime(num: Int): Boolean {
    for (i in 2..num / 2) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun get_primes(max: Int): MutableList<Int> {
    val list = mutableListOf<Int>()
    var num = 2
    while (num <= max) {
        if (is_prime(num)) {
            list.add(num)
        }
        num++
    }
    return list
}