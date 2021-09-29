package backjoon.math

/**
 * 백준 2839 - 설탕 배달
 */

fun main() {
    readLine()!!.toInt().let {
        when {
            it == 3 -> println(1)
            it < 5 -> println(-1)
            it == 7 -> println(-1)
            it % 5 == 0 -> println("${it/5}")
            it % 5 == 1 -> println("${it/5 + 1}")
            it % 5 == 2 -> println("${it/5 + 2}")
            it % 5 == 3 -> println("${it/5 + 1}")
            it % 5 == 4 -> println("${it/5 + 2}")
        }
    }
}