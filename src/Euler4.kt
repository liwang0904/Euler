 fun main (args : Array<String>) {
        println (calculate4())
    }

    fun calculate4() : Any {
        var largest = PalindromeResult(0, 0, 0)
        for (i in 100..999) {
            for (j in 100..999) {
                if (isPal(i, j) && i * j > largest.product) largest = PalindromeResult(i, j)
            }
        }
        return "${largest.product}"
    }

    private fun isPal(i: Int, j: Int): Boolean {
        val str = (i * j).toString()
        return str.substring(0, Math.floor(str.length / 2.0).toInt()) == str.substring(Math.ceil(str.length / 2.0).toInt(), str.length).reversed()
    }
data class PalindromeResult(val first: Int, val second: Int, val product: Int = first * second)