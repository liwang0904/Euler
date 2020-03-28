import java.io.File

fun main() {
    val list = fileToList("src/matrix.txt")
    //println(findSmallestNumIndex(list, 4))
    println(findSmallestNextPossibleIndex(list, mutableListOf(0, 4)))
    //println(findPath(list, 5, 4, 4))
}

fun fileToList(fileName: String): MutableList<MutableList<Int>> {
    val list = mutableListOf<MutableList<Int>>()
    File(fileName).forEachLine {
        val line = it.split(",").map { it.toInt() }.toMutableList()
        list.add(line)
    }
    return list
}

fun findSmallestNumIndex(list: MutableList<MutableList<Int>>, column: Int): MutableList<Int> {
    val columnNums = mutableListOf<Int>()
    for (row in list) {
        columnNums.add(row.get(column))
    }
    val min = columnNums.min()
    val row = columnNums.indexOf(min)
    return mutableListOf(row, column)
}

fun findSmallestNextPossibleIndex(list: MutableList<MutableList<Int>>, index: MutableList<Int>): MutableList<Int> {
    val row = index.get(0)
    val column = index.get(1)
    val possiblilities = mutableListOf(mutableListOf(row - 1, column), mutableListOf(row + 1, column), mutableListOf(row, column - 1))
    var index = mutableListOf<Int>()
    //println(possiblilities)
    var min = 10000000
    for (possibility in possiblilities) {
        val columnIndex = possibility.get(1)
        val rowIndex = possibility.get(0)
        if (columnIndex < 0 || rowIndex < 0) {
            continue
        } else {
            val rowNums = list.get(rowIndex)
            val num = rowNums.get(columnIndex)
            if (num < min) {
                min = num
                index = mutableListOf(rowIndex, columnIndex)
            }
        }
    }
    return index
}