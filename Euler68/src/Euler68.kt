fun main (args: Array<String>) {
    //var max = 10
    //var string = "12345678910"
    /*var i = 1
    while (i <= max) {
        string += i.toString()
        i++
    }*/
    //var n = string.length
    //var permutations = mutableListOf<String>()
    //permute(string, 0, n - 1)
    var permutations = mutableListOf<Long>()
    //permute_num("", string, permutations)
    //println(get_permutations(permutations).size)
    //printPermutn(string, "", permutations)
    //println(get_permutations(permutations))
    val list = mutableListOf(1, 2, 3, 4, 5, 6)
    //val permList = permute(list)
    //println(get_solution_set(list))
    var max = mutableListOf<Int>()
    //for (perm in permList) {
    //    println(get_solution_set(perm))
    //}
    println(divide_into_thirds(list))
    println(get_solution_set1(divide_into_thirds(list)))
}

fun <Int> permute(list: List<Int>): List<List<Int>> {
    if (list.size == 1) return mutableListOf(list)
    val perms = mutableListOf<MutableList<Int>>()
    val sub = list[0]
    for(perm in permute(list.drop(1))) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, sub)
            perms.add(newPerm)
        }
    }
    return perms
}

fun get_every_third(perm: List<Int>): MutableList<Int> {
    var everyThird = mutableListOf<Int>()
    for (i in 1..perm.size - 1) {
        if (i % 2 == 0) {
            everyThird.add(perm.get(i))
        }
    }
    return everyThird
}

fun get_possible_solution_set(perm: List<Int>): MutableList<Int> {
    var solutionSet = mutableListOf(perm.get(0), perm.get(1), perm.get(2))
    val oop = perm.get(1)
    val everyThird = get_every_third(perm)
    var i = 3
    while (i < perm.size) {
        println(i)
        if ((i - 2) % 3 == 0) {
            val third = everyThird.get(0)
            //println(third)
            solutionSet.add(perm.get(i))
            solutionSet.add(third)
            everyThird.removeAt(0)
            i += 2
        } else {
            solutionSet.add(perm.get(i))
            i++
        }
        //println(solutionSet)
    }
    solutionSet.add(oop)
    return solutionSet
}

fun get_solution_set(perm: List<Int>): MutableList<Int> {
    var solutionSet = mutableListOf(perm.get(0), perm.get(1), perm.get(2))
    val everyThird = get_every_third(perm)
    var i = 3
    var size = perm.size
    while (i < size - 4) {
        println(i)
        if (i % 3 == 0) {
            solutionSet.add(perm.get(i))
            solutionSet.add(everyThird.get(0))
            //println(everyThird.get(0))
            everyThird.removeAt(0)
            size += 2
        } else {
            solutionSet.add(perm.get(i))
        }
        i++
    }
    solutionSet.add(everyThird.get(0))
    solutionSet.add(perm.get(1))
    return solutionSet
}

fun divide_into_thirds(perm: List<Int>): MutableList<MutableList<Int>> {
    var i = 0
    var newPerm = mutableListOf<MutableList<Int>>()
    var list = mutableListOf<Int>()
    while (i < perm.size) {
        if ((i - 2) % 3 == 0) {
            //println("here: ${perm.get(i)}")
            list.add(perm.get(i))
            newPerm.add(list)
            //println(newPerm)
            list = mutableListOf()
        } else {
            list.add(perm.get(i))
            newPerm.add(list)
        }
        i++
    }
    return newPerm.distinct().toMutableList()
}

fun get_solution_set1(perm: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    var solutionSet = perm
    var list = mutableListOf<Int>()
    for (i in perm) {
        for (j in i) {
            list.add(j)
        }
    }
    var lastNums = get_every_third(list)
    println(lastNums)
    var i = 0
    while (i < perm.size - 1) {
        //var lastInList = perm.get(i).get(2)
        var list = solutionSet.get(i + 1)
        list.add(1, lastNums.get(0))
        lastNums.removeAt(0)
        i++
    }
    solutionSet.get(solutionSet.size - 1).add(lastNums.get(0))
    solutionSet.get(solutionSet.size - 1).add(perm.get(0).get(1))
    return solutionSet
}

fun join(perm: MutableList<MutableList<Int>>): MutableList<Int> {
    var list = mutableListOf<Int>()
    for (i in perm) {
        for (j in i) {
            list.add(j)
        }
    }
    return list
}

fun is_solution_set(solutionSet: MutableList<MutableList<Int>>): Boolean {
    var list = divide_into_thirds(join(solutionSet))
    var sum = list.get(0).get(0) + list.get(0).get(1) + list.get(0).get(2)
    for (nums in list) {
        num
    }
}

/*
fun printPermutn(str: String, ans: String, permutations: MutableList<Long>){
    if (str.length == 0) {
        permutations.add(ans.toLong())
        return
    }

    for (i in 0 until str.length) {
        val ch = str[i]
        val ros = str.substring(0, i) + str.substring(i + 1)
        printPermutn(ros, ans + ch, permutations)
        //println(permutations)
    }
}

fun get_permutations(permutations: MutableList<Long>): MutableList<MutableList<Int>> {
    var newPermutations = mutableListOf<MutableList<Int>>()
    for (num in permutations) {
        var permutation = num.toString().map { it.toString().toInt() }.toMutableList()
        newPermutations.add(permutation)
    }
    return newPermutations
}
*/