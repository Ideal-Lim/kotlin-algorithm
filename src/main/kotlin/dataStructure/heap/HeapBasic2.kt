package dataStructure.heap

import java.util.Comparator
import java.util.NoSuchElementException


/**
 * Comparator Comparable 2가지 경우로 비교하는 Heap 구현
 */

class Heap2<E>(capacity: Int = DEFAULT_CAPACITY, val comparator: Comparator<in E?>? = null) {
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
        trickleUp(size + 1, value) // 가장 마지막에 추가 되는 위치와 넣을 값(타겟)을 넘겨줌
        size++ // 정상적으로 재배치가 끝나면 사이즈를 증가
    }

    private fun trickleUp(idx: Int, target: E) {
        // comparator가 존재할 경우 comparator 을 인자로 넘겨줌
        if (comparator != null) {
            trickleUpComparator(idx, target, comparator)
        } else {
            trickleUpComparable(idx, target)
        }
    }

    private fun trickleUpComparable(idx: Int, target: E) { // idx : 마지막 index, target : 추가할 노드
        // root 노드보다 클 때까지만 탐색한다.
        // 타겟노드가 비교 될 수 있도록 한 변수를 만든다.
        var idx = idx
        val comp = target as Comparable<E?>
        while (idx > 1) {
            val parent = getParent(idx) // 삽입노드의 부모노드 인덱스 구하기
            val parentVal = array[parent]!! // 부모노드의 값
            // 타겟 노드 값이 부모노드보다 작으면 반복문 종료
            if (comp.compareTo(parentVal as E) <= 0) { // 최소 힙 구현 원할 시 >=0
                break
            }
            /*
             부모노드가 타겟노드보다 클 때
             -> 현재 삽입 될 위치에 부모노드 값으로 교체하고
             -> 타겟 노드의 위치를 부모노드의 위치로 변경한다.
             */
            array[idx] = parentVal
            idx = parent
        }
        // 최종적으로 삽입될 위치에 타겟 노드 값을 저장한다.
        array[idx] = comp
    }
    

    private fun trickleUpComparator(idx: Int, target: E, comp: Comparator<in E?>) {
        var idx = idx
        while (idx > 1) {
            val parent = getParent(idx)
            val parentVal: Any = array[parent]!!

            if (comp.compare(target, parentVal as E) <= 0) { 
                break
            }

            array[idx] = parentVal
            idx = parent
        }
        array[idx] = target
    }

    fun remove(): E {
        if (array[1] == null) {    // 만약 root가 비어있을경우 예외를 던지도록 함
            throw NoSuchElementException()
        }
        val result = array[1] as E // 삭제된 요소를 반환하기 위한 임시 변수
        val target = array[size] as E // 타겟이 될 요소
        array[size] = null // 타겟 노드를 비운다.

        // 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
        trickleDown(1, target) // 루트 노드가 삭제되므로 1을 넘겨준다.
        return result
    }

    private fun trickleDown(idx: Int, target: E) {

        if (comparator != null) {
            trickleDownComparator(idx, target, comparator)
        } else {
            trickleDownComparable(idx, target)
        }
    }

    private fun trickleDownComparable(idx: Int, target: E) {
        val comp = target as Comparable<E?>
        array[idx] = null
        size--
        var parent = idx
        var child: Int
        while (getLeftChild(parent).also { child = it } <= size) {
            val right = getRightChild(parent)
            var childVal = array[child]!!
            if (right <= size && (childVal as Comparable<E?>).compareTo(array[right] as E) > 0) {
                child = right
                childVal = array[child]!!
            }
            if (comp.compareTo(childVal as E) <= 0) {
                break
            }
            array[parent] = childVal
            parent = child
        }
        array[parent] = comp
        if (array.size > DEFAULT_CAPACITY && size < array.size / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.size / 2))
        }
    }
    
    private fun trickleDownComparator(idx: Int, target: E, comp: Comparator<in E?>) {
        array[idx] = null // 삭제 할 인덱스의 노드를 삭제
        size--
        var parent = idx // 삭제노드부터 시작 할 부모를 가리키는 변수
        var child: Int // 교환 될 자식을 가리키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
        while (getLeftChild(parent).also { child = it } <= size) {
            val right = getRightChild(parent) // 오른쪽 자식 인덱스
            var childVal = array[child]!! // 왼쪽 자식의 값 (교환 될 값) 

            /*
             *  오른쪽 자식 인덱스가 size를 넘지 않으면서
             *  왼쪽 자식이 오른쪽 자식보다 큰 경우
             *  재배치 할 노드는 작은 자식과 비교해야하므로 child와 childVal을
             *  오른쪽 자식으로 바꿔준다.
             */
            if (right <= size && comp.compare(childVal as E, array[right] as E) > 0) {
                child = right
                childVal = array[child]!!
            }

            // 재배치 할 노드가 자식 노드보다 작을경우 반복문을 종료한다. 
            if (comp.compare(target, childVal as E) <= 0) {
                break
            }

            /*
             *  현재 부모 인덱스에 자식 노드 값을 대체해주고
             *  부모 인덱스를 자식 인덱스로 교체
             */
            array[parent] = childVal
            parent = child
        }

        // 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
        array[parent] = target

        /*
         *  용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우
         *  용적을 반으로 줄임(단, 최소용적보단 커야함)
         */
        if (array.size > DEFAULT_CAPACITY && size < array.size / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.size / 2))
        }
    }
}

fun main() {
    val heap = Heap2<Int>()
    for (i in 1..10){
        heap.add(i)
    }
    println(heap.array.contentToString())

    for (i in 1..heap.size){
        heap.remove()
    }
    println(heap.array.contentToString())
}



