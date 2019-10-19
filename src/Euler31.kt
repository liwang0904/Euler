fun main(args: Array<String>) {

    var solutions  : MutableList<MutableList<Int>> = mutableListOf();
    getSolutions(200, mutableListOf(200, 100, 50, 20, 10, 5, 2, 1), mutableListOf(), solutions)
    println(solutions.size)
}


fun getSolutions(amount: Int, faceValues: MutableList<Int>, solution: MutableList<Int>, solutions: MutableList<MutableList<Int>>) {
    println("When it is first get  first called faceValues is  $faceValues  solutions is $solution")
    println(amount)
    var faceValue = faceValues[0]
    //println(faceValue)
    var times = amount / faceValue
    if (faceValues.size==1) { // last faceValue in faceValues
        solution.add(times)
        //println("$amount ============solutions is $solution")
        solutions.add(solution)
        //println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
        //println("here")
        return;
    }


    faceValues.removeAt(0)
    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@$$faceValues")
    //println(times)

    for (i in 0..times) {
        println("Using amount=$amount  facevalue = $faceValue  $faceValues  i=$i   times=$times")
        var faceValues2 = mutableListOf<Int>();
        faceValues2.addAll(faceValues)
        var solution2 = mutableListOf<Int>()
        solution2.addAll(solution)
        solution2.add(i)
        println("=======$amount = $faceValue============$faceValues")
        getSolutions(amount - i * faceValue, faceValues2, solution2, solutions)
    }
    //return solutions
}