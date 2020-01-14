fun main() {
    var total = 0
    var base2: String
    var base10: String

    var i = 1
    while (i < 1000000) {
        base2 = Integer.toString(i, 2)
        base10 = i.toString()
        if (isPalindrome(base2) && isPalindrome(base10)) total += i
        i += 2

    }
    println(total)
}

private fun isPalindrome(str: String): Boolean {
    var i = 0
    while (i < str.length / 2) {
        if (str[i] != str[str.length - i - 1]) return false
        i++
    }
    return true
}