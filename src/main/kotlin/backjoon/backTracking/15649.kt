package backjoon.backTracking

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 백준 15649번 N과 M
 */

fun main() {
    readLine()!!.split(' ').map{it.toInt()}.let { (N, M) ->
        val arr = IntArray(N) { i -> i + 1 }
//        makePermutationByForLoop1(3,N,arr)
//        makePermutationByForLoop2(N,arr)
        makePermutationByRecursion(arr, M, IntArray(M), 0, BooleanArray(N))
    }
}

// r: 뽑는 수, n: 개수,
fun makePermutationByForLoop1(r: Int, n:Int, arr: IntArray)= with(BufferedWriter(OutputStreamWriter(System.out))){
    // M = 2
    if (r == 2) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue //중복 배제
                this.write("${arr[i]} ${arr[j]}\n")
            }
        }
    }
    // M = 3
    if (r == 3) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    if (i == j || j == k || i == k) continue
                    this.write("${arr[i]} ${arr[j]} ${arr[k]}\n")
                }
            }
        }
    }
    this.flush()
    this.close()
}

// r: 뽑는 수, n: 개수,
fun makePermutationByForLoop2(n:Int, arr: IntArray) = with(BufferedWriter(OutputStreamWriter(System.out))){
    //
    val isUsed = BooleanArray(n)

    for (i in arr.indices){
        if (isUsed[i]) continue
        isUsed[i] = true

        for (j in arr.indices){
            if (isUsed[j]) continue
            isUsed[j] = true

            for (k in arr.indices){
                if (isUsed[k]) continue
                isUsed[k] = true
                this.write("${arr[i]} ${arr[j]} ${arr[k]}\n")
                isUsed[k] = false
            }
            isUsed[j] = false
        }
        isUsed[i] = false
    }
    this.flush()
    this.close()
}

fun makePermutationByRecursion(arr: IntArray, r: Int, temp: IntArray, depth: Int, isUsed: BooleanArray) {
    if (r == depth) { // 탈출조건 : depth 가 r과 같아진 경우, 즉 하나의 순열 완성 tmp.size 써도 무방.
//        println(temp.joinToString(" "))
        println(temp.contentToString())
    } else {
        for (i in arr.indices) {
            if (isUsed[i]) continue
            isUsed[i] = true
            temp[depth] = arr[i]
            makePermutationByRecursion(arr, r, temp, depth + 1, isUsed)
            isUsed[i] = false
        }
    }
}

fun shortSol(){
    val (n,m)= readLine()!!.split(' ').map{it.toInt()}
    val boolArr=BooleanArray(n+1)
    val tmp=IntArray(m)
    fun getPermutation(d:Int){
        if (m==d) {
            println(tmp.joinToString(" "))
        }
        else {
            for(i in 1..n){
                if(!boolArr[i]){
                    boolArr[i]=true
                    tmp[d]=i;
                    getPermutation(d+1);
                    boolArr[i]=false
                }
            }
        }
    }
    getPermutation(0)
}