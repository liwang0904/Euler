fun main(args: Array<String>) {
    var goal = 2000000
    var x = 0
    var y = 0

    for (i in 1..99) {
        //println(i)
        for (j in 1..99) {
            val rectangle_count = rectangle_count(i, j)
            if (Math.abs(2000000 - rectangle_count) < goal) {
                goal = Math.abs(2000000 - rectangle_count)
                x = i
                y = j
            }
        }
    }
    //println(rectangle_count(2, 3))
    println(x * y)
}

fun rectangle_count(x: Int, y: Int): Int {
    var counter = 0
    for (i in 1..x) {
        for (j in 1..y) {
            counter += (x - i + 1) * (y - j + 1)
            //println(counter)
        }
    }
    return counter
}