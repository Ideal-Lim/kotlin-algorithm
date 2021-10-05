package dataStructure.queue

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class QueueByLinkedList {
    val list = LinkedList<Int>()
    class LinkedList<T> {
        data class Node<T>(
            var data: T?,
            var next: Node<T>?
        )

        var headNode: Node<T>? = null
        var lastNode: Node<T>? = null

        var currentSize: Int = 0

        fun addLast(data: T) {
            val newNode = Node(data, null)
            //headNode 가 비어있는 경우 즉, 요소가 없는 경우
            if (headNode == null) {
                headNode = newNode
                lastNode = newNode
                currentSize++
                return
            }
            lastNode?.next = newNode
            lastNode = newNode
            currentSize++
        }

        fun removeFirst() : T?{
            var returnValue: T?
            // Empty List
            if (headNode == null) {
                return null
            }
            // headNode == lastNode -> 요소 1개
            if (headNode == lastNode) { // or headNode.next == null or currentSize == 1
                returnValue = headNode?.data
                lastNode = null
                headNode = null
            } else {
                returnValue = headNode?.data
                headNode = headNode?.next
            }
            currentSize--
            return returnValue
        }

    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val testTime = br.readLine()!!.toInt()
    val queue = QueueByLinkedList()

    repeat(testTime){
        val st = StringTokenizer(br.readLine())
        val order = st.nextToken()
        when (order){
            "push" -> {
                queue.list.addLast(st.nextToken().toInt())
            }
            "pop" ->{
                if(queue.list.currentSize == 0) bw.write("-1\n") else bw.write("${queue.list.removeFirst()}\n")
            }
            "front" -> {
                if (queue.list.currentSize == 0) bw.write("-1\n") else bw.write("${queue.list.headNode?.data}\n")
            }
            "back" -> {
                if (queue.list.currentSize == 0) bw.write("-1\n") else bw.write("${queue.list.lastNode?.data}\n")

            }
            "empty" -> {
                if (queue.list.currentSize == 0) bw.write("1\n") else bw.write("0\n")
            }
            "size" -> bw.write("${queue.list.currentSize}\n")
        }
    }
    bw.flush()
    bw.close()
}