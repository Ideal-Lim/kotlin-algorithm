package dataStructure.stack

/**
 * 백준 10828번 - 스택
 */

import dataStructure.list.LinkedList
import org.jetbrains.annotations.TestOnly
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


/**
 * 배열을 이용한 스택 구현
 */
class StackByArray {
    var capacity = 100000
    var size = 0
    var arr = IntArray(capacity)

    fun push(element: Int){
        if (size < capacity){
            arr[size] = element
            size++
        }
        else {
            // 데이터 옮기기
            val tmpArr = IntArray(capacity + 10)
            for (i in arr.indices){
                tmpArr[i] = arr[i]
            }
            arr = tmpArr

            capacity += 10
            arr[size] = element
            size++
        }
    }

    fun pop(){
        println(arr[size - 1])
        arr[size - 1] = 0
        size--
    }
}


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = StackByArray()

    val testTime = readLine()!!.toInt()

    for (i in 1..testTime){
        val st = StringTokenizer(this.readLine())
        val order = st.nextToken()
        when (order){
            "push" -> {
                stack.push(st.nextToken().toInt())
            }
            "top" -> {
                if (stack.size == 0) println(-1) else println(stack.arr[stack.size - 1])
            }
            "empty" -> {
                if (stack.size == 0) println(1) else println(0)
            }
            "pop" ->{
                if(stack.size == 0) println(-1) else stack.pop()
            }
            "size" -> println(stack.size)
        }
    }
}