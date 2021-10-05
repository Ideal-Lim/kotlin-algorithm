package dataStructure.queue

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * 백준 18258번 - 큐2
 */

class Queue(var capacity: Int){
    var size = 0

    var arr = IntArray(capacity)

    var front = capacity / 2
    var last = front

    fun enqueue(element: Int){

        //용량이 0 ,1 일 때
        when (capacity){
            0, 1 -> {
                newArrayFromArr()
                arr[last] = element
                last++
                size++
                return
            }
        }

        // 꽉찼는지 검사
        if(last - front == -1) { // 배열이 꽉 찬 경우 (데이터를 넣을 공간이 1개 남은 경우)
            newArrayFromArr()
            arr[last] = element
            last++
            size++
            return
        }

        // emptyArray
        if (last == front) {
            arr[last] = element
            last++
            size++
            return
        }

        // 배열에 여유공간 있을 때
        if (last < capacity){ // 배열 마지막 index 초과 x
            arr[last] = element
            last++
            size++
        }
        else { // 배열 마지막 index 초과
            last = 0
            arr[last] = element
            last++
            size++
        }
    }

    private fun newArrayFromArr(){
        // 데이터 옮기기
        capacity += 10
        val tmpArr = IntArray(capacity)
        front = capacity / 2
        last = front
        for (element in arr){
            if (last < capacity){
                if (element != 0){
                    tmpArr[last] = element
                    last++
                }
            }
            else {
                last = 0
                tmpArr[last] = element
                last++
            }
        }
        arr = tmpArr
    }

    fun dequeue(): Int{
        var returnValue: Int
        if(front < capacity){
            returnValue = arr[front]
            arr[front] = 0
            front++
            size--
        }
        else {
            front = 0
            returnValue = arr[front]
            arr[front] = 0
            front++
            size--
        }
        return returnValue
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testTime = br.readLine()!!.toInt()
    val queue = Queue(testTime)
    repeat(testTime){
        val st = StringTokenizer(br.readLine())
        val order = st.nextToken()
        when (order){
            "push" -> {
                queue.enqueue(st.nextToken().toInt())
            }
            "pop" ->{
                if(queue.size == 0) bw.write("-1\n") else bw.write("${queue.dequeue()}\n")
            }
            "front" -> {
                if(queue.size == 0) bw.write("-1\n") else bw.write("${queue.arr[queue.front]}\n")
            }
            "back" -> {
                if (queue.size == 0) bw.write("-1\n") else {
                    if (queue.last != 0) bw.write("${queue.arr[queue.last - 1]}\n") else bw.write("${queue.arr.last()}\n")
                }
            }
            "empty" -> {
                if(queue.size == 0) bw.write("1\n") else bw.write("0\n")
            }
            "size" -> bw.write("${queue.size}\n")
        }
    }
    bw.flush()
    bw.close()
}

//fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
//    val testTime = readLine()!!.toInt()
//    val queue = Queue(testTime)
//    repeat(testTime){
//        val st = StringTokenizer(this.readLine())
//        val order = st.nextToken()
//        when (order){
//            "push" -> {
//                queue.enqueue(st.nextToken().toInt())
//            }
//            "pop" ->{
//                if(queue.size == 0) println(-1) else println(queue.dequeue())
//            }
//            "front" -> {
//                if (queue.size == 0) println(-1) else println(queue.arr[queue.front])
//            }
//            "back" -> {
//                if (queue.size == 0) println(-1) else {
//                    if (queue.last != 0) println(queue.arr[queue.last - 1]) else println(queue.arr.last())
//                }
//
//            }
//            "empty" -> {
//                if (queue.size == 0) println(1) else println(0)
//            }
//            "size" -> println(queue.size)
//        }
//    }
//}

//fun main() {
//    val queue = Queue(1)
//
//    repeat(11){
//        queue.enqueue(1)
//    }
//    println(queue.arr.contentToString())
//    repeat(11){
//        queue.dequeue()
//    }
//    println(queue.arr.contentToString())
//
//}