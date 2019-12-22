fun main(args: Array<String>) {
    var sum = 0
    for (i in 1..9)
        sum += (1.0 / (1 - Math.log(i.toDouble()) / Math.log(10.0))).toInt()
    println(sum)
}