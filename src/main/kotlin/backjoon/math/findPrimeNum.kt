package backjoon.math

/**
 * 백준 1978 - 소수 찾기
 */

fun main() {
    sol1()
}

fun sol1(){
    var count = 0
    readLine()
    readLine()!!.split(' ').map{ it.toInt() }.forEach{
        if (findPrimeNum(it)) count++
    }
    println(count)
}

fun findPrimeNum(n : Int): Boolean{
    if (n == 1) return false
    if (n == 2) return true
    for (i in 2 until n){
        if (n % i == 0) return false
    }
    return true
}

fun shortSol1() {
    readLine()
    println(readLine()!!.split(' ').map {it.toInt()}.filter {
            n->(n!=1&&!(2 until n).any{n%it==0})
    }.size)
}