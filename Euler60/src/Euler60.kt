class Euler60 {
    var sumLimit = 30000
    var p = mutableListOf(3, 3, 3, 3, 3, 3)

    fun oop(num: Int) {
        if (num == 5) {
            if (check(5) && sumUpTo(5) < sumLimit) {
                sumLimit = sumUpTo(5)
                return
            }
        }
        if (!check(num))
            return

        var sum = sumUpTo(num)
        while (sum + (5 - num) * p[num] < sumLimit) {
            p[num] = nextPrime(p[num])
            p[num + 1] = p[num]
            oop(num + 1)
        }
    }
    fun check(num: Int): Boolean {
        for (i in 0 until num-1) {
            var a = (Math.log10(i.toDouble()) + 1).toInt()
            var b = (Math.log10(num.toDouble()) + 1).toInt()
            var c1 = i * (Math.pow(10.toDouble(), b.toDouble())).toInt() + num
            var c2 = num * (Math.pow(10.toDouble(), a.toDouble())).toInt() + i
            if (!(isPrime(c1) && isPrime(c2)))
                return false
        }
        return true
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

    fun nextPrime(num: Int): Int {
        var prime = num
        var found = false

        while (!found) {
            prime++

            if (isPrime(prime))
                found = true
        }

        return prime
    }

    fun sumUpTo(num: Int): Int {
        var sum = 0
        for (i in 0..num) {
            sum += i
        }
        return sum
    }
}
fun main(args: Array<String>) {
    oop(0)
    println(sumLimit)
}