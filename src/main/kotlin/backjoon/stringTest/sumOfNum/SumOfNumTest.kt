package algorithm.backjoon.sumOfNum

/**
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * https://www.acmicpc.net/problem/11720
 */
fun main() {
    val n = readLine()!!.toInt()
    var sum = 0
    readLine()!!.forEach{ sum += it.toString().toInt() }
    println(sum)
}