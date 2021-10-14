package backjoon.bruteForce

import kotlin.math.pow

fun mySolution() {
    val N = readLine()!!
    val digitN = N.map{ it.toString().toInt() }
    var ans = 1000000

    fun digitToNum(tmpDigit:ArrayList<Int>, firstDigit: Int): Int{
        if (digitN.size == 1) return firstDigit

        val tmp = ArrayList<Int>(tmpDigit.size)
        for (i in tmpDigit.indices){
            tmp.add(tmpDigit[i] * (10.0.pow(tmpDigit.size-i-1)).toInt())
        }
        return tmp.sum() + (firstDigit * (10.0.pow(tmpDigit.size))).toInt()
    }

    fun calcM(depth: Int, tmpDigit: ArrayList<Int>, firstDigit: Int){
        if (depth == digitN.size - 1){
            val digitSum = tmpDigit.sum() + firstDigit // M의 각자리 숫자 합
            val m = digitToNum(tmpDigit, firstDigit) // M
            val n = m + digitSum
            if (n == N.toInt()) {
                if (ans > m) ans = m
            }
            return
        }
        for (i in 0..9){
            tmpDigit.add(i)
            calcM(depth + 1, tmpDigit, firstDigit)
            tmpDigit.remove(i)
        }
    }

    // digitN 의 개수 -> 자리수
    // 가장 높은 자리수
    for (i in 0..digitN[0]){
        calcM(0, ArrayList<Int>(digitN.size), i)
    }
    if (ans == 1000000) print(0) else print (ans)
}

fun bestSol(){
    val numStr = readLine()!!
    val num = numStr.toInt()
    for (i in (num - (numStr.length * 9))..num) {
        var sum = i
        var check = i
        while (check > 0) {
            sum += check % 10
            check /= 10
        }
        if (sum == num) {
            print(i)
            return
        }
    }
    print(0)
}

fun main(){
    bestSol()
}
