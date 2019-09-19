fun main (args : Array<String>) {
    println(calculate6())
}

fun calculate6() : Any {
    var numSum = 0
    var squareSum = 0
    for (i in 1..100) {
        numSum += i
        squareSum += i * i
    }
    return (numSum * numSum) - squareSum
}