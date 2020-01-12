fun main() {
    var counter: Long = 1
    var index = 1
    var k = 2
    while (k < 1001) {
        for (p in 0..3) {
            index += k
            counter += index.toLong()
        }
        k += 2
    }
    println(counter)
}