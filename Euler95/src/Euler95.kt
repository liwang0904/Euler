/*fun main(args: Array<String>) {
    val L = 1000000
    val pds = IntArray(L + 1)
    for (i in 1..L / 2) {
        var a = i + i
        while (a <= L) {
            pds[a] += i
            a += i
        }
    }

    var start = 1
    var bl = -1
    var bi = L + 1
    val len = IntArray(L + 1)
    for (i in 1..L)
        if (len[i] == 0) {
            var s = start
            var a = i
            while (len[a] == 0) {
                len[a] = s++
                a = pds[a]
                if (a > L) a = 0
            }
            if (len[a] >= start) {
                val l = s - len[a]
                if (l >= bl) {
                    if (l > bl) bi = L + 1
                    bl = l
                    var b = a
                    do {
                        if (b < bi) bi = b
                        b = pds[b]
                    } while (b != a)
                }
            }
            start = s
        }
    println(bi)
}*/