fun main (args: Array<String>) {
    var sum = 0
    var x = 1
    var y = 2
    while (x < 4_000_000) {
        if (x % 2 == 0) sum += x
        var z = x + y
        x = y
        y = z
    }
    println(sum)
}