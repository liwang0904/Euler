fun main() {
    //println(isAreaOfTriangleInt(4.toDouble(), 6.toDouble()))
    println(sum(333333333))
}

fun isAreaOfTriangleInt(side: Double, base: Double): Boolean {
    val s = (side * 2 + base) / 2
    val area = Math.sqrt(s * (s - side) * (s - side) * (s - base))
    return  area - area.toInt() == 0.0
}

fun sum(max: Long): Long {
    var sum : Long = 0
    for (side in 1..max) {
        println(side)
        if (isAreaOfTriangleInt(side.toDouble(), (side + 1).toDouble())) {
            println("side = $side       base = ${side + 1}")
            sum += (side * 2) + (side + 1)
        } else if (isAreaOfTriangleInt(side.toDouble(), (side - 1).toDouble())) {
            println("side = $side       base = ${side - 1}")
            sum += (side * 2) + (side - 1)
        }
    }
    return sum
}