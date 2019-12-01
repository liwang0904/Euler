fun main(args: Array<String>) {
    var trianlges = mutableListOf<MutableList<Int>>()
    println(produce_triangles(12, 50))
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun produce_triangles(max: Int, max1: Int): MutableList<MutableList<Int>> {
    var triangles = mutableListOf<MutableList<Int>>()
    for (n in 1..max) {
        for (m in n..max) {
            var a = (n * n - m * m) * -1
            var b = 2 * n * m
            var c = m * m + n * n
            if (a * a + b * b == c * c && a > 0) {
                triangles.add(mutableListOf(a, b, c))
            }
            if ((m + n) % 2 == 1 && gcd(m, n) == 1) {
                var sum = a + b + c
                var i = 2
                while (sum <= max1) {
                    println("$sum, $max1")
                    triangles.add(mutableListOf(a * i, b * i, c * i))
                    i++
                    sum *= i
                }
            }
        }
    }
    return triangles
}