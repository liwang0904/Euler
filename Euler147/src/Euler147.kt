fun main() {
//    println(verticalHorizontalCount(3, 2))
//    println(diagonalCount(3, 2))
    var count = 0
    count += verticalHorizontalCount(3, 2) + diagonalCount(3, 2)
    println(count)
}

fun verticalHorizontalCount(c: Int, r: Int): Int {
    return (c * (c + 1) * r * (r + 1)) / 4
}

fun diagonalCount(c: Int, r: Int): Int {
    return (r * ((2 * c - r) * (4 * r * r - 1) - 3)) / 6
}