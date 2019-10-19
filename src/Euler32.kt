fun main(args: Array<String>) {
    println(calculate())
}
private fun calculate(): Any {
    val products = mutableSetOf<Int>()
    (1..9999).forEach { one ->
        (1..9999).forEach { two ->
            if (isPandigital(one, two)) {
                //System.out.println("$one and $two")
                products.add(one * two)
            }
        }
    }
    return products.sum()
}

fun isPandigital(num1: Int, num2: Int): Boolean {
    val elements = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val checkedElements = mutableListOf<Int>()
    val product = num1 * num2
    val stringDigits = num1.toString() + num2.toString() + product.toString()
    if (stringDigits.length != 9) {
        return false
    }
    val digits = stringDigits.toString().map {it.toString().toInt()}
    for (digit in digits) {
        if (elements.contains(digit.toInt())) {
            checkedElements.add(digit)
            checkedElements.sort()
            System.out.println(checkedElements)
        }
    }
    return (checkedElements == elements)
}