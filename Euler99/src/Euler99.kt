import java.io.File

fun main() {
//    println(525806 * Math.log(519432.toDouble()))
//    println(518061 * Math.log(632382.toDouble()))
//    println(baseExpToNum(mutableListOf(519432, 525806)))
    val file = "src/base_exp.txt"
    val list = fileToList("src/base_exp.txt")
    val nums = baseExpListToNums(list)
    val max = nums.max()
    for (num in nums) {
        if (num == max) {
            println(nums.indexOf(num) + 1)
        }
    }
}

fun fileToList(fileName: String): MutableList<MutableList<Int>> {
    val list = mutableListOf<MutableList<Int>>()
    File(fileName).forEachLine {
        val line = it.split(",").map { it.toInt() }.toMutableList()
        list.add(line)
    }
    return list
}

fun baseExpToNum(baseExp: MutableList<Int>): Double {
    val base = baseExp[0]
    val exp = baseExp[1]
    return exp * Math.log(base.toDouble())
}

fun baseExpListToNums(list: MutableList<MutableList<Int>>): MutableList<Double> {
    val nums = mutableListOf<Double>()
    for (baseExp in list) {
        val num = baseExpToNum(baseExp)
        nums.add(num)
    }
    return nums
}