package backjoon.math

import java.io.BufferedReader
import java.io.InputStreamReader

import java.lang.StringBuilder
import kotlin.math.sqrt
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * 백준 1929번 - 소수 구하기 (에라토스테네스의 체)
 */

fun main(){
//    val time1 = measureTimeMillis {
//        quickFindPrimeNumSol1()
//    }

    val time2 = measureTimeMillis {
        quickFindPrimeNumSol2()
    }

//    val time3 = measureTimeMillis {
//        quickFindPrimeNumSol3()
//    }

    val time4 = measureTimeMillis {
        quickFindPrimeNumSol4()
    }

//    println(time4)
//    println("sol1 : ${time1}ms , sol2 : ${time2}ms , sol3 : ${time3}ms")
    println("sol2 : ${time2}ms , sol3 : ${time4}ms")
//    println("sol2 : ${time2}ms")

}


fun quickFindPrimeNumSol1() {
//    val NM = readLine()!!.split(" ")
//    val N = NM[0].toInt()
//    val M = NM[1].toInt()

    val N = 1
    val M = 1000000

    // prime(index) 여부를 저장하는 array
    val check = BooleanArray(M + 1){true}

    for (num in N..M){
        val sqrt = sqrt(num.toDouble()).toInt()
        // 2부터 N의 제곱근까지의 수까지 나눠서 나누지면 반복문 종료
        for (i in 2..sqrt){
            if (num % i == 0) {
                check[num] = false
                break
            }
        }
    }

//    for (i in N..M){
//        if (i == 1) continue
//        if (check[i]) println(i)
//    }
}

fun quickFindPrimeNumSol2() {
//    val NM = readLine()!!.split(" ")
//    val N = NM[0].toInt()
//    val M = NM[1].toInt()

    val N = 1
    val M = 100000

    // index 에 따라 prime 여부를 저장하는 array
    val prime = BooleanArray(M + 1){true}

    val sqrtOfM = sqrt(M.toDouble()).toInt()
    // 2의 배수, 3의 배수, 4의 배수 ... sqrt의 배수를 걸러낸다.
    for (i in 2..sqrtOfM){ //(1)
        var j = 2
        while (i*j <= M){
            if (prime[i*j]) prime[i*j] = false
            j++
        }
    }

    for (i in N..M){
        if (i == 0 || i == 1) continue
        if (prime[i]) println(i)
    }
}

fun quickFindPrimeNumSol3() {
//    val NM = readLine()!!.split(" ")
//    val N = NM[0].toInt()
//    val M = NM[1].toInt()

    val N = 1
    val M = 10000

    // index 에 따라 prime 여부를 저장하는 array
    val prime = BooleanArray(M + 1){true}

    val sqrt = sqrt(M.toDouble()).toInt()

    val primeInSqrt = getPrimeArr(sqrt)
    // 2의 배수, 3의 배수, 5의 배수 ... sqrt 보다 작은 소수의 배수를 걸러낸다.
    for (i in 2 until primeInSqrt.size){
        if (primeInSqrt[i]){
            var j = 2
            while (i*j <= M){
                if (prime[i*j]) prime[i*j] = false
                j++
            }
        }
    }

    for (i in N..M){
        if (i == 0 || i == 1) continue
        if (prime[i]) println(i)
    }
}

fun getPrimeArr(size: Int) : BooleanArray{
    val prime = BooleanArray(size + 1){true}
    val sqrt = sqrt(size.toDouble()).toInt()

    for (i in 2..sqrt){
        var j = 2
        while (i*j <= size){
            if (prime[i*j]) prime[i*j] = false
            j++
        }
    }
    return prime
}

fun quickFindPrimeNumSol4() {
//    val NM = readLine()!!.split(" ")
//    val N = NM[0].toInt()
//    val M = NM[1].toInt()

    val N = 1
    val M = 100000

    // index 에 따라 prime 여부를 저장하는 array
    val prime = BooleanArray(M + 1){true}

    val sqrtOfM = sqrt(M.toDouble()).toInt()
    // 2의 배수, 3의 배수, 5의 배수 ... sqrt의 배수를 걸러낸다.
    for (i in 2..sqrtOfM){ //(1)
        // 이미 지워진 경우
        if (!prime[i]) continue
        // 소수의 배수 제외
        else {
            var j = 2
            while (i*j <= M) {
                if (prime[i * j]) prime[i * j] = false
                j++
            }
        }
    }

    for (i in N..M){
        if (i == 0 || i == 1) continue
        if (prime[i]) println(i)
    }
}
