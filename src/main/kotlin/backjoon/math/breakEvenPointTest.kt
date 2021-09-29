package backjoon.math
import java.util.*
import kotlin.math.floor

/**
 * 백준 1712 - 손익분기점
 */
fun main() {
}

fun solution1(){
    val (a,b,c) = readLine()!!.split(' ').map{it.toDouble()}

    if (c <= b){
        println(-1)
    }
    else {
        println(floor(a / (c-b)).toInt() + 1)
    }
}


fun solution2() {
    val sc = Scanner(System.`in`)

    val a = sc.nextInt()
    val b = sc.nextInt()
    val c = sc.nextInt()

    var n = when {
        c - b <= 0 -> -1
        else -> {
            a / (c - b) + 1
        }
    }

    if (n <= 0){
        println(-1)
    }
    else println("$n")
}

fun shortSol() = print(readLine()!!.split(' ').map{it.toInt()}.let{(a,b,c)->if(c-b<1)-1 else a/(c-b)+1})