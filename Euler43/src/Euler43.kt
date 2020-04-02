fun main() {
    val list = mutableListOf<String>()
    permutation("", "1234567890", list)
    var sum = 0.toLong()
    //println(list)
    for (num in list) {
        if (isSubStringDivisible(num)) {
            sum += num.toLong()
        }
    }
    println(sum)
}

fun permutation(prefix: String, str: String, list: MutableList<String>) {
    val n = str.length
    if (n == 0)
        list.add(prefix)
    else {
        for (i in 0 until n)
            permutation(prefix + str[i], str.substring(0, i) + str.substring(i + 1, n), list)
    }
}

fun isSubStringDivisible(num: String): Boolean {
    val list = num.toCharArray()
    if (list[1].plus("").plus(list[2].plus("").plus(list[3])).toInt() % 2 == 0) {
        if (list[2].plus("").plus(list[3].plus("").plus(list[4])).toInt() % 3 == 0) {
            if (list[3].plus("").plus(list[4].plus("").plus(list[5])).toInt() % 5 == 0) {
                if (list[4].plus("").plus(list[5].plus("").plus(list[6])).toInt() % 7 == 0) {
                    if (list[5].plus("").plus(list[6].plus("").plus(list[7])).toInt() % 11 == 0) {
                        if (list[6].plus("").plus(list[7].plus("").plus(list[8])).toInt() % 13 == 0) {
                            if (list[7].plus("").plus(list[8].plus("").plus(list[9])).toInt() % 17 == 0) {
                                return true
                            }
                        }
                    }
                }
            }
        }
    }
    return false
}