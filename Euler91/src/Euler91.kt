fun main() {
    val dimen = 50
    var total = 0
    for (py in dimen downTo 1)
        for (px in 0..dimen)
        // q right/down from p
            for (qy in py downTo 0)
                for (qx in px..dimen) {
                    val pqdist = (px - qx) * (px - qx) + (py - qy) * (py - qy)
                    if (pqdist == 0)
                        continue
                    val opdist = px * px + py * py
                    if (opdist == 0)
                        continue
                    val oqdist = qx * qx + qy * qy
                    if (oqdist == 0)
                        continue
                    if (pqdist > opdist && pqdist > oqdist) {
                        if (oqdist + opdist == pqdist)
                            total++
                        continue
                    }
                    if (oqdist > opdist && oqdist > pqdist) {
                        if (pqdist + opdist == oqdist)
                            total++
                        continue
                    }
                    if (pqdist + oqdist == opdist)
                        total++
                }
    println(total)
}