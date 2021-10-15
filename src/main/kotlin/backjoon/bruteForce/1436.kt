package backjoon.bruteForce

import java.io.BufferedReader
import java.io.InputStreamReader

fun mySolutionOf1436() {
    val n = readLine()!!.toInt()
    var count = 0

    for (i in 666L..100000000000000L){
        if (check666(i)) count += 1
        if (count == n) {
            print(i)
            break
        }
    }
}

fun check666(n: Long): Boolean{
    var numOf6 = 0 // 6이 이어진 개수
    n.toString().forEach {
        if (it == '6') numOf6 += 1 else numOf6 = 0
        if (numOf6 == 3) return true
    }
    return false
}


fun bestSolutionOf1436(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var count = 0
    var i = 0
    while (count < n) {
        i += 1
        if (hasThreeContinuousSix(i)) count += 1
    }
    println(i)
}

fun hasThreeContinuousSix(n: Int): Boolean {
    var num = n
    var count = 0
    while (num > 0) {
        if (num%10 == 6) { // 자리수 비교
            count += 1
            if (count==3) return true
        } else count=0
        num /= 10
    }
    return false
}