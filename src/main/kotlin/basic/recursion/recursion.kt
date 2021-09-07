package basic.recursion

import algorithm.sort.ArrayUtil.printMeasuredTime
import kotlin.time.ExperimentalTime

object recursion {
    //loop 를 이용한 factorial
    fun factorialLoop(n: Int) {
        var result = 1
        for (number in 1..n) {
            result *= number
        }
        println("factorial - loop : $result")
    }

    // 공재귀를 이용한 factorial
    fun factorialRecursion(n: Int, result: Int = 1): Int {
        return if (n <= 0){
            result
        } else{
            factorialRecursion( n-1, n*result)
        }
    }

    // 재귀를 이용한 factorial
    fun factorialRecursion2(n: Int): Int {
        println(n)
        if (n <= 1){
            return 1
        }
        return n * factorialRecursion2(n-1)
    }

    // 재귀 앞에 tailrec 이 붙임
    tailrec fun tailfactorialRecursion2(n: Int): Int {
        println(n)
        if (n <= 1){
          return 1
        }
        return n * tailfactorialRecursion2(n-1)
    }

    // 공재귀 / 재귀 stack 비교 시험 결론: 둘 다 비슷한 스택을 쌓는다.
    fun recursionTest(n: Int, result: Int = 1): Int {
        return if (n <= 0){
            result
        } else{
            recursionTest( n-1, n+result)
        }
    }
    fun recursionTest2(n: Int): Int {
        if (n <= 1){
            return 1
        }
        return n + recursionTest2(n-1)
    }

    // 꼬리 재귀를 이용한 factorial -> 컴파일 과정에서 반복문으로 바뀜
    tailrec fun tailFactorialRecursion(n: Int, result: Int = 1): Int {
        return if (n <= 0){
            result
        } else{
            factorialRecursion(n-1, n+result)
        }
    }
}

@ExperimentalTime
fun main(){
//    recursion.factorialLoop(10)
//    println(recursion.factorialRecursion(100000))

//    println(recursion.recursionTest(100000))

    print("재귀 ")
    printMeasuredTime(){
        recursion.tailfactorialRecursion2(10000)
    }


//    print("꼬리 재귀")
//    printMeasuredTime(){
//        recursion.recursionTest2(10000)
//    }
//    println(recursion.recursionTest2(10000))
//    println(recursion.factorialRecursion3(100000))
//    recursion.factorialRecursion2(5)
}
