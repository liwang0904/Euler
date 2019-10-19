fun main(args: Array<String>) {
    println(calculate14())
}
fun calculate14(): Any {
    var limit = 1000000
    var size = 0
    var max = 1
    var j = 0
    for (i in 2 until limit) {
        size = getChainSize(i)
        if (size > max) {
            max = size
            j = i
        }
    }
    return j
}

private fun getChainSize(n: Int): Int {
    var num = n.toLong()
    val list = ArrayList<Long>()
    while (num != 1L) {
        list.add(num)
        num = if (num % 2 == 0L) {
            num / 2
        } else {
            3 * num + 1
        }
    }
    return list.size
}