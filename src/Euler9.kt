fun main(args: Array<String>) {
    println(calculate9())
}

fun calculate9(): Any {
    for (a in 1..1000) {
        for (b in 1..1000) {
            val c = Math.sqrt((a * a + b * b).toDouble())
            if (a.toDouble() + b.toDouble() + c == 1000.0) return "${(a * b * c).toLong()}"
        }
    }
    return "oof no answer"
}