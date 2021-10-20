package dataStructure.heap

class Heap<E>(capacity: Int = DEFAULT_CAPACITY){
    var array = arrayOfNulls<Any>(capacity)
    var size = 0

    // 받은 인덱스의 부모 노드 인덱스를 반환
    private fun getParent(index: Int): Int {
        return index / 2
    }

    // 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
    private fun getLeftChild(index: Int): Int {
        return index * 2
    }

    // 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
    private fun getRightChild(index: Int): Int {
        return index * 2 + 1
    }

    companion object {
        private const val DEFAULT_CAPACITY = 10 // 기본 용량
    }

    // 용량 초과 시 용량 증가하는 함수
    private fun resize(newCapacity: Int) {

        // 새로 만들 배열
        val newArray = arrayOfNulls<Any>(newCapacity)

        // 새 배열에 기존에 있던 배열의 요소들  복사
        for (i in 1..size) {
            newArray[i] = array[i]
        }

        array = newArray
    }

    fun add(value: E) {

        // 용량이 꽉 차있을 경우 용적을 두 배로 늘려준다.
        if (size + 1 == array.size) {
            resize(array.size * 2)
        }
        array[size+1] = value
        trickleUp(size + 1, value as Comparable<E>) // 가장 마지막에 추가 되는 위치와 넣을 값(타겟)을 넘겨줌
        size++ // 정상적으로 재배치가 끝나면 사이즈를 증가
    }

    private fun swap(from: Int, to: Int) {
        val tmp= array[from] as E
        array[from] = array[to]
        array[to] = tmp
    }

    private fun trickleUp(idx: Int, target: Comparable<E>){

        val parent = getParent(idx)
        val parentVal = array[parent] as E

        if (idx <= 1){
            return
        }

        if (target > parentVal){
            swap(idx, parent)
            trickleUp(parent, target)
        }
    }

    fun remove(): E{
        val removeVal = array[1] as E
        if (array[1] == null){
            throw NoSuchElementException()
        }

        swap(1,size--)
//        array[1] = array[size]
//        array[size] = null
//        size--
        trickleDown(1)

        return removeVal

    }

    private fun trickleDown(parent: Int){
        val left = getLeftChild(parent)
        val right = getRightChild(parent)

        // 마지막 노드가 왼쪽 자식 밖에 없을 때 왼쪽 자식이 클 때
        if (left == size && (array[parent] as Comparable<E>) < (array[left] as E)){
            swap(parent,left)
            return
        }
        // 마지막에 오른쪽 자식이 클 때
        if (right == size && (array[parent] as Comparable<E>) > (array[left] as E)){
            swap(parent,right)
            return
        }

        // 마지막에 부모가 클 때 (밑에 자식이 없을 때)
        if (left > size || right > size)
            return

        // 왼쪽 자식이 클 때
        if (array[left] as Comparable<E> > array[right] as E && array[parent] as Comparable<E> < array[left] as E) {
            swap(parent, left)
            trickleDown(left)
        }
        // 오른쪽 자식이 클 때
        else if (array[parent] as Comparable<E> < array[right] as E){
            swap(parent, right)
            trickleDown(right)
        }
    }
}

fun main() {
    val heap = Heap<Int>()
    for (i in 1..5){
        heap.add(i)
    }
    println(heap.array.contentToString())

    repeat(heap.size){
        heap.remove()
    }
    println(heap.array.contentToString())

}