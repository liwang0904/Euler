import sun.security.util.Length

fun main(args: Array<String>) {
    //println(int_to_list(363601))
    //println(factorial_sum(363601))
    var count = 0
    var max = 1000000
    var length = 60
    for (i in 0..max) {
        var chain = mutableListOf<Long>()
        get_chain(i.toLong(), chain, i.toLong())
        if (chain.size == length) {
            count ++
        }
    }
    println(count)
}

fun int_to_list(num: Long): MutableList<Int> {
    val numbers = num.toString().map { it.toString().toInt() }
    return numbers.toMutableList()
}

fun factorial_sum(num: Long): Long {
    var sum: Long = 0
    for (i in int_to_list(num)) {
        var factorial: Long = 1
        //println(i)
        if (i == 0) {
            sum += 1
        } else {
            for (j in 1..i) {
                //println(j)
                factorial *= j.toLong()
            }
            //println(factorial)
            sum += factorial
        }
    }
    return sum
}

fun get_chain(startingNum: Long, chain: MutableList<Long>, currNum: Long) {
    //println("$currNum, $chain")
    if (chain.contains(factorial_sum(currNum))) {
        //println("here")
        chain.add(0, startingNum)
        return
    } else {
        var newCurrNum = factorial_sum(currNum)
        chain.add(newCurrNum)
        get_chain(startingNum, chain, factorial_sum(currNum))
    }
}
/*
fun get_chain1(startingNum: Long, chain: MutableList<Long>, size: Int, currNum: Long, listOfLength: MutableList<MutableList<Long>>) {
    //println("$currNum, $chain")
    var size = chain.size
    if (chain.contains(factorial_sum(currNum))) {
        //println("here")
        chain.add(0, startingNum)
        var list = listOfLength.get(chain.size - 1)
        for (i in chain) {
            list.add(i)
        }
        return
    } else {
        var newCurrNum = factorial_sum(currNum)
        for (list in listOfLength) {
            if (list.contains(newCurrNum)) {

            }
        }
        chain.add(newCurrNum)
        get_chain(startingNum, chain, factorial_sum(currNum))
    }
}*/