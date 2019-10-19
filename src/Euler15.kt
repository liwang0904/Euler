fun main(args: Array<String>) {
    println(calculate15())
}
fun calculate15(): Any {
    val result = generateGrid(20).numberOfRoutes()
    return result
}

private class generateGrid(val size: Int) {
    fun numberOfRoutes() : Long = pascal(2 * size, size)
    fun pascal(row: Int, col: Int): Long = if (col == 0) 1 else (row + 1 - col) * pascal(row, col - 1) / col

}