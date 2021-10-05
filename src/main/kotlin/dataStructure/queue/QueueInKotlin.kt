package dataStructure.queue

import java.util.*
import java.util.Queue

fun main() {
    val queue = arrayListOf<Int>()

    //add() 함수를 이용해 마지막에 값 추가
    queue.add(1)
    queue.add(2)
    queue.add(3)

    //removeAt(0) : 첫 번째 값 삭제
    queue.removeAt(0)

    val queueByJava: Queue<Int> = LinkedList()

    queueByJava.add(1)
    queueByJava.add(2)
    queueByJava.add(3)

    queueByJava.remove()
}