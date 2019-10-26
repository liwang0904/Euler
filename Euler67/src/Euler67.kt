import java.io.File

fun main(args: Array<String>) {
    var listOfLines = read_file("src/p067_triangle.txt")
    //println(listOfLines)
    //println(divideLine(listOfLines))
    //println(add_two_lines(mutableListOf(36, 84), mutableListOf(63, 73, 47)))
    var max = 0
    for (num in add_all_lines(divideLine(listOfLines))) {
        if (num > max) {
            max = num
        }
    }
    println(max)
}

fun divideLine(listOfLines: MutableList<String>): MutableList<MutableList<Int>> {
    var lineNumsList = mutableListOf<MutableList<Int>>(mutableListOf(listOfLines.get(0).toInt()))
    for (line in listOfLines) {
        if (line.contains(" ")) {
            var dividedLine = line.split(" ")
            var lineNums = mutableListOf<Int>()
            for (num in dividedLine) {
                lineNums.add(num.toInt())
            }
            lineNumsList.add(lineNums)
        }
    }
    return lineNumsList
}

fun read_file(fileName: String): MutableList<String> {
    var listOfLines = File(fileName).useLines { it.toMutableList() }
    return listOfLines
}

fun add_two_lines(line1: MutableList<Int>, line2: MutableList<Int>): MutableList<Int> {
    var sum = mutableListOf<Int>()
    for (i in 0..line2.size - 1) {
        if (i == 0) {
            sum.add(line1.get(0) + line2.get(0))
        } else if (i == line2.size - 1) {
            sum.add(line1.get(line1.size - 1) + line2.get(line2.size - 1))
        } else {
            var addend1 = line1.get(i - 1)
            var addend2 = line1.get(i)
            var num = line2.get(i)
            if (addend1 + num > addend2 + num) {
                sum.add(addend1 + num)
            } else {
                sum.add(addend2 + num)
            }
        }
    }
    return sum
}

fun add_all_lines(listOfLines: MutableList<MutableList<Int>>): MutableList<Int> {
    //var sum = mutableListOf<Int>()
    while (listOfLines.size > 1) {
        var nextLine = listOfLines.get(1)
        //println("next line: $listOfLines")
        var partSum = add_two_lines(listOfLines.get(0), nextLine)
        listOfLines.removeAt(0)
        listOfLines.removeAt(0)
        listOfLines.add(0, partSum)
        add_all_lines(listOfLines)
    }
    return listOfLines.get(0)
}