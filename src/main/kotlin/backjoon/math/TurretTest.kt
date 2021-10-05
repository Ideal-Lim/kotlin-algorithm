package backjoon.math

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 백준 1002번 - 터렛
 */
fun main() {
    val testTime = readLine()!!.toInt()
    for (i in 1..testTime){
        findPoints()
    }
}

fun findPoints(){
    readLine()!!.split(' ').map{ it.toDouble() }.let{(x1, y1, r1, x2, y2, r2) ->
        //거리
        val d = sqrt((x1-x2).pow(2) + (y1-y2).pow(2))
        when {
            //무수히 만날 때 - 같은 위치 같은 반지름
            d == 0.0 && r1 == r2 -> println(-1)
            // 안 만나는 경우 - 외부 / 내부 / 같은 위치 다른 반지름
            d > r1 + r2 || d < abs(r1 - r2) || (d == 0.0 && r1 != r2) -> println(0)
            // 한점에서 만나는 경우 - 외부 / 내부
            d == r1 + r2 || d == abs(r1 -r2) -> println(1)
            // 두 점에서 만나는 경우
            d < r1 + r2 || d > abs(r1 - r2) -> println(2)
        }
    }
}

private inline operator fun <T> List<T>.component6(): T {
    return get(5)
}


