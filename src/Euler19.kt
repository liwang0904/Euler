import java.util.*

fun main(args: Array<String>) {
    println(calculate19())
}
fun calculate19(): Any {
    var sum = 0
    val start = GregorianCalendar.getInstance()
    start.set(1901, 1, 1)
    val end = GregorianCalendar.getInstance()
    end.set(2000, 12, 31)
    while (start.before(end)) {
        if (start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) sum++
        start.add(Calendar.MONTH, 1)
    }
    return sum
}