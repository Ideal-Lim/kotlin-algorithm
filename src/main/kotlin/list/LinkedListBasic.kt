package list


class LinkedList<T> {

    data class Node<T>(
        var data: T?,
        var next: Node<T>?
    )

    private var headNode: Node<T>? = null
    private var lastNode: Node<T>? = null

    var currentSize: Int = 0

    fun addFirst(data: T){
        val newNode = Node(data, headNode)
        headNode = newNode
        if (lastNode == null){ // lastNode가 없을 때 즉, 요소가 아무것도 없을 때
            lastNode = headNode
        }
        currentSize++
    }

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

    fun add(data:T, index: Int = currentSize){
        //index 범위 체크
        if (index > currentSize) throw IndexOutOfBoundsException("out of index")
        // 이전/다음 노드 초기화
        var prevNode: Node<T>? = null
        val nextNode: Node<T>? = findData(index)
        // 이전 노드 찾기
        if(index != 0){
            prevNode = findData(index - 1)
        }
        //
        when {
            // 이전 노드가 없으면 -> index = 0
            prevNode == null -> addFirst(data)
            // 다음 노드가 없으면 -> index = currentSize
            nextNode == null -> addLast(data)
            // 이전 / 노드 둘 다 있으면 -> 0 < index < currentSize
            else -> {
                val newNode = Node(data, nextNode)
                prevNode.next = newNode
                currentSize++
            }
        }
    }

    private fun findData(index: Int): Node<T>? {
        var currentNode = headNode

        repeat(index){
            currentNode = currentNode?.next
        }
        return currentNode
    }

//    fun addLast1(data: T){
//        val newNode = Node(data, null)
//        //headNode 가 비어있는 경우 즉, 요소가 없는 경우
//        if (headNode == null){
//            headNode = newNode
//            currentSize++
//            return
//        }
//        // tmp 가 null 일 수 없음.
//        var tmp = headNode
//        while(tmp?.next != null){
//           tmp = tmp.next
//        }
//        tmp?.next = newNode
//        currentSize++
//    }

    private fun removeFirst(){
        // Empty List
        if (headNode == null){
            return
        }
        // headNode == lastNode -> 요소 1개
        if (headNode == lastNode){ // or headNode.next == null or currentSize == 1
            lastNode = null
            headNode = null
        }
        else {
            headNode = headNode?.next
        }
        currentSize--
    }

    private fun removeLast(){
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
        prevNode?.next = null
        lastNode = prevNode
        currentSize--
    }

    fun remove(index: Int){
        if (index > currentSize) throw IndexOutOfBoundsException("out of index")
        // 이전/다음 노드 초기화
        var prevNode: Node<T>? = null
        val deleteNode: Node<T>? = findData(index)
        // 이전 노드 찾기
        if(index != 0){
            prevNode = findData(index - 1)
        }
        //
        when {
            // 이전 노드가 없으면 -> index = 0
            prevNode == null -> removeFirst()
            // 다음 노드가 없으면 -> index = currentSize
            deleteNode == null -> removeLast()
            // 이전 / 노드 둘 다 있으면 -> 0 < index < currentSize
            else -> {
                prevNode.next = deleteNode.next
                deleteNode == null
                currentSize--
            }
        }
    }

    fun contains(data: Comparable<T>): Boolean{
        var currentNode = headNode
        while (currentNode != null){
            if (data.compareTo(currentNode.data!!) == 0){
                return true
            }
            currentNode = currentNode.next
        }
        return false
    }

    fun removeElement(data: Comparable<T>): Boolean{
        var currentNode = headNode
        var prevNode: Node<T>? = null

        while(currentNode != null){
            if (data.compareTo(currentNode.data!!) == 0){
                prevNode?.next = currentNode.next
                currentNode.next = null
                currentSize--
                return true
            }
            prevNode = currentNode
            currentNode = currentNode.next
        }
        return false
    }

    fun clear(){
        for (i in 0 until currentSize){
            removeFirst()
        }
    }

    fun printLinkedList(){
        var str = "["
        var currentNode = headNode ?: return println("[]")

        while (currentNode != lastNode){
            str += "${currentNode?.data},"
            currentNode = currentNode.next!!
        }
        str += currentNode.data
        println("$str]")
    }



}

fun main() {
    val linkedList = LinkedList<Int>()
    for (i in 0 until 10){
        linkedList.add(i)
    }
    linkedList.remove(3)
    linkedList.removeElement(6)
    println(linkedList.contains(10))
    linkedList.clear()
    linkedList.printLinkedList()
}