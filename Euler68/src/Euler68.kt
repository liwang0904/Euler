fun main (args: Array<String>) {
    var max = 10
    var string = "1234"
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
    //.printPermutn(string, "", permutations)
    //println(get_permutations(permutations))
    val list = mutableListOf(1, 2, 3)
    val permList = permute(list)
    //println(permList)
    //println(get_every_third(mutableListOf(4, 3, 2, 6, 1, 5)))
    println(get_possible_solution_set(mutableListOf(4, 3, 2, 6, 1, 5)))
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
        if ((i - 2) % 3 == 0) {
            val third = everyThird.get(0)
            println(third)
            solutionSet.add(perm.get(i))
            solutionSet.add(third)
            everyThird.removeAt(0)
            i += 2
        } else {
            solutionSet.add(perm.get(i))
            i++
        }
        println(solutionSet)
    }
    solutionSet.add(oop)
    return solutionSet
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