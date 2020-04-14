fun main(){
//    val word = "2969"
//    val list = word.toCharArray().toMutableList()
//    val permList = permute(list)
//    val distPerList = permList.distinct()
//    for(perm in distPerList)
//        println(perm)

    val primes = get_primes(10000)
    println(permutationPrimes(primes))

    for (primes in permutationPrimes(primes)) {
        if (isPrimePermutation(primes)) {
            println(primes)
        }
    }
}
fun <String> permute(list: List<String>): List<List<String>>{
    if(list.size == 1)
        return listOf(list)
    val perms = mutableListOf<List <String>>()
    val sub = list[0]
    for(perm in permute(list.drop(1)))
        for (i in 0..perm.size){
            val newPerm = perm.toMutableList()
            newPerm.add(i,sub)
            perms.add(newPerm)
        }
    return perms
}

fun is_prime(num: Int): Boolean {
    for (i in 2..num / 2) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun get_primes(limit: Int): MutableList<Int> {
    var primes = mutableListOf(2)
    var i = 3
    while (i <= limit) {
        if (is_prime(i)) {
            primes.add(i)
        }
        i += 2
    }
    return primes
}

fun isPermutation(int1: Int, int2: Int): Boolean {
    if (int1.toString().length == int2.toString().length) {
        return (int1.toString().toCharArray().sorted() == int2.toString().toCharArray().sorted())
    }
    return false
}

fun removeElement(string: Int, strings: MutableList<Int>): MutableList<Int> {
    val newElements = mutableListOf<Int>()
    for (element in strings) {
        if (string != element) {
            newElements.add(element)
        }
    }
    return newElements
}

fun permutationPrimes(primes: MutableList<Int>): MutableList<MutableList<Int>> {
    var primes = primes
    val anagrams = mutableListOf<MutableList<Int>>()
    for (word1 in primes) {
        val permutations = mutableListOf<Int>()
        val wordsNoWord = removeElement(word1, primes.toMutableList())
        for (word2 in wordsNoWord) {
            if (isPermutation(word1, word2)) {
                primes = removeElement(word1, primes)
                primes = removeElement(word2, primes)
                permutations.add(word1)
                permutations.add(word2)
            }
        }
        if (permutations.distinct().size >= 3) {
            anagrams.add(permutations.distinct().toMutableList())
        }
    }
    return anagrams
}

fun isPrimePermutation(primes: MutableList<Int>): Boolean {
    for (prime1 in primes) {
        val newprimes1 = removeElement(prime1, primes)
        for (prime2 in newprimes1) {
            val newprimes2 = removeElement(prime2, primes)
            if (prime2 - prime1 == 3330) {
                for (prime3 in newprimes2) {
                    if (prime3 - prime2 == 3330) {
                        println(prime1)
                        println(prime2)
                        println(prime3)
                        return true
                    }
                }
            }
        }
    }
    return false
}