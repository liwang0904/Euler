fun main(args: Array<String>) {
    println(calculate3())
}

fun calculate3() : Any {
    var num = 600851475143L
    var x = 2L
    while (x < num / x) {
        while (num % x == 0L) num /= x
        x++
    }
    return num
}