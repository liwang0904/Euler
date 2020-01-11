fun main() {
    var max = 0
    var currMax = 0
    for (i in 2..999) {
        var r = 10
        val remainders = mutableListOf<Int>()
        var c = 0
        while (!remainders.contains(r)) {
            remainders.add(r)
            r = 10 * (r % i)
            c++
        }
        val cycleLength = c - remainders.lastIndexOf(r)
        if (cycleLength > max) {
            max = cycleLength
            currMax = i
        }
    }
    println(currMax)
}