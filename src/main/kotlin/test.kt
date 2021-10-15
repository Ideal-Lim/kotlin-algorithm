import java.util.*
import kotlin.math.pow

class Heap<E>(capacity: Int = DEFAULT_CAPACITY, comparator: Comparator<in E?>? = null) {
    val array = arrayOfNulls<Object>(capacity)
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
}

fun main() {
    val checkW = Array(8){
        if (it % 2 ==0 ) CharArray(8){ if (it % 2 == 0) 'W' else 'B' }
        else CharArray(8){ if (it % 2 == 0) 'B' else 'W' }
    }
    val checkB = Array(8){
        if (it % 2 ==0 ) CharArray(8){ if (it % 2 == 0) 'B' else 'W' }
        else CharArray(8){ if (it % 2 == 0) 'W' else 'B' }
    }

    println(checkW.contentDeepToString())
    println(checkB.contentDeepToString())

}