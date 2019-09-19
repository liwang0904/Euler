fun main (args : Array<String>) {
    println(calculate5())
}

fun calculate5() : Any {
    var num = 1
    while (true) {
        var working = true
        for (x in 2..20) {
            if (num / x.toDouble() != (num / x).toDouble()) {
                num ++
                working = false
            }
        }
        if (working) return num.toString()
    }
}