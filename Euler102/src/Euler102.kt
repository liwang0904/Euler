import java.io.File

class Point(coordinates: MutableList<Int>) {
    val x = coordinates[0]
    val y = coordinates[1]
}

class Triangle(coordinates: MutableList<Point>) {
    private val A = coordinates[0]
    private val B = coordinates[1]
    private val C = coordinates[2]

    fun getArea(): Double {
        val part1 = A.x * (B.y - C.y)
        val part2 = B.x * (C.y - A.y)
        val part3 = C.x * (A.y - B.y)
        return 0.5 * Math.abs(part1 + part2 + part3)
    }

    fun containsPoint(P: Point): Boolean {
        val areaABC = getArea()
        val areaABP = Triangle(mutableListOf(A, B, P)).getArea()
        val areaAPC = Triangle(mutableListOf(A, P, C)).getArea()
        val areaPBC = Triangle(mutableListOf(P, B, C)).getArea()
        return areaABP + areaAPC + areaPBC == areaABC
    }
}

fun main() {
//    val coordinates = mutableListOf(Point(mutableListOf(-340, 495)), Point(mutableListOf(-153, -910)), Point(mutableListOf(835, -947)))
    val coordinates = mutableListOf(Point(mutableListOf(-175,41)), Point(mutableListOf(-421,-714)), Point(mutableListOf(574,-645)))
    val point = Point(mutableListOf(0, 0))
//    println(Triangle(coordinates).containsPoint(Point(point)))
    val file = "src/triangles.txt"
    val triangles = fileToCoordinates(file)
    var count = 0
    for (triangle in triangles)
        if (Triangle(triangle).containsPoint(point))
            count++
    println(count)
}

fun fileToCoordinates(file: String): MutableList<MutableList<Point>> {
    val list = mutableListOf<MutableList<Point>>()
    File(file).forEachLine {
        val line = it.split(",").map { it.toInt() }.toMutableList()
        val A = Point(mutableListOf(line[0], line[1]))
        val B = Point(mutableListOf(line[2], line[3]))
        val C = Point(mutableListOf(line[4], line[5]))
        list.add(mutableListOf(A, B, C))
    }
    return list
}