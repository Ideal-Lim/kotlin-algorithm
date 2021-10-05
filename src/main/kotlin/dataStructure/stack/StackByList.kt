package dataStructure.stack

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class StackByList(){
    val list = LinkedList<Int>()
    class LinkedList<T> {
        data class Node<T>(
            var data: T?,
            var next: Node<T>?
        )

        private var headNode: Node<T>? = null
        var lastNode: Node<T>? = null

        var currentSize: Int = 0

        fun addLast(data: T){
            val newNode = Node(data, null)
            //headNode 가 비어있는 경우 즉, 요소가 없는 경우
            if (headNode == null){
                headNode = newNode
                lastNode = newNode
                currentSize++
                return
            }
            lastNode?.next = newNode
            lastNode = newNode
            currentSize++
        }
        private fun removeFirst(){
            // Empty List
            if (headNode == null){
                return
            }
            // headNode == lastNode -> 요소 1개
            if (headNode == lastNode){ // or headNode.next == null or currentSize == 1
                println(lastNode?.data)
                lastNode = null
                headNode = null
            }
            else {
                headNode = headNode?.next
            }
            currentSize--
        }

        fun removeLast(){
            //Empty List
            if (headNode == null){
                return
            }
            // 요소 1개
            if (headNode == lastNode){
                return removeFirst()
            }
            //임시 포인터
            var currentNode = headNode
            var prevNode: Node<T>? = null
            //lastNode 이전 노드 즉 마지막에서 두번째 node
            while (currentNode != lastNode){
                prevNode = currentNode
                currentNode = currentNode?.next
            }
            // currentNode == lastNode
            println(currentNode?.data)
            prevNode?.next = null
            lastNode = prevNode
            currentSize--
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val stack = StackByList()

    val testTime = readLine()!!.toInt()

    for (i in 1..testTime){
        val st = StringTokenizer(this.readLine())
        val order = st.nextToken()
        when (order){
            "push" -> {
                stack.list.addLast(st.nextToken().toInt())
            }
            "top" -> {
                if (stack.list.currentSize == 0) println(-1) else println(stack.list.lastNode?.data)
            }
            "empty" -> {
                if (stack.list.currentSize == 0) println(1) else println(0)
            }
            "pop" ->{
                if(stack.list.currentSize == 0) println(-1) else stack.list.removeLast()
            }
            "size" -> println(stack.list.currentSize)
        }
    }
}