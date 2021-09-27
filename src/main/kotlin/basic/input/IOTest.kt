package basic.input

import java.util.*

fun main(args:Array<String>){
    // 1. readLine()
//    print("입력할 값 : ")
//    val value1 = readLine()
//    val value2 = readLine()
//    println("입력 값 : $value ,$value2")
//    print("입력 크기 : ")
//    val size: Int = readLine()!!.toInt()
//    val arr = Array<Int>(size) { readLine()!!.toInt() }
//    var sum = 0
//    for (item in arr) {
//        sum+=item
//    }
//    println("Sum: $sum")

    //2. Scanner()
    val sc = Scanner(System.`in`)
    print("입력할 값: ")
    val value3 = sc.nextInt()
    val value4 = sc.nextInt()
    println("입력 값: $value3, $value4")
}


