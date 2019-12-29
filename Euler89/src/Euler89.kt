import java.util.*
import java.io.*

fun main(args: Array<String>) {
    val romans = Scanner(File("src/p089_roman.txt"))
    var savedLetters = 0
    while (romans.hasNext()) {
        val roman = romans.next()
        if (roman.contains("VIIII"))
            savedLetters += 3
        else if (roman.contains("IIII")) savedLetters += 2
        if (roman.contains("LXXXX"))
            savedLetters += 3
        else if (roman.contains("XXXX")) savedLetters += 2
        if (roman.contains("DCCCC"))
            savedLetters += 3
        else if (roman.contains("CCCC")) savedLetters += 2
    }
    println(savedLetters)
}