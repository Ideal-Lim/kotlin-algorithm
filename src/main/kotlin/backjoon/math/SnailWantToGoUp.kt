package backjoon.math

import kotlin.math.ceil

/**
 * 백준 2869번 - 달팽이는 올라가고 싶다.
 */
fun main() {
    readLine()!!.split(' ').map{it.toDouble()}.let{(a,b,v) -> println(ceil((v-b) / (a-b)).toInt())}
}