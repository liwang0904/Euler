fun main(args: Array<String>) {
    var n = 10
    //var primesUnder = getPrimesUnder(n).sortedWith(reverseOrder()).toMutableList()
    //println(primesUnder)
    println(solution_sums2(n))
}


var  COUNTS : MutableMap<Int, Int> = mutableMapOf()
// 10 ,  [ 7, 5, 3, 2,]
fun solution_sums2(n: Int) :  Int {
    if (n <= 3) return 0;
    var cached =  COUNTS.get(n)
    if(cached  != null ) {
        println("$n ached===== $cached")
        return cached
    }
    var nsols = 0

    var primesUnder = getPrimesUnder(n).sortedWith(reverseOrder()).toMutableList()
    for(p in primesUnder){
        var primesUnder2 = getPrimesUnder(p)
        var remainder = n - p
        println("n=$n  p=$p  remainder=$remainder ")
        if (primesUnder2.contains(remainder)) {
            println("$n  Find prime")
            nsols += 1
            //println(nsols)
        }

        var solutions_for_remainders = solution_sums2(remainder)
        println("$n  =====remainder= $remainder   sol=  $solutions_for_remainders")
        nsols += solutions_for_remainders
    }
    println("n=$n  nsol=$nsols")
    //COUNTS.put(n, nsols)
    return nsols
}





//var  COUNTS : MutableMap<Int, Int> = mutableMapOf()
// 10 ,  [ 7, 5, 3, 2,]
fun solution_sums(n: Int,  primesUnder : MutableList<Int>) :  Int {
    //var cached =  COUNTS.get(n)
    //if(cached  != null ) return cached
    if (n <= 3) return 0;
    var nsols = 0
    for(p in primesUnder){
        var primesUnder2 = getPrimesUnder(p)
        var remainder = n - p
        println("n=$n  p=$p  remainder=$remainder ")
        if (primesUnder2.contains(remainder)) {
            println("$n  Find prime")
            nsols += 1
            //println(nsols)
        }

        var solutions_for_remainders = solution_sums(remainder, getPrimesUnder(p))
        println("$n  =====remainder= $remainder   sol=  $solutions_for_remainders")
        nsols += solutions_for_remainders
    }
    println("n=$n  nsol=$nsols")
    //COUNTS.put(n, nsols)
    return nsols
}

fun getPrimesUnder(num: Int): MutableList<Int> {
    var primesUnder = mutableListOf<Int>()
    var i = 2
    while (i <= num) {
        if (is_prime(i))
            primesUnder.add(i)
        i++
    }
    return primesUnder
}


fun is_prime(num: Int): Boolean {
    var i = 2
    while (i <= num / 2) {
        if (num % i == 0) {
            return false
        }
        ++i
    }
    return true
}

fun get_summation_count(amount: Int, faceValues: MutableList<Int>, solution: MutableList<Int>, solutions: MutableList<MutableList<Int>>) {
    println("When it is first get first called faceValues is  $faceValues  solution is $solution")
    //println(amount)
    if (amount == 0) {
        //println("$amount ============solutions is $solution")
        solutions.add(solution)
        //println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
        //println("here")
        return
    }

    if (amount == 1 && faceValues.size == 1) {
        return
    }

    var faceValue = faceValues[0]
    faceValues.removeAt(0)
    //println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@$$faceValues")
    //println("times === $times")

    //println(faceValue)
    var times = amount / faceValue

    for (i in 0..times) {
        println("Using amount=$amount  facevalue = $faceValue  $faceValues  i=$i   times=$times")
        var faceValues2 = mutableListOf<Int>()
        faceValues2.addAll(faceValues)
        var solution2 = mutableListOf<Int>()
        solution2.addAll(solution)
        solution2.add(i)
        println("=======$amount = $faceValue============$faceValues")
        get_summation_count(amount - i * faceValue, faceValues2, solution2, solutions)
    }
    //return solutions
}