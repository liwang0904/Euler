fun main(args: Array<String>) {
    println(calculate())
}
private fun calculate(): Any {
    return (3..9999999).filter { isCurious(it) }.sum()
}

private fun isCurious(int: Int) = int.toString().map { it.toString().toInt().factorial() }.sum() == int

private fun Int.factorial(): Int {
    var product = 1
    for (i in this downTo 2) product *= i
    return product
}